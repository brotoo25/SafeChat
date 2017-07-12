package com.abraaolima.safechat.dagger

import android.app.Application
import android.content.Context
import com.abraaolima.safechat.data.LoginManager
import com.abraaolima.safechat.data.remote.FirebaseLoginManager
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by broto on 23/05/17.
 */
@Module
class AppModule(private val application: Application) {

    @Provides @Singleton fun provideApplicationContext(): Context = application

    @Provides @Singleton fun provideLoginManager(firebaseAuth: FirebaseAuth): LoginManager {
        return FirebaseLoginManager(firebaseAuth)
    }

    @Provides @Singleton fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }
}