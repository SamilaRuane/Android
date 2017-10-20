package com.cursokotlin.storewars.ui.main


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.cursokotlin.storewars.R
import com.cursokotlin.storewars.ui.shoppingcart.ShoppingCartActivity
import com.cursokotlin.storewars.ui.transaction.TransactionListActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_loja, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.action_shopping_cart -> startActivity(Intent (this, ShoppingCartActivity ::class.java))
            R.id.action_transaction_list -> startActivity(Intent (this, TransactionListActivity::class.java))
        }

        return super.onOptionsItemSelected(item)
    }
}
