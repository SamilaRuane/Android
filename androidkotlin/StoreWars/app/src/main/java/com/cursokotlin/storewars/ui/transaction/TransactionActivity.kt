package com.cursokotlin.storewars.ui.transaction

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

import com.cursokotlin.storewars.R
import com.cursokotlin.storewars.entity.Transaction
import com.cursokotlin.storewars.ui.main.MainActivity
import com.github.rtoshiro.util.format.SimpleMaskFormatter
import com.github.rtoshiro.util.format.text.SimpleMaskTextWatcher
import kotlinx.android.synthetic.main.activity_transaction.*
import java.util.*

class TransactionActivity : AppCompatActivity(), View.OnClickListener, TransactionContract.View {

    lateinit var mTransactionPresenter : TransactionContract.Presenter
    lateinit var transaction : Transaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction)

        mTransactionPresenter = TransactionPresenter (this, applicationContext)


        btn_finish_payment.setOnClickListener(this)

        val total = intent.extras
        txt_total.text = total.getString("total")

        val maskCardNumber : SimpleMaskFormatter = SimpleMaskFormatter("NNNN NNNN NNNN NNNN")
        val simpleMaskWatcher : SimpleMaskTextWatcher = SimpleMaskTextWatcher( edt_card_number, maskCardNumber)
        edt_card_number.addTextChangedListener(simpleMaskWatcher)

        val maskCVV : SimpleMaskFormatter = SimpleMaskFormatter("NNN")
        val simpleCVVMaskWatcher : SimpleMaskTextWatcher = SimpleMaskTextWatcher( edt_CVV, maskCVV)
        edt_CVV.addTextChangedListener(simpleCVVMaskWatcher)

        val maskExpirationDate : SimpleMaskFormatter = SimpleMaskFormatter("NN/NN")
        val simpleExpirationDateMaskWatcher : SimpleMaskTextWatcher = SimpleMaskTextWatcher( edt_expiration_date, maskExpirationDate)
        edt_expiration_date.addTextChangedListener(simpleExpirationDateMaskWatcher)



    }

    override fun onClick(v: View?) {
        if(v?.id == btn_finish_payment.id){

            val total = intent.extras
            txt_total.text = total.getString("total")

            val date : Date = Date ()

            if((edt_card_number.text.isEmpty()) ||
                    (edt_card_number.text.isEmpty()) ||
                    (edt_expiration_date.text.isEmpty()) ||
                    (edt_owner_name.text.isEmpty())){
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }else {

                transaction = Transaction(0, edt_card_number.text.toString(),
                        edt_owner_name.text.toString(), edt_expiration_date.text.toString(),
                        Integer.parseInt(edt_CVV.text.toString()), total.getString("total").toDouble(), date.time)

                mTransactionPresenter.save(transaction)
                finish()
                startActivity(Intent(this, MainActivity ::class.java))
            }

        }
    }
}
