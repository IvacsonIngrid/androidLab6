package com.example.androidnavigationexample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidnavigationexample.R

import android.app.Activity
import android.content.Intent
import android.provider.ContactsContract
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.androidnavigationexample.databinding.FragmentStartBinding

class QuizStartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentStartBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_start, container, false)
        binding.startButton.setOnClickListener{
            this.findNavController().navigate(QuizStartFragmentDirections.actionIdQuizFragmentToQuestionFragment())
        }

        binding.chooseButton.setOnClickListener{
            var i = Intent(Intent.ACTION_PICK)
            i.type = ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE
            startActivityForResult(i, 111)
        }

        return binding.root
    }
}