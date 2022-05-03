package com.nkechinnaji.simpleweatherapp.extensions

import android.view.View


fun View.visibilityVisible() {
    this.visibility = View.VISIBLE
}

fun View.visibilityInVisible() {
    this.visibility = View.INVISIBLE
}

fun View.visibilityGone() {
    this.visibility = View.GONE
}

fun View.beVisibleIf(visible: Boolean) = if (visible) visibilityVisible() else visibilityGone()

fun View.beGoneIf(beGone: Boolean) = beVisibleIf(!beGone)