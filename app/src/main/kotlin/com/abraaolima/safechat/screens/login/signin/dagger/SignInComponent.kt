package com.abraaolima.safechat.dagger

import com.abraaolima.safechat.screens.login.register.RegisterActivity
import com.abraaolima.safechat.screens.login.register.RegisterViewModel
import com.abraaolima.safechat.screens.login.signin.SignInActivity
import com.abraaolima.safechat.screens.login.signin.SignInViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Created by broto on 23/05/17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface SignInComponent {

    fun inject(signInActivity: SignInActivity)
    fun inject(signInViewModel: SignInViewModel)

    fun inject(registerActivity: RegisterActivity)
    fun inject(registerViewModel: RegisterViewModel)
}