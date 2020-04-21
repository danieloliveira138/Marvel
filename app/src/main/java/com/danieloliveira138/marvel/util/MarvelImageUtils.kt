package com.danieloliveira138.marvel.util

import com.danieloliveira138.marvel.model.Thumbnail

enum class MarvelImageUtils(val path: String) {

    SQUARE_SMALL ("/standard_small."),
    SQUARE_MEDIUM ("/standard_medium."),
    SQUARE_LARGE ("/standard_large."),
    SQUARE_XLARGE ("/standard_amazing."),
    SQUARE_FANTASTIC ("/standard_fantastic."),
    SQUARE_AMAZING ("/standard_amazing."),
    PORTRAIT_SMALL ("/portrait_small."),
    PORTRAIT_MEDIUM ("/portrait_medium."),
    PORTRAIT_LARGE ("/portrait_large."),
    PORTRAIT_XLARGE ("/portrait_xlarge."),
    PORTRAIT_FANTASTIC ("/portrait_fantastic."),
    PORTRAIT_UNCANNY ("/portrait_uncanny."),
    PORTRAIT_INCREDIBLE ("/portrait_incredible."),
    LANDSCAPE_SMALL ("/landscape_small."),
    LANDSCAPE_MEDIUM ("/landscape_medium."),
    LANDSCAPE_LARGE ("/landscape_large."),
    LANDSCAPE_XLARGE ("/landscape_xlarge."),
    LANDSCAPE_AMAZING ("landscape_amazing."),
    LANDSCAPE_INCREDIBLE ("/landscape_incredible.");

    fun getImgUrl(thumbnail: Thumbnail): String {
        return "${thumbnail.path}${this.path}${thumbnail.extension}"
    }
}