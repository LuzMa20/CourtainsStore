package com.luzmag.courtainsstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.room.Room
import com.luzmag.courtainsstore.room_database.CourtainStoreDB
import com.luzmag.courtainsstore.room_database.product
import com.luzmag.courtainsstore.room_database.sale
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class SaleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sale)
    }
    fun onSave(view: View) {
        val btnSaveS: View? = findViewById(R.id.btn_SaveS)
        val date: EditText = findViewById(R.id.edt_Date)
        val idSeller: EditText = findViewById(R.id.edt_Seller)
        val nameCl: EditText = findViewById(R.id.edt_Client)
        val type: EditText = findViewById(R.id.edt_Type)
        val quantity: EditText = findViewById(R.id.edt_Quantity)
        val valueSale: EditText = findViewById(R.id.edt_Value)
        val room: CourtainStoreDB = Room.databaseBuilder(this.applicationContext, CourtainStoreDB::class.java,
            "CourtainStoreDataBase").build()
        val sale = sale (0, date.text.toString(), idSeller.text.toString(), nameCl.text.toString(), type.text.toString(),
            quantity.text.toString(),
            valueSale.text.toString())

        val saleDAO = room.saleDAO()
        runBlocking {
            val launch = launch {
                var result = saleDAO.insertTask(task = sale)
                val dialog = AlertDialog.Builder(this@SaleActivity).setTitle("OK!")
                    .setMessage("Venta Registrada Exitosamente!").create().show()
                finish()
            }
        }
    }

}