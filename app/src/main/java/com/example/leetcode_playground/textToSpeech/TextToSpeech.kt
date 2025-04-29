package com.example.leetcode_playground.textToSpeech

import android.speech.tts.TextToSpeech
import android.speech.tts.Voice
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.time.delay
import java.util.Locale
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun TextToSpeechRoot() {

}

@Composable
fun TextToSpeechScreen(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var tts by remember { mutableStateOf<TextToSpeech?>(null) }
    var canStartSpeech by remember { mutableStateOf(false) }


    val voices = tts?.voices  // Available only on API 21+
    val childVoice = voices?.firstOrNull { voice ->
        voice.name.contains("child", ignoreCase = true) ||
                voice.name.contains("kids", ignoreCase = true)
    }

    LaunchedEffect(Unit) {
        tts = TextToSpeech(context){ status ->
            if (status == TextToSpeech.SUCCESS) {
                val result = tts?.setLanguage(Locale.UK)
                canStartSpeech = result != TextToSpeech.LANG_MISSING_DATA && result != TextToSpeech.LANG_NOT_SUPPORTED
            }
        }
    }

    LaunchedEffect(canStartSpeech) {
        kotlinx.coroutines.delay(8000L)
        if (canStartSpeech) {
//            tts?.setVoice(Voice("en-GB-x-gbc#male_1-local", Voice.QUALITY_HIGH, Voice.LATENCY_LOW))

//            tts?.setPitch(1.5f)
//            tts?.setSpeechRate(1.2f)

//            tts?.setVoice(childVoice)
            childVoice?.let { tts?.voice = it }
            tts?.speak(
                "what is 1 + 1",
                TextToSpeech.QUEUE_FLUSH,
                null,
                null
            )
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            tts?.stop()
            tts?.shutdown()
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        TextButton(
            onClick = {
                tts?.speak(
                    "Now say it again, but don’t say /boy/ ",
                    TextToSpeech.QUEUE_FLUSH,
                    null,
                    null
                )
            },
            enabled = canStartSpeech
        ) {
            Text("Start Speech")
        }

    }

}