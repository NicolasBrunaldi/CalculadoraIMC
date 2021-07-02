package br.com.dio.bootcamp.calculadoraimc.model

class Pessoa(val nome: String?, val peso: Double?, val altura :Double?) {

    override fun toString(): String = "Nome: $nome, peso: $peso, altura: $altura"
}