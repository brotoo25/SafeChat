package com.abraaolima.safechat.screens.login.signin

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.abraaolima.safechat.R
import com.abraaolima.safechat.databinding.ActivitySigninBinding

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivitySigninBinding = DataBindingUtil.setContentView(this, R.layout.activity_signin)

        binding.fabSiginShowRegister.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

}
