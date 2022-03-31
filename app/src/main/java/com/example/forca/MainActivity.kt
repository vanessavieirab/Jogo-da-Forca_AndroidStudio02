package com.example.forca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import model.Fachada
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var jogo: Fachada
    private lateinit var viewDica: TextView
    private lateinit var viewPalavra: TextView
    private lateinit var viewInfos: TextView
    private lateinit var inputLetra: EditText
    private lateinit var jogar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jogo = Fachada()
        jogo.registrarPadrao()
        jogo.iniciar()
        viewDica = findViewById(R.id.tv_dica)
        viewDica.text = jogo.dica()
        viewPalavra = findViewById(R.id.tv_palavra)
        viewPalavra.text = jogo.palavra()
        viewInfos = findViewById(R.id.tv_infos)
        viewInfos.text = jogo.status()
        inputLetra = findViewById(R.id.inputLetra)
        jogar = findViewById(R.id.buttonJogar)
        jogar.setOnClickListener(click())
    }

    inner class click: View.OnClickListener {
        override fun onClick(p0: View?) {
            val letra = inputLetra.text.toString()
            jogo.jogar(letra.trim())
            viewPalavra.text = jogo.palavra()
            viewInfos.text = jogo.status()
            if (jogo.terminou()) {
                jogar.isEnabled = false
            }
        }

    }
}