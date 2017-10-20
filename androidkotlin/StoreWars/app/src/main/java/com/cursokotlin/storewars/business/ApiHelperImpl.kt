package com.cursokotlin.storewars.business

import com.cursokotlin.storewars.entity.HTTPResponse
import com.cursokotlin.storewars.entity.Parameters
import com.cursokotlin.storewars.entity.StarWarsItem
import com.cursokotlin.storewars.infra.EndpointConstants
import com.cursokotlin.storewars.infra.Method
import com.cursokotlin.storewars.repository.StarWarsItensHTTP
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by samila on 13/10/17.
 */
class ApiHelperImpl {
    companion object {

        fun getAllItens(): List<StarWarsItem> {

            val url: String = EndpointConstants.BASE.URL
            val parameters: Parameters = Parameters(url, Method.GET)
            val response: HTTPResponse = StarWarsItensHTTP.getAllItens(parameters)

            return Gson().fromJson(response.jsonResponse, object : TypeToken<List <StarWarsItem>>() {}.type)
        }
    }
}