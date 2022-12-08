package com.prospect.fatuapp.navigations.NavItemScreens

import com.prospect.fatuapp.R

sealed class DrowerNavItemScreens(var title:String, var icon:Int, var screen_route:String){

    object AddProductToPos : DrowerNavItemScreens("AddProducttoPOS", R.drawable.ic_launcher_background,"add_product_pos")
    object OderedProduct: DrowerNavItemScreens("Odered product", R.drawable.ic_launcher_background,"Odered_Product")

}