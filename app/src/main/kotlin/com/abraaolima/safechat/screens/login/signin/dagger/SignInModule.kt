package com.abraaolima.safechat.dagger

import com.abraaolima.safechat.screens.login.signin.SignInView
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by broto on 23/05/17.
 */
@Module
class SignInModule
constructor(val signInView: SignInView) {

    @Provides @Singleton fun provideSignInView(): SignInView {
        return signInView
    }
}