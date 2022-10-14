package com.android.example.qadaacounter.feature_qadaa.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.example.qadaacounter.feature_qadaa.domain.models.PrayerEntity
import com.android.example.qadaacounter.feature_qadaa.domain.models.PrayerState
import com.android.example.qadaacounter.feature_qadaa.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QadaaViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {
    private val _state = mutableStateOf(PrayerState())
    val state : State<PrayerState> = _state

    fun onEvent(qadaaEvent: QadaaEvent) {
        //Do the job required
        when(qadaaEvent) {
            is QadaaEvent.Increase -> increase(qadaaEvent.id)
            is QadaaEvent.Decrease -> decrease(qadaaEvent.id)
            is QadaaEvent.Clear -> clear(qadaaEvent.id)
        }
        //Update the User Interface
        updateInterface()
    }

    private fun increase(id: String) {
        viewModelScope.launch {
            val prayer: PrayerEntity? = useCases.getPrayerData(id)
            if (prayer == null)
                useCases.insertEmptyPrayer(id)
            else
                useCases.increaseAmount(prayer)
        }
    }

    private fun decrease(id: String) {
        viewModelScope.launch {
            val prayer: PrayerEntity? = useCases.getPrayerData(id)
            if (prayer == null)
                useCases.insertEmptyPrayer(id)
            else
                useCases.decreaseAmount(prayer)
        }
    }

    private fun clear(id: String) {
        viewModelScope.launch {
            val prayer: PrayerEntity? = useCases.getPrayerData(id)
            useCases.insertEmptyPrayer(id)
        }
    }

    fun updateInterface() {
        viewModelScope.launch {
            _state.value = state.value.copy(
                fajr = useCases.getPrayerData("fajr") ?: PrayerEntity("fajr", 0,0),
                dhuhr = useCases.getPrayerData("dhuhr") ?: PrayerEntity("dhuhr", 0,0),
                asr = useCases.getPrayerData("asr") ?: PrayerEntity("asr", 0,0),
                maghrib = useCases.getPrayerData("maghrib") ?: PrayerEntity("maghrib", 0,0),
                isha = useCases.getPrayerData("isha") ?: PrayerEntity("isha", 0,0),
                vitr = useCases.getPrayerData("vitr") ?: PrayerEntity("vitr", 0,0)
            )
        }
    }
}