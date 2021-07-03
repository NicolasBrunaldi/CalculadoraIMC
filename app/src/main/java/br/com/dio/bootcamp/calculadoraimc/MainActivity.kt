package br.com.dio.bootcamp.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.dio.bootcamp.calculadoraimc.model.Pessoa
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calcularButton.setOnClickListener(){
            try {

                    val usuario = Pessoa(nome = nome_EDT.text.toString(), altura = altura_EDT.text.toString().toDouble(), peso = peso_EDT.text.toString().toDouble())
                    calculaEexibeIMC(usuario)
                    }catch (e: Exception){
                    Snackbar.make(findViewById(R.id.mainActivity,), "Preencha os campos corretamente", Snackbar.LENGTH_SHORT).show()
                }

        }

    }

    fun calculaEexibeIMC(usuario: Pessoa) {

        if(usuario.altura != null && usuario.peso != null){
            val resultadoImc = usuario.peso/ (usuario.altura * usuario.altura)
            val dec = DecimalFormat("#,###.0")
            val resultadoImcFormatado = dec.format(resultadoImc)
            resultado_grupo.visibility = View.VISIBLE
            when(resultadoImc){
                in Double.MIN_VALUE..18.5 -> {resultado.text = "${usuario.nome}, seu IMC é: $resultadoImcFormatado e está abaixo do ideal"}
                in 18.6..24.9 ->{resultado.text = "${usuario.nome}, seu IMC é: $resultadoImcFormatado e está ideal"}
                in 25.0..29.9 ->{resultado.text = "${usuario.nome}, seu IMC é: $resultadoImcFormatado e está indicando sobrepeso"}
                in 30.0..34.9 ->{resultado.text = "${usuario.nome}, seu IMC é: $resultadoImcFormatado e está indicando obesidade de grau I"}
                in 35.9..39.9 ->{resultado.text = "${usuario.nome}, seu IMC é: $resultadoImcFormatado e está indicando obesidade de grau II"}
                in 40.0..Double.MAX_VALUE ->{resultado.text = "${usuario.nome}, seu IMC é: $resultadoImcFormatado e está indicando obesidade de grau III"}

            }
        }
    }
}
