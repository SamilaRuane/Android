package com.cursokotlin.storewars.entity

/**
 * Created by samila on 13/10/17.
 */
data class Transaction (var id : Long,
                        val cardNumber : String,
                        val cardOwnerName : String,
                        val expireDate : String = "",
                        val CVV : Int,
                        val transactionValue : Double,
                        val dateTime : Long)