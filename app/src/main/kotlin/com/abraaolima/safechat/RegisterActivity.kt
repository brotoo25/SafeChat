package com.abraaolima.safechat

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { finish() }
    }
}
