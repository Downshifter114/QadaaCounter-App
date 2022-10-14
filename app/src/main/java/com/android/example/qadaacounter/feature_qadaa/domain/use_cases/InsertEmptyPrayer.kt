package com.android.example.qadaacounter.feature_qadaa.domain.use_cases

import com.android.example.qadaacounter.feature_qadaa.domain.models.PrayerEntity
import com.android.example.qadaacounter.feature_qadaa.domain.repository.QaRepository
import javax.inject.Inject

class InsertEmptyPrayer @Inject constructor(
    private val repository: QaRepository
) {
    suspend operator fun invoke(id: String) {
        repository.insertPrayerData(PrayerEntity(id, 0, System.currentTimeMillis()))
    }
}