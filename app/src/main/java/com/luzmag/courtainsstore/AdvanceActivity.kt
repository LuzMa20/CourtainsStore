package com.luzmag.courtainsstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.room.Room
import com.luzmag.courtainsstore.room_database.CourtainStoreDB
import com.luzmag.courtainsstore.room_database.advance
import com.luzmag.courtainsstore.room_database.sale
import com.luzmag.courtainsstore.room_database.saleDAO
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class AdvanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advance)
    }
    fun onSave(view: View) {
        val btnSaveA: View? = findViewById(R.id.btn_SaveA)
        val date: EditText = findViewById(R.id.edt_Date)
        val SaleId: EditText = findViewById(R.id.edt_Sale)
        val valueAdvance: EditText = findViewById(R.id.edt_Advance)
        val room: CourtainStoreDB = Room.databaseBuilder(
            this.applicationContext, CourtainStoreDB::class.java,
            "CourtainStoreDataBase"
        ).build()
        val advance =
            advance(0, SaleId.text.toString(), date.text.toString(), valueAdvance.text.toString())

        val advanceDAO = room.advanceDAO()
        runBlocking {
            val launch = launch {
                var result = advanceDAO.insertTask(task = advance)
                val dialog = AlertDialog.Builder(this@AdvanceActivity).setTitle("OK!")
                    .setMessage("Abono Registrado Exitosamente!").create().show()
                finish()
            }
        }
    }

}