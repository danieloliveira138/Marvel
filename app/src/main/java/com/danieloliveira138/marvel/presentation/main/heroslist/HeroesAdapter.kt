package com.danieloliveira138.marvel.presentation.main.heroslist

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danieloliveira138.marvel.model.Result

class HeroesAdapter(
    private val clickListener: (id: Int) -> Unit
) : RecyclerView.Adapter<HeroHolder>() {

    var heroes: MutableList<Result> = mutableListOf()
        set(value) {
            heroes.addAll(value)
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.bind(heroes[position], clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        return HeroHolder.create(parent)
    }

    override fun getItemCount(): Int = heroes.size
}