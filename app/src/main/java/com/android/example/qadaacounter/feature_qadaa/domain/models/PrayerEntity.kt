package com.android.example.qadaacounter.feature_qadaa.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PrayerEntity(
    @PrimaryKey val id: String,

    val amount: Int,
    val timeStamp: Long
)