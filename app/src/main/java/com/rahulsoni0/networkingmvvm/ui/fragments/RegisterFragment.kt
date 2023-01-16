package com.rahulsoni0.networkingmvvm.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.rahulsoni0.networkingmvvm.R
import com.rahulsoni0.networkingmvvm.databinding.FragmentRegisterBinding
import com.rahulsoni0.networkingmvvm.models.UserRequest
import com.rahulsoni0.networkingmvvm.utils.NetworkResult
import com.rahulsoni0.networkingmvvm.viewmodels.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private val authViewModel by viewModels<AuthViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.btnLogin.setOnClickListener {
//            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
//        }
        binding.btnSignUp.setOnClickListener {

            authViewModel.registerUser(UserRequest("test@gmail.com", "1111", "test0011"))
//


//
        }

        authViewModel.userResponseLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResult.Success -> {
                    Toast.makeText(requireContext(), "Login successfull", Toast.LENGTH_SHORT).show()

                    findNavController().navigate(R.id.action_registerFragment_to_mainFragment)

                }
                is NetworkResult.Loading -> {
                    Toast.makeText(requireContext(), "Loading.....", Toast.LENGTH_SHORT).show()

                }
                is NetworkResult.Error -> {

                    binding.txtError.setText(it.message)

                }
            }
        }


    }


//    override fun onDestroy() {
//        super.onDestroy()
//        binding = null
//    }


}