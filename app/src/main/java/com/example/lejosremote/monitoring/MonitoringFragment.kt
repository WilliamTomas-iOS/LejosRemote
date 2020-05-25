package com.example.lejosremote.monitoring

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.lejosremote.R
import com.example.lejosremote.databinding.MonitoringFragmentBinding


class MonitoringFragment : Fragment() {

    private lateinit var viewModel: MonitoringFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: MonitoringFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.monitoring_fragment,
            container,
            false
        )

        viewModel = ViewModelProviders.of(this).get(MonitoringFragmentViewModel::class.java)

        binding.mainViewModel = viewModel
        binding.lifecycleOwner = this

        //gestion du bouton retour
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true /* enabled by default */) {
                override fun handleOnBackPressed() { // Handle the back button event
                    findNavController().navigate(MonitoringFragmentDirections.actionMonitoringFragmentToAdminFragment())
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)

        viewModel.data.observe(viewLifecycleOwner, Observer { data ->
            if (data.size > 0) {
                binding.batterieVal.text = data[5].toString()
                binding.gyroscopeVal.text = data[1].toString()
                binding.luminositeVal.text = data[3].toString()
                binding.pressionVal.text = data[4].toString()
                binding.moteurDVal.text = data[2].toString()
                binding.moteurGVal.text = data[2].toString()

            }
        })

        return binding.root
    }

}
