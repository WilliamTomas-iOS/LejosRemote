package com.example.lejosremote.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.lejosremote.R
import com.example.lejosremote.databinding.MainFragmentBinding



class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.main_fragment,
            container,
            false
        )

        //        ligne pour créer le ViewModel une seule fois
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding.mainViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.eventAdmin.observe(viewLifecycleOwner, Observer { admin ->
            if (admin) {
                findNavController().navigate(MainFragmentDirections.actionMainFragmentToAdminPwd())
            }
        })

        viewModel.eventAuto.observe(viewLifecycleOwner, Observer { auto ->
            if (auto) {
                if (binding.auto.text == "Mode auto") {
                    binding.auto.text = "Mode manu"
                }
                else {
                    binding.auto.text = "Mode auto"
                }
            }
        })

        viewModel.mac.observe(viewLifecycleOwner, Observer { mac ->
            if (mac != null) {
                binding.mac.setText(mac)
                viewModel.onNewMacAdress()
            }
        })

        return binding.root
    }

}
