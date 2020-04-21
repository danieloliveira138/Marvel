package com.danieloliveira138.marvel.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.danieloliveira138.marvel.R
import com.danieloliveira138.marvel.model.Thumbnail
import com.danieloliveira138.marvel.util.MarvelImageUtils


fun ImageView.load(thumbnail: Thumbnail) {
    val url = MarvelImageUtils.SQUARE_FANTASTIC.getImgUrl(thumbnail)

    Glide.with(this.context)
        .load(url.toClearTextTrafficPermitted())
        .placeholder(R.drawable.marvel_place_holder)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}