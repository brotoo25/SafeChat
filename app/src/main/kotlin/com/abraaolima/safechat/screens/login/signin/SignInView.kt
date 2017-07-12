package com.abraaolima.safechat.screens.login.signin

import io.reactivex.Observable

/**
 * Created by broto on 11/06/17.
 */

interface SignInView {

    fun enterClick(): Observable<SignInData>
    fun forgotPasswordClick(): Observable<Boolean>

}
