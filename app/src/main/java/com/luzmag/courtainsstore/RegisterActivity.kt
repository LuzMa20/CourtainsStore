package com.luzmag.courtainsstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.room.Room
import com.luzmag.courtainsstore.room_database.CourtainStoreDB
import com.luzmag.courtainsstore.room_database.seller
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }
    fun onSave(view: View) {
        val btnSave: View? = findViewById(R.id.btn_Save)
        val idSeller: EditText = findViewById(R.id.edt_id)
        val nameSeller: EditText = findViewById(R.id.edt_name)
        val email: EditText = findViewById(R.id.edt_email)
        val password: EditText = findViewById(R.id.edt_password)
        val room: CourtainStoreDB = Room.databaseBuilder(this.applicationContext, CourtainStoreDB::class.java,
        "CourtainStoreDataBase").build()
        val seller = seller (idSeller.text.toString(),nameSeller.text.toString(), email.text.toString(), password.text.toString())
        val sellerDAO = room.sellerDAO()
        runBlocking {
            val launch = launch {
                var result = sellerDAO.insertTask(task = seller)
                val dialog = AlertDialog.Builder(this@RegisterActivity).setTitle("OK!")
                    .setMessage("Usuario Registrado Exitosamente!").create().show()
                finish()
           }
       }
   }
    fun onShow(view: View){
        val idSeller: EditText = findViewById(R.id.edt_id)
        val room: CourtainStoreDB = Room.databaseBuilder(this.applicationContext, CourtainStoreDB::class.java,
            "CourtStoreDataBase").build()
        val id = idSeller.text.toString()
        val sellerDAO = room.sellerDAO()
        runBlocking {
            val launch = launch {
                var result = sellerDAO.findById(id)
                val dialog = AlertDialog.Builder(this@RegisterActivity).setTitle("OK!")
                    .setMessage("Usuario Registrado Exitosamente!").create().show()
            }
        }

    }

}