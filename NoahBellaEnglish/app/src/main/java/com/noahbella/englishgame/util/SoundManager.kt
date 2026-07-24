package com.noahbella.englishgame.util

import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.Locale

class SoundManager(context: Context) : TextToSpeech.OnInitListener {

    private val tts = TextToSpeech(context, this)
    private var ready = false

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts.setLanguage(Locale.US)
            ready = result != TextToSpeech.LANG_MISSING_DATA &&
                    result != TextToSpeech.LANG_NOT_SUPPORTED
        }
    }

    fun speak(text: String) {
        if (ready) {
            tts.setSpeechRate(0.8f)
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "tts_${text.hashCode()}")
        }
    }

    fun shutdown() {
        tts.stop()
        tts.shutdown()
    }
}
