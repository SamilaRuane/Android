package com.cursokotlin.storewars.ui.main

import com.cursokotlin.storewars.entity.StarWarsItem

/**
 * Created by samila on 15/10/17.
 */
interface MainContract {

    interface View {

    }

    interface Presenter {
        fun getAllItens()
        fun saveShopping (itens : List <StarWarsItem>)

    }
}