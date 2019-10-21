package com.demomvvmapplication.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.mvvmdemo.data.repositories.UserRepository
import com.mvvmdemo.util.ApiException
import com.mvvmdemo.util.Coroutines

class AuthViewModel(private val repository: UserRepository)  : ViewModel() {

    var email: String? = null
    var password: String? = null
    var authListener: AuthListener? = null

    fun onLoginButtonClicked(view: View) {
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure()
            return
        }


        Coroutines.main{

            try {
                val response = repository.userLogin(email!!,password!!)

                response.user?.let {
                    authListener?.onSuccess(it)
                    return@main
                }

                authListener?.onFailure()

            }catch (e:ApiException){
                authListener?.onFailure()

            }


        }

    }
}