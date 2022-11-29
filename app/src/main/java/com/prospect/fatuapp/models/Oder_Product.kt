package com.prospect.fatuapp.models

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.*

@Entity(tableName = "Oder_Products_tbl" )
data class Oder_Product  @RequiresApi(Build.VERSION_CODES.O) constructor(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "Oder_Product_code" )
    val code: String,

    @ColumnInfo(name = "Oder_Product_name")
    val name: String,

    @ColumnInfo(name = "Oder_Product_marque")
    val marque: String,

    @ColumnInfo(name = "Oder_Product_prix_vente")
    val prix_vente: String,

    @ColumnInfo(name = "Oder_Product_prix_achat")
    val prix_achat: String,

    @ColumnInfo(name = "Oder_Product_prix_vente_T")
    val prix_vente_T: Int,

    @ColumnInfo(name = "Oder_Product_prix_achat_T")
    val prix_achat_T: Int,

    @ColumnInfo(name = "Oder_Product_benefice")
    val benefice: Int,
    @ColumnInfo(name="oder_product_Q")
    val Q:String,

    @ColumnInfo(name = "Oder_Product_entry_date")
    val entryDate: Date = Date.from(Instant.now())
)