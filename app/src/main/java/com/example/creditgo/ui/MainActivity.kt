package com.example.creditgo.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.creditgo.R
import com.example.creditgo.databinding.ActivityMainBinding
import com.example.creditgo.model.DataResponseItem

import com.example.creditgo.utils.*
import com.example.creditgo.utils.PaginationListener.Companion.PAGE_START
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ClickListener {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    private var userAdapter: UsersAdapter? = null
    private var layoutManagerCars: LinearLayoutManager? = null
    private var currentPage: Int = PAGE_START
    private var isLoading = false
    private lateinit var usersList: ArrayList<DataResponseItem>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        layoutManagerCars = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        usersList = ArrayList()
        userAdapter = UsersAdapter(usersList)
        binding.recycler.apply {
            adapter = userAdapter
            layoutManager = layoutManagerCars
        }

        mainViewModel.getData(currentPage)
        getCarsListener()

        binding.recycler.addOnScrollListener(object : PaginationListener(layoutManagerCars!!) {
            override fun loadMoreItems() {
                isLoading = false
                currentPage++
                mainViewModel.getData(currentPage)
                getCarsListener()
            }

            override fun isLoading(): Boolean = isLoading


        })


    }

    private fun getCarsListener() {
        lifecycleScope.launchWhenStarted {
            mainViewModel.getData(currentPage).collectLatest { event ->
                when (event) {
                    is Resource.Error -> {
                        binding.progress.visibility = View.GONE
                        isLoading = false
                        if (event.data.isNullOrEmpty()) {
                            Toast.makeText(
                                this@MainActivity,
                                event.error?.localizedMessage,
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            userAdapter?.insertAll(event.data as ArrayList<DataResponseItem>)
                            userAdapter?.setClickListener(this@MainActivity)

                        }
                    }

                    is Resource.Loading -> {
                        binding.progress.visibility = View.VISIBLE
                    }

                    is Resource.Success -> {
                        binding.progress.visibility = View.GONE
                        val users = event.data as ArrayList<DataResponseItem>
                        if (!users.isNullOrEmpty() && !isLoading) {
                            isLoading = true
                            userAdapter?.insertAll(users)
                            userAdapter?.setClickListener(this@MainActivity)
                        } else if (currentPage == 9) {
                            isLoading = false
                        } else if (users.isNullOrEmpty() && currentPage == 1) {
                            Toast.makeText(
                                this@MainActivity,
                                "There is no Items",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }

            }
        }
    }


    override fun click(v: View?, pos: Int) {
        if (v?.id == R.id.card) {
            val intent = Intent(this@MainActivity, DetailsActivity::class.java)
            intent.putExtra(Constants.DETAILS, usersList[pos].description)
            intent.putExtra(Constants.NAME, usersList[pos].name)
            intent.putExtra(Constants.IMG, usersList[pos].owner?.avatarUrlOwner)
            startActivity(intent)

        }
    }

}