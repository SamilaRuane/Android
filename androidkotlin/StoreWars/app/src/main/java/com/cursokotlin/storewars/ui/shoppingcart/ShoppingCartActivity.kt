package com.cursokotlin.storewars.ui.shoppingcart

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.AdapterView
import android.widget.ListView

import com.cursokotlin.storewars.R
import com.cursokotlin.storewars.adapters.ItemShoppingCartAdapter
import com.cursokotlin.storewars.entity.StarWarsItem
import com.cursokotlin.storewars.ui.transaction.TransactionActivity
import kotlinx.android.synthetic.main.activity_shopping_cart.*
import android.R.string.cancel



class ShoppingCartActivity : AppCompatActivity(), ShoppingCartContract.View, View.OnClickListener, AdapterView.OnItemClickListener {


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

        txt_total_value.text = totalValue.toString()

        list_view_itens.adapter = mAdapter

        list_view_itens.onItemClickListener = this
        btn_finish.setOnClickListener(this)

    }

    override fun onShoppingCartLoaded(list: MutableList<StarWarsItem>) {

        itensList.clear()
        itensList.addAll(list)
        totalValue = calculate()

        if(mAdapter != null)
        mAdapter!!.notifyDataSetChanged()
    }

    fun calculate () : Double {
       return itensList.sumByDouble {it.price}
    }

    override fun onClick(v: View?) {
        val intent = Intent (this, TransactionActivity::class.java)
        if (v?.id == R.id.btn_finish){
          intent.putExtra("total", totalValue.toString())
            startActivity(intent)
        }
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        val builder = AlertDialog.Builder (this)
        builder.setMessage("Você realmente deseja excluir este item?")
        builder.setCancelable(true)
        builder.setPositiveButton("Sim", {dialog, which -> mShoppingCartPresenter.deleteItem(position)
            mShoppingCartPresenter.getShoppingCartItens()})

        builder.setNegativeButton("Não", { dialog, which -> dialog.cancel() })

        val alert = builder.create()
        alert.show ()


    }
}
