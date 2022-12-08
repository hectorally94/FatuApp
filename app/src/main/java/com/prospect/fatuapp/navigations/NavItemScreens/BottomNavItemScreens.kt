package com.prospect.fatuapp.navigations.NavItemScreens

import com.prospect.fatuapp.R

sealed class BottomNavItemScreens(var title:String, var icon:Int, var screen_route:String){

    object DashBoard : BottomNavItemScreens("Home", R.drawable.icons8_home_24,"dashboard")
    object RestProduct: BottomNavItemScreens("Product",R.drawable.icons8_rest_product_24,"rest_Product")
    object ReturedProduct: BottomNavItemScreens("Product",R.drawable.icons8_packing_24,"returned_Product")
    object Notification: BottomNavItemScreens("Notification",R.drawable.icons8_notification_24,"notification")
    object Oder: BottomNavItemScreens("Oder Product",R.drawable.icons8_oder_24,"Oder_Product")
}
