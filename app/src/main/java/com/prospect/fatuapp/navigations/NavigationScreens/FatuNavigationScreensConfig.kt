package com.prospect.fatuapp.navigations.NavigationScreens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.prospect.fatuapp.navigations.NavItemScreens.BottomNavItemScreens
import com.prospect.fatuapp.navigations.NavItemScreens.DrowerNavItemScreens
import com.prospect.fatuapp.screens.*


@OptIn(ExperimentalComposeUiApi::class)
@RequiresApi(Build.VERSION_CODES.O)

@Composable
fun FatuNavigationScreensConfig(navController : NavHostController){


    NavHost(navController , startDestination = BottomNavItemScreens.DashBoard.screen_route){
        composable(BottomNavItemScreens.DashBoard.screen_route){
            DashBoard()
        }

        composable(BottomNavItemScreens.RestProduct.screen_route){
            RestProduct()
        }
        composable(BottomNavItemScreens.ReturedProduct.screen_route){
            ReturedProduct()
        }
        composable(BottomNavItemScreens.Notification.screen_route){
            Notification()
        }
        composable(BottomNavItemScreens.Oder.screen_route){
            Oder()
        }

        ////////////////////// DROWER NAVIGATION
        composable(DrowerNavItemScreens.AddProductToPos.screen_route){
            AddProductToPos()
        }
        composable(DrowerNavItemScreens.OderedProduct.screen_route){
            OderedProduct()
        }
    }
}


