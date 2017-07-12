package com.abraaolima.safechat.screens.login.register

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.abraaolima.safechat.SafeChatApplication
import com.abraaolima.safechat.data.LoginManager
import javax.inject.Inject

/**
 * Created by broto on 29/05/17.
 */
class RegisterViewModel constructor(application: Application) : AndroidViewModel(application) {

    @Inject lateinit var loginManager: LoginManager

    init {
        (application as SafeChatApplication).appComponent.inject(this)
    }

    fun getUser() = loginManager.getLiveData()

    fun register(email: String, name: String, password: String) {
        loginManager.register(name = name, email = email, password = password)
    }
}