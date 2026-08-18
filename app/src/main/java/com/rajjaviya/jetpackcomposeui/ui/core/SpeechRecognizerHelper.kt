package com.rajjaviya.jetpackcomposeui.ui.core

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import java.util.Locale

class SpeechRecognizerHelper(private val context: Context) {

    private var speechRecognizer: SpeechRecognizer? = null

    fun startListening(
        onResult: (String) -> Unit, onError: (Int) -> Unit
    ) {

        // create speech recognizer instance
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(context)


        // start to listen all event for speech recognizer
        speechRecognizer?.setRecognitionListener(object : RecognitionListener {
            override fun onBeginningOfSpeech() {

            }

            override fun onBufferReceived(p0: ByteArray?) {

            }

            override fun onEndOfSpeech() {

            }

            override fun onError(p0: Int) {
                onError(p0)
            }

            override fun onEvent(p0: Int, p1: Bundle?) {

            }

            override fun onPartialResults(p0: Bundle?) {

            }

            override fun onReadyForSpeech(p0: Bundle?) {

            }

            override fun onResults(result: Bundle?) {

                val allResults = result?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)

                val singleResult = allResults?.firstOrNull()

                if (singleResult != null) {
                    onResult(singleResult)
                }
            }

            override fun onRmsChanged(p0: Float) {

            }
        })

        // create intent to start listening with speech recognizer action
        val intent = Intent(
            RecognizerIntent.ACTION_RECOGNIZE_SPEECH
        ).apply {

            //to specify the prompt message
            putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
            )

            // to specify which language to use like english or hindi or bengali
            putExtra(
                RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault()
            )

            // to specify how many result we need
            putExtra(
                RecognizerIntent.EXTRA_MAX_RESULTS, 1
            )
        }

        speechRecognizer?.startListening(intent)
    }

    fun stopListening() {
        speechRecognizer?.stopListening()
    }

    fun destroy() {
        speechRecognizer?.destroy()
        speechRecognizer = null

    }

}