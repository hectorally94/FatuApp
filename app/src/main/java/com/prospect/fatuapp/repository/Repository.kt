package com.prospect.fatuapp.repository

import com.prospect.fatuapp.data.MyDao
import com.prospect.fatuapp.models.Oder_Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class Repository @Inject constructor(private val Oder_ProductDatabaseDao: MyDao) {
    suspend fun addOder_Product(oder_Product: Oder_Product) = Oder_ProductDatabaseDao.insert(oder_Product)
    suspend fun updateOder_Product(oder_Product: Oder_Product) = Oder_ProductDatabaseDao.update(oder_Product)
    suspend fun deleteOder_Product(oder_Product: Oder_Product) = Oder_ProductDatabaseDao.deleteOder_Product(oder_Product)
    suspend fun deleteAllOder_Products() = Oder_ProductDatabaseDao.deleteAll()
    fun getAllOder_Products(): Flow<List<Oder_Product>> = Oder_ProductDatabaseDao.getOder_Products().flowOn(Dispatchers.IO)
        .conflate()
}