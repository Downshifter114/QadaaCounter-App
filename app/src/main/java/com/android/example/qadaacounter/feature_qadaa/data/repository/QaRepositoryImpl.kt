package com.android.example.qadaacounter.feature_qadaa.data.repository

import androidx.room.Dao
import com.android.example.qadaacounter.feature_qadaa.data.data_source.QaDao
import com.android.example.qadaacounter.feature_qadaa.domain.models.PrayerEntity
import com.android.example.qadaacounter.feature_qadaa.domain.repository.QaRepository
import javax.inject.Inject

class QaRepositoryImpl(private val dao: QaDao) : QaRepository {
    override suspend fun getPrayerById(id: String): PrayerEntity? {
        return dao.getPrayerById(id)
    }

    override suspend fun insertPrayerData(prayerEntity: PrayerEntity) {
        dao.insertPrayerData(prayerEntity)
    }

    override suspend fun clearPrayerData(prayerEntity: PrayerEntity) {
        dao.clearPrayerData(prayerEntity)
    }
}