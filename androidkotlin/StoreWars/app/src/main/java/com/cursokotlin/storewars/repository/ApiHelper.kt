package com.cursokotlin.storewars.repository

import com.cursokotlin.storewars.entity.StarWarsItem

/**
 * Created by samila on 18/10/17.
 */
interface ApiHelper{

    fun getAllItens(): List<StarWarsItem>

}