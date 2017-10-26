package com.cursokotlin.storewars.ui.main


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.cursokotlin.storewars.R
import com.cursokotlin.storewars.adapters.ItemAdapter
import com.cursokotlin.storewars.entity.StarWarsItem
import com.cursokotlin.storewars.repository.remote.RetrofitManager
import kotlinx.android.synthetic.main.fragment_itens_grid.view.*

/**
 * Created by samila on 13/10/17.
 */

class ItensFragment : Fragment, MainContract.View,AdapterView.OnItemClickListener, RetrofitManager.OnReponse {

    lateinit var itens : ArrayList<StarWarsItem>
    lateinit var mGridView : GridView
    lateinit var mTextMsg : TextView
    lateinit var mProgressBar : ProgressBar
    lateinit var mAdapter : ItemAdapter
    lateinit var mPresenter : MainContract.Presenter

    var mIsRunnig = false

    fun newInstance () : ItensFragment {
        val f = ItensFragment ()
        return f
    }

    constructor() : super ()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (itens == null){
            itens = ArrayList<StarWarsItem>()
        }

        mAdapter = ItemAdapter (activity, itens)
        mGridView.adapter = mAdapter

        downloadItens()

    }

    fun downloadItens (){
        mPresenter.getAllItens()
        showProgress(true)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        itens = ArrayList <StarWarsItem>()
        mPresenter = MainPresenter (this, this.context)
        retainInstance = true
        RetrofitManager.setOnResponseListener(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var layout : View = inflater!!.inflate(R.layout.fragment_itens_grid, container, false)
        mTextMsg = layout.findViewById<TextView>(android.R.id.empty)
        mProgressBar = layout.progress_bar
        mGridView = layout.grid_view

        mGridView.emptyView = mTextMsg
        mGridView.onItemClickListener = this

        return layout
    }

    fun showProgress (show : Boolean){

        if(show){
            mTextMsg.text = "Baixando itens da loja..."
        }
        mTextMsg.visibility = if (show) View.VISIBLE else View.GONE
        mProgressBar.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun onResponse(list: List<StarWarsItem>?, success: Boolean) {
        if (success) {
            itens.addAll(list as ArrayList<StarWarsItem>)
            showProgress(false)
            mAdapter.notifyDataSetChanged()
        }else {
           Toast.makeText(context, "Ocorreu um erro durante o Download do itens", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val f : ItemDialogFragment = ItemDialogFragment.newInstance(mGridView.getItemAtPosition(position) as StarWarsItem)

        f.show(fragmentManager.beginTransaction(), "itensDialog")
    }
}
