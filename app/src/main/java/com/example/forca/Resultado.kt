package com.example.forca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class Resultado : AppCompatActivity() {
    private lateinit var imagem: ImageView
    private lateinit var botao: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        imagem = findViewById(R.id.resultadoimg)
        botao = findViewById(R.id.jogarnovamente)
        if (intent.hasExtra("Resultado")) {
            if (intent.getStringExtra("Resultado") == "Ganhou!") {
                imagem.setImageResource(resources.getIdentifier("youwin", "drawable", packageName))
            }
            else {
                imagem.setImageResource(resources.getIdentifier("gameover", "drawable", packageName))
            }
        }
        botao.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}