package com.danieloliveira138.marvel.components

import androidx.recyclerview.widget.RecyclerView

private const val SCROLL_DOWN = 1

class OnScrollListenerDelegate(val listener: () -> Unit) : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        if (!recyclerView.canScrollVertically(SCROLL_DOWN)) {
            listener.invoke()
        }
        super.onScrolled(recyclerView, dx, dy)
    }
}