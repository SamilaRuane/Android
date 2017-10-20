package com.cursokotlin.storewars.adapters




import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.cursokotlin.storewars.R
import com.cursokotlin.storewars.entity.StarWarsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*


/**
 * Created by samila on 13/10/17.
 */
class ItemAdapter : BaseAdapter{

     var ctx : Context
     var itemList : List <StarWarsItem>

    constructor(ctx: Context, itemList: List<StarWarsItem>) : super() {
        this.ctx = ctx
        this.itemList = itemList
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val item : StarWarsItem = itemList[position]
        val view : View = LayoutInflater.from(ctx).inflate(R.layout.item, parent, false)


        Picasso.with(ctx).load(item.thumbnailHd).into(view.img_item_main)
        view.txt_product_name.text = item.title
        view.txt_product_price.text = item.price.toString()

        return view

    }

    override fun getItem(position: Int): Any = itemList[position]


    override fun getItemId(position: Int): Long  = position.toLong()

    override fun getCount(): Int  = itemList.size


}