package com.cursokotlin.storewars.repository

import com.cursokotlin.storewars.entity.HTTPResponse
import com.cursokotlin.storewars.entity.Parameters
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by samila on 13/10/17.
 */
abstract class BaseHTTP (){

    fun execute (parameters : Parameters) : HTTPResponse{

        val conn : HttpURLConnection
        val response : HTTPResponse

        val url : URL = URL(parameters.url)

        conn = url.openConnection() as HttpURLConnection
        conn.readTimeout = 10000
        conn.connectTimeout = 20000
        conn.requestMethod = parameters.method.toString()

        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
        conn.setRequestProperty("charset", "utf-8")

        conn.useCaches = false

        conn.connect()

        if(conn.responseCode == 404){
            response = HTTPResponse(conn.responseCode, "")
        }else {
            val inputStream :InputStream = conn.inputStream
            response = HTTPResponse (conn.responseCode, getStringFromInputStream (inputStream))
        }

        return response

    }

    fun getStringFromInputStream (inputStream : InputStream) : String {

        try{

            val stringBuilder : StringBuilder = StringBuilder()
            val br:BufferedReader = BufferedReader(InputStreamReader(inputStream))

            for (line in br.readLines()){
                stringBuilder.append(line)
            }

            return stringBuilder.toString()

        }catch (e : Exception){
            return ""
        }
    }
}