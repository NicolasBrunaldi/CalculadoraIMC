package br.com.dio.bootcamp.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.dio.bootcamp.calculadoraimc.model.Pessoa

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val usuario = Pessoa(nome = nome_EDT, altura = altura_EDT, peso = peso_EDT)
    }
}