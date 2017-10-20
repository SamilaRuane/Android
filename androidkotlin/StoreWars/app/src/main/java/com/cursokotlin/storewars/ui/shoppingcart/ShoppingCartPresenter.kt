package com.cursokotlin.storewars.ui.shoppingcart

import android.content.Context
import com.cursokotlin.storewars.entity.StarWarsItem
import com.cursokotlin.storewars.repository.DataManager
import com.cursokotlin.storewars.repository.DataManagerImpl

/**
 * Created by samila on 16/10/17.
 */
class ShoppingCartPresenter : ShoppingCartContract.Presenter {

    val mView : ShoppingCartContract.View
    val mDataManager : DataManager

    constructor(view: ShoppingCartContract.View, ctx:Context){
        mView = view
        mDataManager = DataManagerImpl (ctx)
    }


    override fun getShoppingCartItens() {
        mView.onShoppingCartLoaded(mDataManager.recoveryShoppingCart())
    }

    override fun deleteItem(position : Int) {
            var list : MutableList<StarWarsItem> = mDataManager.recoveryShoppingCart()
            list.removeAt(position)
            mDataManager.saveShopping(list)
    }
}