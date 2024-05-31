package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val edtPeso = findViewById<TextInputEditText>(R.id.edt_text_peso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edt_text_altura)
        val btnCalculo = findViewById<Button>(R.id.btn_calcular)



        btnCalculo.setOnClickListener {
            val pesoStr = edtPeso.text.toString()
            val alturaStr = edtAltura.text.toString()

            if (pesoStr == "" || alturaStr == "") {
                Snackbar.make(
                    edtPeso,
                    "Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                ).show()

            } else {
                val peso = pesoStr.toFloat()
                val altura = alturaStr.toFloat()

                val resultado = peso / (altura * altura)
            }

        }
    }

}