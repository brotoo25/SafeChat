package com.abraaolima.safechat.screens.base

import android.arch.lifecycle.LifecycleActivity
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by broto on 06/06/17.
 */
abstract class BaseActivity : LifecycleActivity() {

    protected val subscriptions = CompositeDisposable()

    override fun onDestroy() {
        super.onDestroy()

        subscriptions.dispose()
        subscriptions.clear()
    }
}