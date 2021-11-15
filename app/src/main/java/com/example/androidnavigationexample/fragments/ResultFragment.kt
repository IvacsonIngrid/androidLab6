package com.example.androidnavigationexample.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.androidnavigationexample.R
import com.example.androidnavigationexample.databinding.FragmentResultBinding
import com.example.androidnavigationexample.model.sumOfTheCorrectAnswers


class ResultFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment  using data binding
        val binding: FragmentResultBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_result, container, false)

        binding.resetGameButton.setOnClickListener { view: View ->
            view.findNavController().navigate(ResultFragmentDirections.actionResultFragmentToIdQuizStartFragment())
        }
        val str = "$sumOfTheCorrectAnswers/10 points"
        binding.numberOfQuizzesTextView.text = str
        return binding.root
    }

}