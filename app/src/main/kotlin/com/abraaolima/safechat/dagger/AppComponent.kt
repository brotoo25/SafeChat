package com.abraaolima.safechat.dagger

import com.abraaolima.safechat.screens.login.signin.SignInActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by broto on 23/05/17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun inject(signInActivity: SignInActivity)
}