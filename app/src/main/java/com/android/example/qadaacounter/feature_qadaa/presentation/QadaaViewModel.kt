package com.android.example.qadaacounter.feature_qadaa.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.android.example.qadaacounter.feature_qadaa.domain.models.PrayerState
import com.android.example.qadaacounter.feature_qadaa.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QadaaViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {
    private val _state = mutableStateOf(PrayerState())
    val state : State<PrayerState> = _state

    fun addAmount() {
        useCases.increaseAmount()
        _state.value = state.value.copy(amount = state.value.amount+1)
    }
}