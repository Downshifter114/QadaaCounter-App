package com.android.example.qadaacounter.feature_qadaa.domain.use_cases

import android.util.Log
import com.android.example.qadaacounter.feature_qadaa.domain.models.PrayerEntity
import com.android.example.qadaacounter.feature_qadaa.domain.repository.QaRepository
import javax.inject.Inject

class DecreaseAmount @Inject constructor(
    private val repository: QaRepository
){
    suspend operator fun invoke(prayerEntity: PrayerEntity) {
        repository.insertPrayerData(prayerEntity.copy(amount = prayerEntity.amount-1))
        Log.i("MyTag", "Decrease Amount Invoke Executed!")
    }
}