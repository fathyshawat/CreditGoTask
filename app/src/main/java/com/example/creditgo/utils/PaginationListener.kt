package com.example.creditgo.utils

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class PaginationListener(private val layoutManager: LinearLayoutManager) :
    RecyclerView.OnScrollListener() {

    companion object {
        val PAGE_START = 1
    }

    /**
     * Set scrolling threshold here (for now i'm assuming 100 item in one page)
     */
    val PAGE_SIZE = 15

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
        Log.d("adfadfad",visibleItemCount.toString()+" "+ firstVisibleItemPosition)
        Log.d("adfadfad",totalItemCount.toString()+" "+ totalItemCount)
        Log.d("adfadfad", isLoading().toString())

        if (isLoading()) {
            if (visibleItemCount + firstVisibleItemPosition >= totalItemCount &&
                firstVisibleItemPosition >= 0 && totalItemCount >= PAGE_SIZE
            ) {
                loadMoreItems()
            }
        }
    }

    abstract fun loadMoreItems()


    abstract fun isLoading(): Boolean
}
