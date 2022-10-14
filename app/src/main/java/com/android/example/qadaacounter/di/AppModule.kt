package com.android.example.qadaacounter.di

import android.content.Context
import androidx.room.Room
import com.android.example.qadaacounter.QadaaApplication
import com.android.example.qadaacounter.feature_qadaa.data.data_source.QaDao
import com.android.example.qadaacounter.feature_qadaa.data.data_source.QaDataBase
import com.android.example.qadaacounter.feature_qadaa.data.repository.QaRepositoryImpl
import com.android.example.qadaacounter.feature_qadaa.domain.repository.QaRepository
import com.android.example.qadaacounter.feature_qadaa.domain.use_cases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext app: Context) : QaDataBase {
        return Room.databaseBuilder(
            app,
            QaDataBase::class.java,
            QaDataBase.DATABASE_NAME
        ).build()
    }
    @Provides
    @Singleton
    fun provideRepository(db: QaDataBase) : QaRepository {
        return QaRepositoryImpl(db.daoInstance())
    }
    @Provides
    @Singleton
    fun provideUseCases(qaRepository: QaRepository) : UseCases {
        return UseCases(
            increaseAmount = IncreaseAmount(qaRepository),
            decreaseAmount = DecreaseAmount(qaRepository),
            getPrayerData = GetPrayerData(qaRepository),
            cleanPrayerData = CleanPrayerData(qaRepository),
            insertEmptyPrayer = InsertEmptyPrayer(qaRepository)
        )
    }
}