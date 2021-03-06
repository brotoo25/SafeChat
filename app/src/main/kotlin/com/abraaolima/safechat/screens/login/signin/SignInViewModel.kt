package com.abraaolima.safechat.screens.login.signin

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.abraaolima.safechat.SafeChatApplication
import com.abraaolima.safechat.data.LoginManager
import javax.inject.Inject

/**
 * Created by broto on 23/05/17.
 */
class SignInViewModel constructor(application: Application) : AndroidViewModel(application) {

    @Inject lateinit var signInView: SignInView
    @Inject lateinit var loginManager: LoginManager

    init {
        (application as SafeChatApplication).appComponent.inject(this)
    }

    fun getUser() = loginManager.getLiveData()

    fun login(email: String, password: String) {
        loginManager.loginWithEmail(email, password)
    }
}