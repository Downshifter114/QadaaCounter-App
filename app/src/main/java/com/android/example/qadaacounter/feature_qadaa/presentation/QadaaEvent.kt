package com.android.example.qadaacounter.feature_qadaa.presentation

sealed class QadaaEvent {
    data class Increase(val id: String) : QadaaEvent()
    data class Decrease(val id: String) : QadaaEvent()
    data class Clear(val id: String) : QadaaEvent()
}
