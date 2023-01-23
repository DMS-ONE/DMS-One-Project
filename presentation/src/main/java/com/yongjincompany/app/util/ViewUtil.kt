package com.yongjincompany.app.util

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadFromUrl(url: String) =
    Glide.with(this.context.applicationContext)
        .load(url)
        .into(this)

 fun View.visible(){
    visibility = View.VISIBLE
}