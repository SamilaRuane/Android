package com.cursokotlin.storewars.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.cursokotlin.storewars.R
import com.cursokotlin.storewars.entity.StarWarsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.shopping_cart_item.view.*

/**
 * Created by samila on 18/10/17.
 */
class ItemShoppingCartAdapter : BaseAdapter{


    var ctx : Context
    var itemList : List <StarWarsItem>


    constructor(ctx: Context, itemList: List<StarWarsItem>) : super() {
        this.ctx = ctx
        this.itemList = itemList
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var layout = LayoutInflater.from(ctx).inflate(R.layout.shopping_cart_item, parent, false)
        val item = itemList[position]
            layout.txt_title.text = item.title
            layout.txt_price.text = item.price.toString()
            layout.txt_seller.text = item.seller


            Picasso.with(ctx).load(item.thumbnailHd).into(layout.img_item_main)
        return layout
    }

    override fun getItem(position: Int): Any = itemList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = itemList.size




}