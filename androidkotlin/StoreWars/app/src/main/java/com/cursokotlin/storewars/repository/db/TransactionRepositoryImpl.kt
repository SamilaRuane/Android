package com.cursokotlin.storewars.repository.db

import android.content.ContentValues
import android.content.Context
import com.cursokotlin.storewars.entity.Transaction
import java.util.*

/**
 * Created by samila on 15/10/17.
 */
class TransactionRepositoryImpl (ctx:Context) : TransactionRepository {

    var helper : TransactionSQLHelper
    init {
        helper = TransactionSQLHelper(ctx)
    }
     fun insert(transaction: Transaction): Long {
        val db = helper.writableDatabase
        val cv = ContentValues()
         val date = Date()

        cv.put(TransactionSQLHelper.COLUMN_OWNER_NAME, transaction.cardOwnerName)
        cv.put(TransactionSQLHelper.COLUMN_CARD_LAST_NUMBERS, transaction.cardNumber)
        cv.put(TransactionSQLHelper.COLUMN_DATEANDTIME, date.time)
        cv.put(TransactionSQLHelper.COLUMN_VALUE, transaction.transactionValue)

        val id : Long = db.insert(TransactionSQLHelper.TABLE_NAME, null, cv)

        db.close()
       return id
    }

    fun update(transaction: Transaction): Int {
        val db = helper.writableDatabase
        val cv = ContentValues()

        cv.put(TransactionSQLHelper.COLUMN_OWNER_NAME, transaction.cardOwnerName)
        cv.put(TransactionSQLHelper.COLUMN_CARD_LAST_NUMBERS, transaction.cardNumber)
        cv.put(TransactionSQLHelper.COLUMN_DATEANDTIME, Calendar.getInstance().time as Long)
        cv.put(TransactionSQLHelper.COLUMN_VALUE, transaction.transactionValue)

        val changes = db.update(TransactionSQLHelper.TABLE_NAME,
                           cv,
                TransactionSQLHelper.COLUMN_ID + "= ?",
                arrayOf((transaction.id).toString()))

        db.close()
        return changes
    }

    override fun save(transaction: Transaction) {

        if(transaction.id.toInt() == 0) {
            insert(transaction)
        }else{
            update(transaction)
        }
    }

    override fun delete(transaction: Transaction) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun select(query: String?) : MutableList<Transaction> {

        val db = helper.writableDatabase
        val sql = StringBuilder ("SELECT * FROM ${TransactionSQLHelper.TABLE_NAME}")
        var args:Array<String>? = null

        if (query != null){
            sql.append(" $query")
            args = arrayOf(query)
        }

        var list = mutableListOf<Transaction>()
        val cursor = db.rawQuery(sql.toString(), null)

        while (cursor.moveToNext()){
            val id = cursor.getLong(cursor.getColumnIndex(TransactionSQLHelper.COLUMN_ID))
            val ownerName = cursor.getString(cursor.getColumnIndex(TransactionSQLHelper.COLUMN_OWNER_NAME))
            val cardNumber = cursor.getInt(cursor.getColumnIndex(TransactionSQLHelper.COLUMN_CARD_LAST_NUMBERS))
            val dateTime = cursor.getLong(cursor.getColumnIndex(TransactionSQLHelper.COLUMN_DATEANDTIME))
            val value = cursor.getDouble(cursor.getColumnIndex(TransactionSQLHelper.COLUMN_VALUE))

            val item = Transaction(id, cardNumber.toString(), ownerName, "", 0, value, dateTime)

            list.add(item)
        }

        cursor.close()
        db.close()

        return list
    }
}