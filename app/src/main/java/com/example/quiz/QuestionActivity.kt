package com.example.quiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quiz.QuestionData
import com.example.quiz.R
import com.example.quiz.databinding.ActivityQuestionBinding
import com.example.quiz.setData


public class QuestionActivity: AppCompatActivity() {

    private var name:String?=null
    private var score:Int=0
    private var binding: ActivityQuestionBinding? = null
    private var posicaoAtual: Int = 1
    private var questionList: ArrayList<QuestionData>? = null
    private var selectedOption: Int = 0

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        name=intent.getStringExtra(setData.name)

        val progress_bar = binding!!.progressBar
        val progress_text = binding!!.progressText
        val textoPergunta = binding!!.textoPergunta
        val opc1 = binding!!.opc1
        val opc2 = binding!!.opc2
        val opc3 = binding!!.opc3
        val opc4 = binding!!.opc4
        val opc5 = binding!!.opc5
        val responder = binding!!.botaoResponder

        questionList = setData.getQuestion()

        setQuestion()

        opc1.setOnClickListener {
            selectedOptionStyle(opc1, 1)
        }
        opc2.setOnClickListener {
            selectedOptionStyle(opc2, 2)
        }
        opc3.setOnClickListener {
            selectedOptionStyle(opc3, 3)
        }
        opc4.setOnClickListener {
            selectedOptionStyle(opc4, 4)
        }
        opc5.setOnClickListener {
            selectedOptionStyle(opc5, 5)
        }

        responder.setOnClickListener {
            if (selectedOption != 0) {
                val question = questionList!![posicaoAtual - 1]
                if (selectedOption != question.resposta) {
                    setColor(selectedOption, R.drawable.wrong_question_option)
                }else{
                    score++;
                }

                setColor(question.resposta, R.drawable.correct_question_option)
                if (posicaoAtual == questionList!!.size) {
                    responder.text = "Sair"
                } else {
                    responder.text = "Ir para próxima pergunta"
                }
            } else {
                posicaoAtual++
                when {
                    posicaoAtual <= questionList!!.size -> {
                        setQuestion()
                    }
                    else -> {
                        var intent= Intent(this, Result::class.java)
                        intent.putExtra(setData.name, name.toString())
                        intent.putExtra(setData.score, score.toString())
                        intent.putExtra("tamanhototal", questionList!!.size.toString())

                        startActivity(intent)
                        finish()
                    }
                }
            }
            selectedOption= 0
        }
    }

    private fun setColor(opt: Int, color: Int) {
        when (opt) {
            1 -> {
                binding!!.opc1.background = ContextCompat.getDrawable(this, color)
            }
            2 -> {
                binding!!.opc2.background = ContextCompat.getDrawable(this, color)
            }
            3 -> {
                binding!!.opc3.background = ContextCompat.getDrawable(this, color)
            }
            4 -> {
                binding!!.opc4.background = ContextCompat.getDrawable(this, color)
            }
            5 -> {
                binding!!.opc5.background = ContextCompat.getDrawable(this, color)
            }
        }
    }

    private fun setQuestion() {
        setOptionStyle()

        val question = questionList!![posicaoAtual - 1]

        binding!!.progressBar.progress = posicaoAtual
        binding!!.progressBar.max = questionList!!.size

        binding!!.progressText.text = "${posicaoAtual}/${binding!!.progressBar.max}"

        binding!!.textoPergunta.text = question.question
        binding!!.opc1.text = question.opcao_um
        binding!!.opc2.text = question.opcao_dois
        binding!!.opc3.text = question.opcao_tres
        binding!!.opc4.text = question.opcao_quatro
        binding!!.opc5.text = question.opcao_cinco
    }

    private fun setOptionStyle() {
        val optionList: ArrayList<TextView> = arrayListOf()
        optionList.add(0, binding!!.opc1)
        optionList.add(1, binding!!.opc2)
        optionList.add(2, binding!!.opc3)
        optionList.add(3, binding!!.opc4)
        optionList.add(4, binding!!.opc5)

        for (op in optionList) {
            op.setTextColor(Color.parseColor("#555151"))
            op.background = ContextCompat.getDrawable(this, R.drawable.question_option)
            op.typeface = Typeface.DEFAULT
        }
    }

    private fun selectedOptionStyle(view: TextView, opt: Int) {
        setOptionStyle()
        selectedOption = opt
        view.background = ContextCompat.getDrawable(this, R.drawable.selected_question_option)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))
    }
}
