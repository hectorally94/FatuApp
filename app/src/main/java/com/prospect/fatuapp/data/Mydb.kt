package com.prospect.fatuapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.prospect.fatuapp.models.Oder_Product
import com.prospect.fatuapp.utils.DateConverter
import com.prospect.fatuapp.utils.UUIDConverter


@Database(entities = [Oder_Product::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class Mydb: RoomDatabase() {
    abstract fun oderDao(): MyDao
}