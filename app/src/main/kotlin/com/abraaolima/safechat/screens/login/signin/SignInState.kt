package com.abraaolima.safechat.screens.login.signin

/**
 * Created by broto on 07/06/17.
 */
data class SignInState(
        private val isShuffling: Boolean,
        private val isDealing: Boolean,
        private val isBuildingNewDeck: Boolean,
        val error: String?
) {
    val isLoading: Boolean = isShuffling || isDealing || isBuildingNewDeck
}