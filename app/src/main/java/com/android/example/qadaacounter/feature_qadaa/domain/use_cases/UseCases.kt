package com.android.example.qadaacounter.feature_qadaa.domain.use_cases

data class UseCases(
    val increaseAmount: IncreaseAmount,
    val decreaseAmount: DecreaseAmount,
    val getPrayerData: GetPrayerData,
    val cleanPrayerData: CleanPrayerData,
    val insertEmptyPrayer: InsertEmptyPrayer
)
