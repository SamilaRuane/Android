package com.cursokotlin.storewars.repository

import com.cursokotlin.storewars.repository.db.TransactionRepository
import com.cursokotlin.storewars.repository.remote.ApiHelper

/**
 * Created by samila on 15/10/17.
 */
interface DataManager : TransactionRepository, SharedPreferenceHelper, ApiHelper