package com.android.example.qadaacounter.di

import com.android.example.qadaacounter.feature_qadaa.domain.use_cases.IncreaseAmount
import com.android.example.qadaacounter.feature_qadaa.domain.use_cases.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideUseCases() : UseCases {
        return UseCases(
            increaseAmount = IncreaseAmount()
        )
    }
}