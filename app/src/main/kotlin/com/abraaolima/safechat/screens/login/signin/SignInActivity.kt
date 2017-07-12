package com.abraaolima.safechat.screens.login.signin

import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.view.View
import android.widget.Toast
import com.abraaolima.safechat.R
import com.abraaolima.safechat.screens.login.register.RegisterActivity
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_signin.*
import kotlinx.android.synthetic.main.content_signin.*

class SignInActivity : LifecycleActivity(), SignInView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_signin)

        val viewModel = ViewModelProviders.of(this@SignInActivity).get(SignInViewModel::class.java)

        viewModel.getUser().observe(this, Observer {
            it?.let {
                Toast.makeText(this@SignInActivity, it.toString(), Toast.LENGTH_LONG).show()
            }
        })

        btn_signin_enter.setOnClickListener({
            viewModel.login(txt_signin_email.text.toString(), txt_signin_password.text.toString())
        })

        fab_sigin.setOnClickListener({
            val intent = Intent(this, RegisterActivity::class.java)

            val p1 = Pair.create(fab_sigin as View, getString(R.string.transition_login_fab))
            val p2 = Pair.create(include_signin_content, getString(R.string.transition_login_content))
            val p3 = Pair.create(textInputLayout_signin_email as View, getString(R.string.transition_login_email))
            val p4 = Pair.create(textInputLayout_signin_password as View, getString(R.string.transition_login_password))
            val p5 = Pair.create(btn_signin_enter as View, getString(R.string.transition_login_enter))
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, p1, p2, p3, p4, p5)

            startActivity(intent, options.toBundle())
        })
    }

    override fun enterClick(): Observable<SignInData> {
        return RxView
                .clicks(btn_signin_enter)
                .filter { any ->  !txt_signin_email.text.toString().isEmpty()}
                .filter { any ->  txt_signin_email.text.toString().length > 6}
                .switchIfEmpty { Exception(getString(R.string.pass_at_least_six_chars_long)) }
                .doOnError { throwable ->  txt_signin_email.setText(throwable.message) }
                .map { any ->
                    SignInData(email = txt_signin_email.text.toString(),
                            password = txt_signin_password.text.toString())
                }
    }

    override fun forgotPasswordClick(): Observable<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
