package com.abraaolima.safechat.data.remote

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.abraaolima.safechat.data.LoginManager
import com.abraaolima.safechat.data.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest


/**
 * Created by broto on 25/05/17.
 */
class FirebaseLoginManager(private val firebaseAuth: FirebaseAuth) : LoginManager {

    val currentUserLiveData: MutableLiveData<User> = UserLiveData(firebaseAuth)

    override fun getLiveData(): LiveData<User> {
        return currentUserLiveData
    }

    override fun loginWithEmail(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
    }

    override fun register(name: String, email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener({ task ->
                    run {
                        if (task.isSuccessful) {
                            val profileUpdates = UserProfileChangeRequest.Builder()
                                    .setDisplayName(name)
                                    .build()

                            firebaseAuth.currentUser?.updateProfile(profileUpdates)
                        }
                    }
                })
    }

    override fun forgotPassword(email: String) {
        firebaseAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful && firebaseAuth.currentUser != null)
                        currentUserLiveData.value = User.ModelMapper.from(firebaseAuth.currentUser!!)
                }
    }

    override fun loginFacebook() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loginGoogle() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loginGitHub() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class UserLiveData(private val firebaseAuth: FirebaseAuth) : MutableLiveData<User>() {

        private val authStateListener: FirebaseAuth.AuthStateListener

        init {
            authStateListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
                firebaseAuth.currentUser?.let { value = User.ModelMapper.from(it) }
            }
        }

        override fun onActive() {
            firebaseAuth.addAuthStateListener(authStateListener)
        }

        override fun onInactive() {
            firebaseAuth.removeAuthStateListener(authStateListener)
        }
    }
}