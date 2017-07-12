package com.abraaolima.safechat.screens.login.register

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.widget.Toast
import com.abraaolima.safechat.R
import com.abraaolima.safechat.extensions.isValidEmail
import com.abraaolima.safechat.screens.base.BaseActivity
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable
import io.reactivex.functions.Function3
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.content_register.*


class RegisterActivity : BaseActivity() {

    lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        viewModel = ViewModelProviders.of(this@RegisterActivity).get(RegisterViewModel::class.java)
        viewModel.getUser().observe(this, Observer {
            it?.let {
                Toast.makeText(this@RegisterActivity, it.toString(), Toast.LENGTH_LONG).show()
            }
        })

        initForm()
    }

    fun initForm() {
        val nameObservable: Observable<Boolean> = RxTextView.textChanges(txt_register_name)
                .map<Boolean> { inputText -> !inputText.isEmpty() }
                .distinctUntilChanged()
                .doOnNext { isValid ->
                    if (!isValid)
                        textInputLayout_register_name.error = getString(R.string.invalid_field)
                    else
                        textInputLayout_register_name.error = null
                }

        val emailObservable: Observable<Boolean> = RxTextView.textChanges(txt_register_email)
                .map<Boolean> { inputText -> !inputText.isEmpty() && isValidEmail(inputText) }
                .distinctUntilChanged()
                .doOnNext { isValid ->
                    if (!isValid)
                        textInputLayout_register_email.error = getString(R.string.invalid_field)
                    else
                        textInputLayout_register_email.error = null
                }

        val passwordObservable: Observable<Boolean> = RxTextView.textChanges(txt_signin_password)
                .map<Boolean> { inputText ->
                    !inputText.isEmpty() &&
                            inputText.length > 6
                }
                .distinctUntilChanged()
                .doOnNext { isValid ->
                    if (!isValid)
                        textInputLayout_signin_password.error = getString(R.string.invalid_field)
                    else
                        textInputLayout_signin_password.error = null
                }

        btn_register_enter.setOnClickListener({
            val validFields: Observable<Boolean> = Observable
                    .combineLatest(
                            nameObservable,
                            emailObservable,
                            passwordObservable,
                            Function3 { name, email, password -> name && email && password })

            subscriptions.add(
                    validFields
                            .filter({ it == true })
                            .subscribe({
                                run {
                                    viewModel.register(txt_register_email.text.toString().trim(),
                                            txt_register_name.text.toString().trim(),
                                            txt_signin_password.text.toString().trim())
                                }
                            })
            )
        })

        fab_register.setOnClickListener({
            supportFinishAfterTransition()
        })
    }
}
