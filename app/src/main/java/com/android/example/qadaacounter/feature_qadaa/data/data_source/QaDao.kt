package com.android.example.qadaacounter.feature_qadaa.data.data_source

import androidx.room.*
import com.android.example.qadaacounter.feature_qadaa.domain.models.PrayerEntity

@Dao
interface QaDao {

    @Query("SELECT * FROM PrayerEntity WHERE id = :id")
    suspend fun getPrayerById(id: String) : PrayerEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPrayerData(prayerEntity: PrayerEntity)

    @Delete
    suspend fun clearPrayerData(prayerEntity: PrayerEntity)
}