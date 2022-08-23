package com.example.shoestore

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {


    private val viewModel by viewModels<LoginViewModel>()


    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        setHasOptionsMenu(false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            // go to welcome fragment
            btLogin.setOnClickListener {
                navigateToWelcomeFragment()
            }
            btNewAccount.setOnClickListener {
                navigateToWelcomeFragment()

            }
        }

    }

    // navigate from login to welcome

    private fun navigateToWelcomeFragment() {
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
    }
}