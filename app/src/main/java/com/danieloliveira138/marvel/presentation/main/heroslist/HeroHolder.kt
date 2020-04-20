package com.danieloliveira138.marvel.presentation.main.heroslist

import android.view.View
import android.view.ViewGroup
import com.danieloliveira138.marvel.R
import com.danieloliveira138.marvel.extensions.inflate
import com.danieloliveira138.marvel.model.Result
import com.danieloliveira138.marvel.presentation.BaseHolder
import kotlinx.android.synthetic.main.hero_holder.view.*

class HeroHolder(
    itemView: View
) : BaseHolder(itemView) {

    override fun bind(hero: Result, listener: (Int) -> Unit) {
        with(itemView) {
            title.text = hero.name
            setOnClickListener { listener.invoke(hero.id) }
        }

    }

    companion object {
        fun create(parent: ViewGroup): HeroHolder {
            return HeroHolder(parent.inflate(R.layout.hero_holder))
        }
    }
}