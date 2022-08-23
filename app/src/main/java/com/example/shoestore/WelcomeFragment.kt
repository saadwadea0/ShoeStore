package com.example.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestore.databinding.WelcomeScreenBinding

class WelcomeFragment : Fragment() {


    private lateinit var binding: WelcomeScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.welcome_screen, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: Use the ViewModel
        binding.btNext.setOnClickListener {
            //go to instruction fragment
            navigateToInstructionFragment()
        }
    }

    // navigate from login to instruction
    private fun navigateToInstructionFragment() {
        findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment())
    }
}