package com.android.example.qadaacounter.feature_qadaa.domain.models

val timeStamp = System.currentTimeMillis()

data class PrayerState(
    val fajr: PrayerEntity = PrayerEntity("fajr", 0, timeStamp),
    val dhuhr: PrayerEntity = PrayerEntity("dhuhr", 0, timeStamp),
    val asr: PrayerEntity = PrayerEntity("asr", 0, timeStamp),
    val maghrib: PrayerEntity = PrayerEntity("maghrib", 0, timeStamp),
    val isha: PrayerEntity = PrayerEntity("isha", 0, timeStamp),
    val vitr: PrayerEntity = PrayerEntity("vitr", 0, timeStamp)
)