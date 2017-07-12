package com.abraaolima.safechat

import android.app.Application
import com.abraaolima.safechat.dagger.AppComponent
import com.abraaolima.safechat.dagger.AppModule
import com.abraaolima.safechat.dagger.DaggerAppComponent

/**
 * Created by broto on 23/05/17.
 */
class SafeChatApplication : Application() {

    val appComponent: AppComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

    override fun onCreate() {
        super.onCreate()

    }
}