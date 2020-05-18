package com.example.lejosremote.admin_pwd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.lejosremote.R
import com.example.lejosremote.databinding.AdminPwdFragmentBinding


class admin_pwd : Fragment() {

    private lateinit var viewModel: AdminPwdViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding: AdminPwdFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.admin_pwd_fragment,
            container,
            false
        )

        viewModel = ViewModelProviders.of(this).get(AdminPwdViewModel::class.java)

        binding.mainViewModel = viewModel
        binding.lifecycleOwner = this

        //gestion de la connexion au volet admin
        val btn = binding.connect
        btn.setOnClickListener({
            viewModel.update(binding.pwdField.text.toString())
        })

        viewModel.eventMdpOk.observe(viewLifecycleOwner, Observer { mdp ->
            if (mdp) {
                findNavController().navigate(admin_pwdDirections.actionAdminPwdToAdminFragment())
            }
        })

        //gestion du bouton retour
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true /* enabled by default */) {
                override fun handleOnBackPressed() { // Handle the back button event
                    findNavController().navigate(admin_pwdDirections.actionAdminPwdToMainFragment())
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)

        return binding.root
    }



}
