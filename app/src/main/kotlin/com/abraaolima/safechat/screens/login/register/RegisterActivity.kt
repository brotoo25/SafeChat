package com.abraaolima.safechat.screens.login.register

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import com.abraaolima.safechat.R

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { finish() }
    }
}
