package com.example.practice.data.remote

import android.util.Log
import com.example.practice.ui.login.LoginVIew
import com.example.practice.ui.login.SignUpView
import com.example.practice.data.entity.AuthResponse
import com.example.practice.data.entity.User2
import com.example.practice.ui.main.splash.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthService {
    private lateinit var signUpView: SignUpView
    private lateinit var loginView : LoginVIew
    fun setSignUpView(signUpView: SignUpView) {
        this.signUpView = signUpView
    }
    fun setLoginView(loginView: LoginVIew) {
        this.signUpView = signUpView
    }

    fun signUp(user: User2) {
        val authService = getRetrofit().create(AuthRetrofitInterface::class.java)
        authService.signUp(user).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                Log.d("SIGNUP/SUCCESS", response.toString())
                val response: AuthResponse = response.body()!!
                when (response.code) {
                    1000 -> signUpView.onSignUpSuccess()
                    else -> signUpView.onSignUpFailure()
                }
            }
            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                Log.d("SIGNUP/FAILURE", t.message.toString())

            }
        })
        Log.d("SIGNUP/FAILURE", "HELLO")
    }


    fun login(user: User2) {
        val authService = getRetrofit().create(AuthRetrofitInterface::class.java)
        authService.login(user).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                Log.d("LOGIN/SUCCESS", response.toString())
                val response: AuthResponse = response.body()!!
                when (val code = response.code) {
                    1000 -> loginView.onLoginSuccess(code,response.result!!)
                    else -> loginView.onLoginFailure()
                }
            }
            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                Log.d("SIGNUP/FAILURE", t.message.toString())

            }
        })
        Log.d("SIGNUP/FAILURE", "HELLO")
    }
}