package com.example.creditgo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.creditgo.R
import com.example.creditgo.databinding.DetailsActivityBinding
import com.example.creditgo.utils.Constants
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {


    private lateinit var binding: DetailsActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = DetailsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val extra = intent.extras
        binding.name.text = extra?.getString(Constants.NAME)
        binding.details.text = extra?.getString(Constants.DETAILS)
        val img = extra?.getString(Constants.IMG)
        if (img != null) {
            Picasso.get().load(img)
                .placeholder(R.drawable.placeholder)
                .into(binding.userImg)
        }

    }
}