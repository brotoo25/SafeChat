package com.abraaolima.safechat.extensions

import android.app.Activity
import android.text.TextUtils



/**
 * Created by broto on 02/06/17.
 */

fun Activity.isValidEmail(target: CharSequence): Boolean {
    if (TextUtils.isEmpty(target)) {
        return false
    } else {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
}