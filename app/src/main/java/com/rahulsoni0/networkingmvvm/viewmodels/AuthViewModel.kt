package com.rahulsoni0.networkingmvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahulsoni0.networkingmvvm.models.UserRequest
import com.rahulsoni0.networkingmvvm.models.UserResponse
import com.rahulsoni0.networkingmvvm.repository.UserRepository
import com.rahulsoni0.networkingmvvm.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    val userResponseLiveData: LiveData<NetworkResult<UserResponse>>
        get() = userRepository.userResponseLiveData

    fun registerUser(userRequest: UserRequest) {
        viewModelScope.launch {
            userRepository.registerUser(userRequest)
        }


    }

    fun loginUser(userRequest: UserRequest) {
        viewModelScope.launch {
            userRepository.loginUser(userRequest)
        }
    }


}