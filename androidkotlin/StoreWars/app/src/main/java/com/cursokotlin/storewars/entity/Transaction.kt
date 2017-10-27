package com.cursokotlin.storewars.entity

/**
 * Created by samila on 13/10/17.
 */
data class Transaction (var id : Long,
                        val card_number: String,
                        val cardOwnerName : String,
                        val expireDate : String = "",
                        val CVV : Int,
                        val transactionValue : Double,
                        val dateTime : Long)

data class TransactionApi (val card_number: String,
                           val value : Double,
                           val cvv : String,
                           val card_holder_name : String,
                           val exp_date : String)