package com.example.androidnavigationexample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.androidnavigationexample.R
import com.example.androidnavigationexample.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment  using data binding
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.button.setOnClickListener { view: View ->
            view.findNavController().navigate(HomeFragmentDirections.actionIdHomeFragmentToIdQuizStartFragment())
        }

        binding.button2.setOnClickListener { view: View ->
            view.findNavController().navigate(HomeFragmentDirections.actionIdHomeFragmentToIdQuestionListFragment())
        }

        binding.button3.setOnClickListener { view: View ->
            view.findNavController().navigate(HomeFragmentDirections.actionIdHomeFragmentToIdQuestionAddFragment())
        }

        return binding.root
    }
}