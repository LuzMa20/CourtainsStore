package com.luzmag.courtainsstore

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.room.Room
import com.luzmag.courtainsstore.room_database.CourtainStoreDB
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)

    }

    fun onLogin(view: View) {
        val room: CourtainStoreDB = Room.databaseBuilder(this.applicationContext, CourtainStoreDB::class.java,
            "CourtainStoreDataBase").build()
        val edtEmail = edtEmail.text.toString()
        val edtPassword = edtPassword.text.toString()
        val sellerDAO = room.sellerDAO()
        runBlocking {
            val launch = launch {
                var result = sellerDAO.findById(edtEmail)
                if (edtPassword == result.password){
                    val intento = Intent(this@MainActivity, MenuActivity::class.java)
                    startActivity(intento)
                } else {
                    val dialog = AlertDialog.Builder(this@MainActivity).setTitle("ERROR!")
                        .setMessage("Invalid Username or Password!").create().show()
                }
            }
        }
   }

    fun onRegister(view: View) {
        val intento = Intent(this, RegisterActivity::class.java)
        startActivity(intento)
    }
}