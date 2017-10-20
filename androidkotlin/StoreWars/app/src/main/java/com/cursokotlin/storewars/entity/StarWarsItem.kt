package com.cursokotlin.storewars.entity

import java.io.Serializable

/**
 * Created by samila on 13/10/17.
 */
data class StarWarsItem (val title : String,
                         val price : Double,
                         val seller : String,
                         val thumbnailHd : String) : Serializable