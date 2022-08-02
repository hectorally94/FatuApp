package com.prospect.fatuapp.data

import androidx.room.*
import com.prospect.fatuapp.models.Oder_Product
import kotlinx.coroutines.flow.Flow

@Dao
interface MyDao {

    @Query("SELECT * from Oder_Products_tbl")
    fun getOder_Products():
            Flow<List<Oder_Product>>

    @Query("SELECT * from Oder_Products_tbl where id =:id")
    suspend fun getOder_ProductById(id: String): Oder_Product

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(oder_Product: Oder_Product)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(oder_Product: Oder_Product)

    @Query("DELETE from Oder_Products_tbl")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteOder_Product(oder_Product: Oder_Product)


}
