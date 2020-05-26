package com.example.lejosremote.log

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.lejosremote.R
import com.example.lejosremote.databinding.LogFragmentBinding


class log_fragment : Fragment() {

    private lateinit var viewModel: LogFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: LogFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.log_fragment,
            container,
            false
        )

        viewModel = ViewModelProviders.of(this).get(LogFragmentViewModel::class.java)

        binding.mainViewModel = viewModel
        binding.lifecycleOwner = this

        //gestion du bouton retour
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true /* enabled by default */) {
                override fun handleOnBackPressed() { // Handle the back button event
                    findNavController().navigate(log_fragmentDirections.actionLogFragmentToAdminFragment())
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)

        return binding.root
    }

}
