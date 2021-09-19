package com.example.viewmodeldemo.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodeldemo.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.timer.observe(viewLifecycleOwner, {
            Log.d(MainFragment.toString(), "New value: $it")
            it?.let {
                binding.textTimer.text = "${it / 60}:${it % 60}"
            }
        })
        binding.btnStart.setOnClickListener {
            viewModel.start()
        }
        binding.btnPause.setOnClickListener {
            viewModel.pause()
        }
        binding.btnStop.setOnClickListener {
            viewModel.stop()
        }
    }
}