package com.cursokotlin.storewars.ui.shoppingcart

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import com.cursokotlin.storewars.R
import com.cursokotlin.storewars.adapters.ItemShoppingCartAdapter
import com.cursokotlin.storewars.entity.StarWarsItem
import com.cursokotlin.storewars.ui.transaction.TransactionActivity
import kotlinx.android.synthetic.main.activity_shopping_cart.*




class ShoppingCartActivity : AppCompatActivity(), ShoppingCartContract.View {


    lateinit var itensList : MutableList<StarWarsItem>
     var mAdapter : ItemShoppingCartAdapter? = null
    var totalValue : Double = 0.0
    lateinit var mShoppingCartPresenter : ShoppingCartContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)

        mShoppingCartPresenter = ShoppingCartPresenter (this, applicationContext)
        itensList = mutableListOf()
        mShoppingCartPresenter.getShoppingCartItens()
        mAdapter = ItemShoppingCartAdapter(this, itensList)
        mAdapter!!.notifyDataSetChanged()



        list_view_itens.adapter = mAdapter

        list_view_itens.setOnItemClickListener { parent, view, position, id ->
            val builder = AlertDialog.Builder (this)
            builder.setMessage("Você realmente deseja excluir este item?")
            builder.setCancelable(true)
            builder.setPositiveButton("Sim", {dialog, which -> mShoppingCartPresenter.deleteItem(position)
                mShoppingCartPresenter.getShoppingCartItens()
            })

            builder.setNegativeButton("Não", { dialog, which -> dialog.cancel() })

            val alert = builder.create()
            alert.show ()

        }


        btn_finish.setOnClickListener {
            val intent = Intent (this, TransactionActivity::class.java)
            intent.putExtra("total", totalValue.toString())
            startActivity(intent)
        }

    }

    override fun onShoppingCartLoaded(list: MutableList<StarWarsItem>) {

        itensList.clear()
        itensList.addAll(list)
        totalValue = calculate()
        txt_total_value.text = totalValue.toString()

        if(mAdapter != null)
        mAdapter!!.notifyDataSetChanged()
    }

    fun calculate () : Double {
       return itensList.sumByDouble {it.price}
    }

}
