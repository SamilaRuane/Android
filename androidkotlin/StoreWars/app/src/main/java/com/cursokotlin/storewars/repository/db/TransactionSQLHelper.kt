package com.cursokotlin.storewars.repository.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by samila on 15/10/17.
 */
class TransactionSQLHelper : SQLiteOpenHelper{

    companion object {


        val TABLE_NAME = "dbTransaction"
        val COLUMN_ID = "_id"
        val COLUMN_VALUE = "value"
        val COLUMN_DATEANDTIME = "date"
        val COLUMN_CARD_LAST_NUMBERS = "card_numbers"
        val COLUMN_OWNER_NAME = "owner_name"
    }



    constructor(context: Context?) : super(context, "dbTransaction", null, 1)

    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL(
                "CREATE TABLE ${TABLE_NAME} (${COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT,${COLUMN_OWNER_NAME} TEXT NOT NULL, ${COLUMN_CARD_LAST_NUMBERS} INTEGER NOT NULL, ${COLUMN_DATEANDTIME} INTEGER NOT NULL, ${COLUMN_VALUE} REAL NOT NULL)" )

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}