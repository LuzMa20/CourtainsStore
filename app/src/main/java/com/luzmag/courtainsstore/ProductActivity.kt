package com.luzmag.courtainsstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.room.Room
import com.google.android.gms.tasks.Task
import com.luzmag.courtainsstore.room_database.CourtainStoreDB
import com.luzmag.courtainsstore.room_database.product
import com.luzmag.courtainsstore.room_database.seller
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
    }

    fun onSave(view: View) {
        val btnSaveP: View? = findViewById(R.id.btn_SaveP)
        val code: EditText = findViewById(R.id.edt_Pcode)
        val type: EditText = findViewById(R.id.edt_Ptype)
        val price: EditText = findViewById(R.id.edt_Pprice)
        val color: EditText = findViewById(R.id.edt_Pcolor)
        val room: CourtainStoreDB = Room.databaseBuilder(this.applicationContext, CourtainStoreDB::class.java,
            "CourtainStoreDataBase").build()
        val product = product (0, code.text.toString(),type.text.toString(), color.text.toString(), price.text.toString())
        val productDAO = room.productDAO()
        runBlocking {
            val launch = launch {
                var result = productDAO.insertTask(task = product)
                val dialog = AlertDialog.Builder(this@ProductActivity).setTitle("OK!")
                    .setMessage("Producto Registrado Exitosamente!").create().show()
                finish()
            }
        }
    }
}