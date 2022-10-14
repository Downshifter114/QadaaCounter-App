package com.android.example.qadaacounter.feature_qadaa.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun Qadaa(
    viewModel: QadaaViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PrayerSection(id = state.fajr.id, amount = state.fajr.amount, timeStamp = state.fajr.timeStamp, onEvent = viewModel::onEvent)
        PrayerSection(id = state.dhuhr.id, amount = state.dhuhr.amount, timeStamp = state.dhuhr.timeStamp, onEvent = viewModel::onEvent)
        PrayerSection(id = state.asr.id, amount = state.asr.amount, timeStamp = state.asr.timeStamp, onEvent = viewModel::onEvent)
        PrayerSection(id = state.maghrib.id, amount = state.maghrib.amount, timeStamp = state.maghrib.timeStamp, onEvent = viewModel::onEvent)
        PrayerSection(id = state.isha.id, amount = state.isha.amount, timeStamp = state.isha.timeStamp, onEvent = viewModel::onEvent)
        PrayerSection(id = state.vitr.id, amount = state.vitr.amount, timeStamp = state.vitr.timeStamp, onEvent = viewModel::onEvent)
    }
}

@Composable
fun PrayerSection(id: String, amount: Int, timeStamp: Long, onEvent: (QadaaEvent) -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "${id.uppercase()} -> Amount: $amount Last Edited: $timeStamp", textAlign = TextAlign.Center)
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = { onEvent(QadaaEvent.Increase(id)) }) {
                Text(text = "+")
            }
            Button(onClick = { onEvent(QadaaEvent.Decrease(id)) }) {
                Text(text = "-")
            }
            Button(onClick = { onEvent(QadaaEvent.Clear(id)) }) {
                Text(text = "RES")
            }
        }
    }
}