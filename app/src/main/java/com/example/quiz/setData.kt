package com.example.quiz

object setData {

    const val name:String="nome"
    const val score:String="pontuacao"

    fun getQuestion():ArrayList<QuestionData>{
        var que:ArrayList<QuestionData> = arrayListOf()

        var pergunta1 = QuestionData(
            1,

            "Qual é a capital da França?",

            "Londres",
            "Berlim",
            "Paris",
            "Roma",
            "Tóquio",

            3
        )

        var pergunta2 = QuestionData(
            2,
            "Qual é o maior oceano do mundo?",
            "Oceano Pacífico",
            "Oceano Atlântico",
            "Oceano Índico",
            "Oceano Ártico",
            "Oceano Antártico",
            1
        )

        var pergunta3 = QuestionData(
            3,
            "Quem pintou a Mona Lisa?",
            "Leonardo da Vinci",
            "Pablo Picasso",
            "Vincent van Gogh",
            "Michelangelo",
            "Salvador Dalí",
            1
        )

        var pergunta4 = QuestionData(
            4,
            "Qual é a capital da Austrália?",
            "Camberra",
            "Sydney",
            "Melbourne",
            "Brisbane",
            "Perth",
            1
        )

        var pergunta5 = QuestionData(
            5,
            "Quantos elementos químicos existem atualmente na tabela periódica?",
            "118",
            "92",
            "109",
            "103",
            "120",
            1
        )

        var pergunta6 = QuestionData(
            6,
            "Qual é a fórmula química da água?",
            "NaCl",
            "CO2",
            "H20",
            "C6H12O6",
            "CH4 ",
            3
        )

        que.add(pergunta1)
        que.add(pergunta2)
        que.add(pergunta3)
        que.add(pergunta4)
        que.add(pergunta5)
        que.add(pergunta6)
        return que
    }

}