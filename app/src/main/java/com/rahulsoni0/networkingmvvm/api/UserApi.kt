package com.rahulsoni0.networkingmvvm.api

import com.rahulsoni0.networkingmvvm.models.UserRequest
import com.rahulsoni0.networkingmvvm.models.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {


    @POST("/users/signup")
    suspend fun signUp(@Body userRequest: UserRequest): Response<UserResponse>
    // Call<UserResponse> signUp (@Body UserRequest userRequest); // java eq


    @POST("/users/signin")
    suspend fun signin(@Body userRequest: UserRequest): Response<UserResponse>

}