package com.cursokotlin.storewars.ui.shoppingcart

import com.cursokotlin.storewars.entity.StarWarsItem

/**
 * Created by samila on 16/10/17.
 */
interface ShoppingCartContract {
    interface View{
       fun onShoppingCartLoaded (list:MutableList <StarWarsItem>)
    }

    interface Presenter {
        fun getShoppingCartItens ()
        fun deleteItem (position : Int)
    }
}