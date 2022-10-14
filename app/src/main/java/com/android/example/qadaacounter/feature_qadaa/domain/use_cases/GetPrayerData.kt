package com.android.example.qadaacounter.feature_qadaa.domain.use_cases

import android.util.Log
import com.android.example.qadaacounter.feature_qadaa.domain.models.PrayerEntity
import com.android.example.qadaacounter.feature_qadaa.domain.repository.QaRepository
import javax.inject.Inject

class GetPrayerData @Inject constructor(
    private val repository: QaRepository
) {
    suspend operator fun invoke(id: String) : PrayerEntity? {
        Log.i("MyTag", "GetPrayerData Invoke Executed!")
        return repository.getPrayerById(id)
    }
}