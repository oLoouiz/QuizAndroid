package com.example.quiz

import com.example.quiz.QuestionActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.quiz.databinding.ActivityMainBinding
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null

    fun getCurrentUser(): FirebaseUser? {
        val auth = FirebaseAuth.getInstance()
        return auth.currentUser
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (getCurrentUser() == null) {
            val providers = arrayListOf(
                AuthUI.IdpConfig.EmailBuilder().build())
            startActivityForResult(
                AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(providers)
                    .build(), 0
            )
        }

        else {
            Toast.makeText(this,"Já logado!", Toast.LENGTH_LONG).show()
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN

        var input = binding!!.inputEmail

        binding!!.buttonLogin.setOnClickListener{
            if(binding!!.inputEmail.text.toString().isEmpty()){
                Toast.makeText(this,"Enter your email",Toast.LENGTH_SHORT).show()
            }
                else{
                    var intent = Intent(this, com.example.quiz.QuestionActivity::class.java)
                    intent.putExtra("${setData.name}", input.text.toString())
                    startActivity(intent)
                    finish()
            }


        }


    }
}