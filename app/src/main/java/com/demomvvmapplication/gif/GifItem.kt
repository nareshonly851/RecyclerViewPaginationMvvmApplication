package com.demomvvmapplication.gif

import com.demomvvmapplication.R
import com.demomvvmapplication.data.network.model.Media
import com.demomvvmapplication.data.network.model.Result
import com.demomvvmapplication.databinding.ItemGifBinding
import com.xwray.groupie.databinding.BindableItem

class GifItem(private val media: Result) : BindableItem<ItemGifBinding>() {

    override fun getLayout()= R.layout.item_gif

    override fun bind(viewBinding: ItemGifBinding, position: Int) {

        viewBinding.txtQuotes.text=media.title
        viewBinding.txtAuthor.text=media.itemurl

    }

}