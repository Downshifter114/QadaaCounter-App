package com.android.example.qadaacounter.feature_qadaa.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Qadaa()

        }
    }

    override fun onStart() {
        val viewModel: QadaaViewModel by viewModels()
        viewModel.updateInterface()
        super.onStart()
    }
}



