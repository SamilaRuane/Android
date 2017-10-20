package com.cursokotlin.storewars.repository

import android.content.Context
import android.content.SharedPreferences
import com.cursokotlin.storewars.entity.StarWarsItem
import org.json.JSONArray
import org.json.JSONObject

/**
 * Created by samila on 18/10/17.
 */
class SharedPreferencesHelperImpl(context : Context) : SharedPreferenceHelper{

    val SHARED_PREFERENCE_NAME = "ShoppingCart"
    val SHARED_PREFERENCE_ARRAY = "ShoppingCartArray"
    val sharedPreferences : SharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE)


    override fun saveShopping (itens : List <StarWarsItem>){


            val jArray  = JSONArray()

            for (item in itens ){
                val jObj  = JSONObject()
                jObj.put("title", item.title)
                jObj.put("price", item.price.toString())
                jObj.put("seller", item.seller)
                jObj.put("thumbnailHD", item.thumbnailHd)

                jArray.put(jObj)
            }

            sharedPreferences.edit().putString(SHARED_PREFERENCE_ARRAY, jArray.toString()).commit()

    }

    override fun recoveryShoppingCart() : MutableList<StarWarsItem> {

        println("SharedPreferences = ${sharedPreferences.getString(SHARED_PREFERENCE_ARRAY, "")}")
        val jArray: JSONArray
        var jObject = JSONObject()
        var list = mutableListOf<StarWarsItem>()


        if (sharedPreferences.getString(SHARED_PREFERENCE_ARRAY, "").length != 0) {
            jArray = JSONArray(sharedPreferences.getString(SHARED_PREFERENCE_ARRAY, ""))
            var starWarsItem : StarWarsItem
            for (i in 0..(jArray.length()-1)) {
                jObject = jArray.getJSONObject(i)
                starWarsItem = StarWarsItem(jObject.getString("title"),
                        jObject.getString("price").toDouble(),
                        jObject.getString("seller"),
                        jObject.getString("thumbnailHD"))
                list.add(starWarsItem)

            }
            sharedPreferences.edit().clear()
        }

            return list


        }

}