package com.android.example.qadaacounter.feature_qadaa.domain.repository

import com.android.example.qadaacounter.feature_qadaa.domain.models.PrayerEntity

interface QaRepository {

    suspend fun getPrayerById(id: String) : PrayerEntity?


    suspend fun insertPrayerData(prayerEntity: PrayerEntity)


    suspend fun clearPrayerData(prayerEntity: PrayerEntity)
}