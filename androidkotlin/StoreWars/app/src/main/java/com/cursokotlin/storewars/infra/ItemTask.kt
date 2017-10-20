package com.cursokotlin.storewars.infra

import android.os.AsyncTask
import com.cursokotlin.storewars.entity.StarWarsItem

/**
 * Created by samila on 13/10/17.
 */
class ItemTask : AsyncTask <Void, Void, List <StarWarsItem>> () {

    override fun onPostExecute(result: List<StarWarsItem>?) {
        super.onPostExecute(result)
    }

    override fun onPreExecute() {
        super.onPreExecute()

    }

    override fun doInBackground(vararg params: Void?): List<StarWarsItem> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}