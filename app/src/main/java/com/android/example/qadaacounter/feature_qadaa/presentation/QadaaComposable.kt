package com.android.example.qadaacounter.feature_qadaa.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.example.qadaacounter.ui.theme.Purple200
import com.android.example.qadaacounter.ui.theme.Purple500
import com.android.example.qadaacounter.ui.theme.Purple700
import java.text.SimpleDateFormat
import java.util.*

fun formatTimeStamp(timeStamp: Long) : String {
    val sdf = SimpleDateFormat("MMM dd,yyyy HH:mm")
    val resultDate = Date(timeStamp)
    return sdf.format(resultDate)
}

@Composable
fun Qadaa(
    viewModel: QadaaViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    androidx.compose.material.Surface(color = Purple700) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            PrayerSection(id = state.fajr.id, amount = state.fajr.amount, timeStamp = state.fajr.timeStamp, onEvent = viewModel::onEvent)
            PrayerSection(id = state.dhuhr.id, amount = state.dhuhr.amount, timeStamp = state.dhuhr.timeStamp, onEvent = viewModel::onEvent)
            PrayerSection(id = state.asr.id, amount = state.asr.amount, timeStamp = state.asr.timeStamp, onEvent = viewModel::onEvent)
            PrayerSection(id = state.maghrib.id, amount = state.maghrib.amount, timeStamp = state.maghrib.timeStamp, onEvent = viewModel::onEvent)
            PrayerSection(id = state.isha.id, amount = state.isha.amount, timeStamp = state.isha.timeStamp, onEvent = viewModel::onEvent)
            PrayerSection(id = state.vitr.id, amount = state.vitr.amount, timeStamp = state.vitr.timeStamp, onEvent = viewModel::onEvent)
        }
    }
}

@Composable
fun PrayerSection(id: String, amount: Int, timeStamp: Long, onEvent: (QadaaEvent) -> Unit) {
    androidx.compose.material.Surface(color = Purple200, shape = RoundedCornerShape(10.dp), modifier = Modifier.padding(horizontal = 16.dp)) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row() {
                Text(text = "${id.uppercase()} -> ", textAlign = TextAlign.Center, fontSize = 24.sp)
                Text(text = "Amount: $amount", textAlign = TextAlign.Center, fontSize = 24.sp)
            }
            Text(text = "Last Edited: ${formatTimeStamp(timeStamp)}", textAlign = TextAlign.Center, fontSize = 24.sp)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(onClick = { onEvent(QadaaEvent.Increase(id)) }) {
                    Text(text = "+", fontSize = 18.sp)
                }
                Button(onClick = { onEvent(QadaaEvent.Decrease(id)) }) {
                    Text(text = "-", fontSize = 18.sp)
                }
                Button(onClick = { onEvent(QadaaEvent.Clear(id)) }) {
                    Text(text = "RES", fontSize = 18.sp)
                }
            }
        }
    }
}