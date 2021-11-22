package com.example.androidnavigationexample.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.androidnavigationexample.R
import com.example.androidnavigationexample.MainViewModel
import com.example.androidnavigationexample.model.Question
import androidx.navigation.fragment.findNavController

class QuestionAddFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_question_add, container, false)
        Log.d("xxx", "AddFragment - onCreateView")
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        val question: EditText = layout.findViewById(R.id.id_new_question)

        val textView1: EditText = layout.findViewById(R.id.id_answer1)
        val textView2: EditText = layout.findViewById(R.id.id_answer2)
        val textView3: EditText = layout.findViewById(R.id.id_answer3)
        val textView4: EditText = layout.findViewById(R.id.id_answer_correct)

        val button: Button = layout.findViewById(R.id.button4)
        button.setOnClickListener{
            val ans1 = textView1.text.toString()
            val ans2 = textView2.text.toString()
            val ans3 = textView3.text.toString()
            val ans4 = textView4.text.toString()

            val answers = listOf<String>(ans1, ans2, ans3, ans4)

            viewModel.addItem(Question(question.text.toString(), answers))
            findNavController().navigate(R.id.action_id_question_add_fragment_to_id_question_list_fragment)
        }
        return layout
    }
}