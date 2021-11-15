package com.example.androidnavigationexample.fragments

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.OnBackPressedCallback
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.androidnavigationexample.R
import com.example.androidnavigationexample.databinding.FragmentQuestionBinding
import com.example.androidnavigationexample.model.Question
import com.example.androidnavigationexample.model.questions
import com.example.androidnavigationexample.model.sumOfTheCorrectAnswers
import android.widget.Toast
import com.example.androidnavigationexample.MainActivity


class QuestionFragment : Fragment() {

    lateinit var binding: FragmentQuestionBinding

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>

    private var questionIndex = 1
    private val numQuestions = 10   //10 kerdesre kell valaszolni


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentQuestionBinding>(
            inflater, R.layout.fragment_question, container, false)
        randomizeQuestions()

        binding.nextButton.setOnClickListener {
            if (processAnswer(it) && questionIndex < numQuestions-1) {    //ezzel nezem, h mikor jar le a 10 kerdes,
//                Show next question                                    //illetve a next gomb feladatat is meghatarozom
                setQuestion()
            }
            else if (processAnswer(it) && questionIndex < numQuestions)
            {
                binding.nextButton.setText("SUBMIT")    //atallitottam a gomb szoveget
                    //Show next question
                setQuestion()
            }
            else {
//                End of the test
                if (processAnswer(it) && questionIndex == numQuestions) {
                    //++sumOfTheCorrectAnswers

                    /*val view = View.inflate(binding.fragments.QuestionFragment, R.layout.dialog_view, null, )

                    val builder = AlertDialog.Builder(this@QuestionFragment)
                    builder.setView(view)

                    val dialog = builder.create()
                    dialog.show()
                    dialog.window.setBackgroundDrawable(android.R.color.transparent)
                    dialog.setCancelMessage(false)

                    view.btn_confirm.setOnClickListener
                    {
                        dialog.dismiss()
                    }*/

//               activate ResultFragment
                    it.findNavController()
                        .navigate(QuestionFragmentDirections.actionQuestionFragmentToResultFragment())

                }
            }
        }

       // requireActivity().onBackPressedDispatcher.addCallback(callback)

        return binding.root
    }

    //  Returns true in case of correct answer otherwise false
    private fun processAnswer(it: View?): Boolean {
        val result = binding.questionRadioGroup.checkedRadioButtonId
//         Do nothing when nothing is selected
        if (result == -1) {
            return false
        }
//    firstButton is selected
        var answerIndex = 0
        when (result) {
            R.id.secondAnswerButton -> answerIndex = 1
            R.id.thirdAnswerButton -> answerIndex = 2
            R.id.fourthAnswerButton -> answerIndex = 3
        }
        if (answers[answerIndex] == currentQuestion.answers[3]) {
            ++sumOfTheCorrectAnswers
            return true
        } else {
            Toast.makeText(this.activity, "Selected answer is wrong", Toast.LENGTH_SHORT).show()
            return true
        }
    }


    private fun showQuestion() {
        questionIndex++
        val index = questionIndex
        val questionTextStr = "$index. " + currentQuestion.text
        binding.questionText.text = questionTextStr
        binding.firstAnswerButton.text = answers[0]
        binding.secondAnswerButton.text = answers[1]
        binding.thirdAnswerButton.text = answers[2]
        binding.fourthAnswerButton.text = answers[3]
//        Clear RadioButton selection
        binding.questionRadioGroup.clearCheck()
    }

    // Sets the question and randomizes the answers.  This only changes the data, not the UI.
    // Calling invalidateAll on the FragmentGameBinding updates the data.
    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        // and shuffle them
        answers.shuffle()
        showQuestion()
    }

    // randomize the questions and set the first question
    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }


}

