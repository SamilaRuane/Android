package repository

import entity.FullParameters
import entity.HTTPResponse
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

abstract class BaseRepository (){

    fun execute (fullParameters:FullParameters) : HTTPResponse {

        val conn:HttpURLConnection
        val response: HTTPResponse

        val url : URL = URL (fullParameters.url + getQuery(fullParameters.parameters))

        conn = url.openConnection() as HttpURLConnection
        conn.readTimeout = 1000000
        conn.connectTimeout = 120000
        conn.requestMethod = fullParameters.method.toString()

        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
        conn.setRequestProperty("charset", "utf-8")

        conn.useCaches = false

        //Request
        conn.connect()

        if (conn.responseCode == 404){

            response = HTTPResponse(conn.responseCode, "")
        } else {
            val inputStream:InputStream = conn.inputStream

            response = HTTPResponse(conn.responseCode, getStringFromInputString (inputStream))
        }

        return response
    }

    fun getQuery (parameters: Map<String, String>):String{

        if(parameters.isEmpty())
            return ""

        val result:StringBuilder = StringBuilder()
        var first:Boolean = true

        for (param in parameters) {
            if(first){
                result.append("?")
                first = false
            } else {
                result.append("&")
            }

            result.append(URLEncoder.encode((param.key), "UTF-8"))
            result.append("=")
            result.append(URLEncoder.encode((param.value), "UTF-8"))
    }

        println("Result:  ${result.toString()}")
        return result.toString()

    }

    fun getStringFromInputString(inputStream: InputStream):String{

        try{

            val stringBuilder:StringBuilder = StringBuilder()
            val br:BufferedReader = BufferedReader(InputStreamReader(inputStream))

            for (line in br.readLines()){
                stringBuilder.append(line)
            }

            return stringBuilder.toString()
        }catch(e:Exception) {
            return ""
        }
    }

}