package com.cursokotlin.storewars.ui.main

import android.content.Context
import com.cursokotlin.storewars.entity.StarWarsItem
import com.cursokotlin.storewars.repository.DataManager
import com.cursokotlin.storewars.repository.DataManagerImpl

/**
 * Created by samila on 15/10/17.
 */
class MainPresenter  : MainContract.Presenter {

    val view : MainContract.View
    var mDataManager : DataManager

    constructor(view: MainContract.View, ctx:Context) {
        this.view = view
        mDataManager = DataManagerImpl(ctx)
    }


    override fun getAllItens() {
       mDataManager.getAllItens()
    }

    override fun saveShopping(itens: List<StarWarsItem>) {
        var list : MutableList<StarWarsItem> = recoveryShoppingCart()
        list.addAll(itens)
        mDataManager.saveShopping(list)
    }

    private fun recoveryShoppingCart() : MutableList<StarWarsItem>{
       return mDataManager.recoveryShoppingCart()
    }


}