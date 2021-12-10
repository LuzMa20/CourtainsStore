package com.luzmag.courtainsstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }
    fun onSale(view: View) {
        val intento = Intent(this, SaleActivity::class.java)
        startActivity(intento)
    }
    fun onProduct(view: View) {
        val intento = Intent(this, ProductActivity::class.java)
        startActivity(intento)
    }
    fun onAdvance(view: View) {
        val intento = Intent(this, AdvanceActivity::class.java)
        startActivity(intento)
    }

}