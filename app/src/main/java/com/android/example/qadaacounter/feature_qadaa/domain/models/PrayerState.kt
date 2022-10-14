package com.android.example.qadaacounter.feature_qadaa.domain.models

data class PrayerState(
    val fajr: PrayerEntity = PrayerEntity("fajr", 0,0),
    val dhuhr: PrayerEntity = PrayerEntity("dhuhr", 0,0),
    val asr: PrayerEntity = PrayerEntity("asr", 0,0),
    val maghrib: PrayerEntity = PrayerEntity("maghrib", 0,0),
    val isha: PrayerEntity = PrayerEntity("isha", 0,0),
    val vitr: PrayerEntity = PrayerEntity("vitr", 0,0)
)