package com.rahulsoni0.networkingmvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rahulsoni0.networkingmvvm.api.UserApi
import com.rahulsoni0.networkingmvvm.models.UserRequest
import com.rahulsoni0.networkingmvvm.models.UserResponse
import com.rahulsoni0.networkingmvvm.utils.NetworkResult
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(private val userApi: UserApi) {

    private val _userResponseLiveData = MutableLiveData<NetworkResult<UserResponse>>()
    val userResponseLiveData: LiveData<NetworkResult<UserResponse>> //public
        get() = _userResponseLiveData

    suspend fun registerUser(userRequest: UserRequest) {

        _userResponseLiveData.postValue(NetworkResult.Loading())

        val response = userApi.signUp(userRequest)

        handleResponse(response)


    }

    suspend fun loginUser(userRequest: UserRequest) {
        val response = userApi.signin(userRequest)
        handleResponse(response)
    }

    private fun handleResponse(response: Response<UserResponse>) {
        if (response.isSuccessful && response.body() != null) {

            _userResponseLiveData.postValue(NetworkResult.Success(response.body()!!))


        } else if (response.errorBody() != null) {
            val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
            _userResponseLiveData.postValue(NetworkResult.Error(errorObj.getString("message")))


        } else {
            _userResponseLiveData.postValue(NetworkResult.Error("Something went wrong"))

        }
    }


}