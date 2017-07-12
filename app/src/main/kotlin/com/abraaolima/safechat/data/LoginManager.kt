package com.abraaolima.safechat.data

import android.arch.lifecycle.LiveData
import com.abraaolima.safechat.data.model.User

/**
 * Created by broto on 25/05/17.
 */
interface LoginManager {

    fun getLiveData(): LiveData<User>
    fun loginWithEmail(email: String, password: String)
    fun register(name: String, email: String, password: String)
    fun forgotPassword(email: String)

    fun loginFacebook()
    fun loginGoogle()
    fun loginGitHub()
}