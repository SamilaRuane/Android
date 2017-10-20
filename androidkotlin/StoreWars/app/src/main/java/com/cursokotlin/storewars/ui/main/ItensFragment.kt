package com.cursokotlin.storewars.ui.main


import android.os.AsyncTask
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ProgressBar
import android.widget.TextView
import com.cursokotlin.storewars.R
import com.cursokotlin.storewars.adapters.ItemAdapter
import com.cursokotlin.storewars.entity.StarWarsItem
import com.cursokotlin.storewars.repository.StarWarsItensHTTP
import kotlinx.android.synthetic.main.fragment_itens_grid.*
import kotlinx.android.synthetic.main.fragment_itens_grid.view.*

/**
 * Created by samila on 13/10/17.
 */

class ItensFragment : Fragment, MainContract.View,AdapterView.OnItemClickListener {

             var mTask : ItemTask
    lateinit var itens : ArrayList<StarWarsItem>
    lateinit var mGridView : GridView
    lateinit var mTextMsg : TextView
    lateinit var mProgressBar : ProgressBar
    lateinit var mAdapter : ItemAdapter
    lateinit var mPresenter : MainContract.Presenter

    var mIsRunnig = false

    constructor() : super(){
        mTask = ItemTask()
    }

    fun newInstance () : ItensFragment {
        val f = ItensFragment ()
        return f
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (itens == null){
            itens = ArrayList<StarWarsItem>()
        }

        mAdapter = ItemAdapter (activity, itens)
        mGridView.adapter = mAdapter

        if(!mIsRunnig){
            if(StarWarsItensHTTP.isConnected(activity)){
                downloadItens()
            }else{
                mTextMsg.text = "Sem conexão"
            }
        }else if (mTask.status == AsyncTask.Status.RUNNING) {
            showProgress(true)
        }

    }

    fun downloadItens (){
        if (mTask == null || mTask.status != AsyncTask.Status.RUNNING){
            mTask.execute()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        itens = ArrayList <StarWarsItem>()
        mPresenter = MainPresenter (this, this.context)
        retainInstance = true
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



    inner class ItemTask : AsyncTask<Void, Void, List <StarWarsItem>>() {

        override fun onPostExecute(result: List<StarWarsItem>?) {
            super.onPostExecute(result)
            mIsRunnig = false
            showProgress(false)
            if(result != null) {
                Log.i("SRBS", "On Post Execute ${result.size}")
                itens.clear()
                itens.addAll(result)
                mAdapter.notifyDataSetChanged()
            }else{
                mTextMsg.text = "Falha ao obter Itens"
            }
        }

        override fun onPreExecute() {
            super.onPreExecute()
            showProgress (true)
        }

        override fun doInBackground(vararg params: Void?): List<StarWarsItem> {
            mIsRunnig = true
            return mPresenter.getAllItens()
        }
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val f : ItemDialogFragment = ItemDialogFragment.newInstance(mGridView.getItemAtPosition(position) as StarWarsItem)

        f.show(fragmentManager.beginTransaction(), "itensDialog")



    }
}
