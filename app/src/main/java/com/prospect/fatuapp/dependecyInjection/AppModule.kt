package com.prospect.fatuapp.dependecyInjection

import android.content.Context
import androidx.room.Room
import com.prospect.fatuapp.data.MyDao
import com.prospect.fatuapp.data.Mydb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOderDao(database: Mydb): MyDao
     = database.oderDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): Mydb
     = Room.databaseBuilder(
        context,
        Mydb::class.java,
        "Fatu_db")
        .fallbackToDestructiveMigration()
        .build()
}