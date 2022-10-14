package com.android.example.qadaacounter.feature_qadaa.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.example.qadaacounter.feature_qadaa.domain.models.PrayerEntity

@Database(
    entities = [PrayerEntity::class],
    version = 1
)
abstract class QaDataBase : RoomDatabase() {
    abstract fun daoInstance() : QaDao
    companion object {
        const val DATABASE_NAME = "qadaa_database"
    }
}