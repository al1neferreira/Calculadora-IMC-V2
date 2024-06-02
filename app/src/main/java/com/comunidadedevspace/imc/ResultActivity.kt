package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "Result_KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val resultado = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResultado = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvResultado.text = resultado.toString()

        val classificacao: String =
            if (resultado <= 18.5f) {
                "MAGREZA"
            } else if (resultado > 18.5f && resultado <= 24.9f) {
                "NORMAL"
            } else if (resultado > 25f && resultado <= 29.9f) {
                "OBESIDADE"
            } else {
                "OBESIDADE GRAVE"
            }
        tvClassificacao.text = classificacao
    }
}