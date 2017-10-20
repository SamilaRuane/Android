package com.cursokotlin.storewars.ui.main

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.cursokotlin.storewars.R
import com.cursokotlin.storewars.entity.StarWarsItem
import com.squareup.picasso.Picasso

/**
 * Created by samila on 16/10/17.
 */
class ItemDialogFragment : DialogFragment (), View.OnClickListener, MainContract.View {


    lateinit var mItem : StarWarsItem
    var shoppingCart : ArrayList <StarWarsItem> = ArrayList ()
    lateinit var mMainPresenter : MainContract.Presenter

    companion object {
        fun newInstance (item : StarWarsItem) : ItemDialogFragment{
            var f : ItemDialogFragment =  ItemDialogFragment ()
            var args = Bundle ()
            args.putSerializable("item", item)
            f.arguments = args
            return f
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mItem = arguments.getSerializable("item") as StarWarsItem
        mMainPresenter = MainPresenter (this, context)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layout : View = inflater!!.inflate(R.layout.fragment_dialog_selected_item, container, false)
        val itemTitle = layout.findViewById<TextView>(R.id.txt_item_name)
        val itemPrice = layout.findViewById<TextView>(R.id.txt_item_value)
        val itemSeller = layout.findViewById<TextView>(R.id.txt_seller_name)
        val itemImage = layout.findViewById<ImageView>(R.id.img_thumbnail)
        val btn_add_to_cart = layout.findViewById<ImageView>(R.id.img_add_to_cart)

        btn_add_to_cart.setOnClickListener( this )

        itemTitle.text = mItem.title
        itemPrice.text = mItem.price.toString()
        itemSeller.text = mItem.seller

        Picasso.with(activity).load(mItem.thumbnailHd).into(itemImage)
        return layout
    }

    override fun onClick(v: View?) {

        when (v?.id){
            R.id.img_add_to_cart -> shoppingCart.add(mItem)
        }
        if(shoppingCart.isNotEmpty())
        Log.i("SRBS", "Adicionou item no carrinho ${shoppingCart.size}")
        mMainPresenter.saveShopping(shoppingCart)
        dismiss()
    }
}