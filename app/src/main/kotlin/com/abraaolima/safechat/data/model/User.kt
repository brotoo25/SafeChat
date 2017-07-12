package com.abraaolima.safechat.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.firebase.auth.FirebaseUser

/**
 * Created by broto on 25/05/17.
 */
@Entity
data class User (@PrimaryKey val userId: String, val name: String? = "", val email: String? = "") {
    object ModelMapper {
        fun from(firebaseUser: FirebaseUser) =
                User(firebaseUser.uid, firebaseUser.displayName, firebaseUser.email)
    }
}