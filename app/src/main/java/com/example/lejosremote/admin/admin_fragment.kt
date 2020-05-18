package com.example.lejosremote.admin

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
import com.example.lejosremote.databinding.AdminFragmentBinding


class admin_fragment : Fragment() {

    private lateinit var viewModel: AdminFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: AdminFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.admin_fragment,
            container,
            false
        )

        viewModel = ViewModelProviders.of(this).get(AdminFragmentViewModel::class.java)


        binding.mainViewModel = viewModel
        binding.lifecycleOwner = this

        val btnMac = binding.macOk
        btnMac.setOnClickListener({
            viewModel.onUpdateMac(binding.champMac.text.toString())
        })

        val btnMdp = binding.adminOk
        btnMdp.setOnClickListener({
            viewModel.onUpdateMac(binding.champMdp.text.toString())
        })

        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true /* enabled by default */) {
                override fun handleOnBackPressed() { // Handle the back button event
                    findNavController().navigate(admin_fragmentDirections.actionAdminFragmentToMainFragment())
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)

        return binding.root
    }

}
