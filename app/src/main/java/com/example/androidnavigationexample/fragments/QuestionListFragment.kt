package com.example.androidnavigationexample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidnavigationexample.R

import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidnavigationexample.DataAdapter
import com.example.androidnavigationexample.DataAdapter.OnItemClickListener
import com.example.androidnavigationexample.databinding.FragmentQuestionBinding
import com.example.androidnavigationexample.MainViewModel

class QuestionListFragment : Fragment(), OnItemClickListener {
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_question_list, container, false)
        Log.d("xxx", "ListFragment - onCreateView")

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        // connect RecyclerView to the adapter
        val adapter = DataAdapter(viewModel.list, this)
        val recycler_view: RecyclerView = layout.findViewById(R.id.recycler_view)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this.context)
        recycler_view.setHasFixedSize(true)

        return layout
    }

    override fun onItemClick(position: Int) {
        viewModel.currentPosition = position
        var v =
        findNavController().navigate(R.id.action_question_list_fragment_to_question_detail)
        Log.d("xxx", "AdapterPosition: $position")
    }
}
