package com.danieloliveira138.marvel.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.danieloliveira138.marvel.model.Result

abstract class BaseHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(hero: Result, listener: (Int) -> Unit)

}