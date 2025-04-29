package com.example.leetcode_playground.textToSpeech

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class TextToSpeechViewModel : ViewModel() {

    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(TextToSpeechState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                /** Load initial data here **/
                hasLoadedInitialData = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = TextToSpeechState()
        )

    fun onAction(action: TextToSpeechAction) {
        when (action) {
            else -> TODO("Handle actions")
        }
    }

}