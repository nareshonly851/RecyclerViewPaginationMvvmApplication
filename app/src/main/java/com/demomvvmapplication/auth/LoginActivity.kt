package com.demomvvmapplication.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.demomvvmapplication.R
import com.demomvvmapplication.data.network.model.User
import com.demomvvmapplication.databinding.LoginMainBinding
import com.mvvmdemo.util.hide
import com.mvvmdemo.util.show
import com.mvvmdemo.util.toast
import kotlinx.android.synthetic.main.login_main.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class LoginActivity : AppCompatActivity(), AuthListener,KodeinAware {


    override val kodein by kodein()

    private val fact  : AuthViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        val binding: LoginMainBinding =
            DataBindingUtil.setContentView(this, R.layout.login_main)
        val viewModel = ViewModelProviders.of(this,fact).get(AuthViewModel::class.java)

        binding.viewmodel = viewModel
        viewModel.authListener = this


    }


    override fun onStarted() {

        progress_bar.show()


    }

    override fun onSuccess(user: User) {
        progress_bar.hide()
        toast("${user.email}")

    }

    override fun onFailure() {
        progress_bar.hide()
        toast("onFailure")
        }
}
