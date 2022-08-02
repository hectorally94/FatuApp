package com.prospect.fatuapp.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.prospect.fatuapp.models.Oder_Product

class OrderDate {
    @RequiresApi(Build.VERSION_CODES.O)
    fun loadOders(): List<Oder_Product> {
        return listOf(

            Oder_Product(
                code = "xxc",
                name = "samesung one",
                marque = "Samesung galaxie",
                prix_vente = "12000",
                prix_achat = "13000",
                prix_vente_T = "120000",
                prix_achat_T = "130000",
                Q = "10",
                benefice ="10000",
            )





        )
    }
}