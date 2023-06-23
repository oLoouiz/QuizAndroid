package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.quiz.databinding.ActivityMainBinding
import com.example.quiz.databinding.ActivityResultBinding

class Result : AppCompatActivity() {
    var binding: ActivityResultBinding?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN

        val username = intent.getStringExtra(setData.name)
        val score = intent.getStringExtra(setData.score)
        val totalperguntas = intent.getStringExtra("tamanhototal")

        var congo = binding!!.congo
        var pontuacao = binding!!.pontuacao
        var button = binding!!.botao

        congo.text="Parabens! ${username}!!"
        pontuacao.text="${score} / ${totalperguntas}"
        button.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }





    }
}