package com.prospect.fatuapp.navigations

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.prospect.fatuapp.models.Oder_Product
import com.prospect.fatuapp.screens.*

@OptIn(ExperimentalComposeUiApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationScreens(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Splash.name){
        composable(Screens.Splash.name){
            Splash(navController=navController)
        }

        composable(Screens.AddProductToPos.name){
            AddProductToPos(
                navController =navController
            )
        }
        composable(Screens.DashBoard.name){
            DashBoard(
                navController =navController
            )
        }
        composable(Screens.Login.name){
            Login(
                navController =navController
            )
        }
        composable(Screens.Oder.name){
            Oder(
                Oder_Products= ,
                onAddOder_Product= (Oder_Product) -> Unit,
                onRemoveOder_Product=Oder_Product,
                navController =navController
            )
        }
        composable(Screens.OderedProduct.name){
           OderedProduct(
                navController = navController
            )
        }
        composable(Screens.OderReport.name){
            OderReport(
                navController = navController
            )
        }
        composable(Screens.OderReportDetails.name){
          OderReportDetails(
                navController = navController
            )
        }
        composable(Screens.RecyclerBinOder.name){
            RecyclerBinOder(
                navController =navController
            )
        }
        composable(Screens.RecyclerBinPos.name){
            RecyclerBinPos(
                navController =navController
            )
        }
        composable(Screens.RecyclerBinStock.name){
            RecyclerBinStock(
                navController =navController
            )
        }
        composable(Screens.Registration.name){
            Registration (
                navController =navController
            )
        }
        composable(Screens.Report.name){
            Report(
                navController =navController
            )
        }
        composable(Screens.ReportDetails.name){
           ReportDetails(
                navController = navController
            )
        }
        composable(Screens.RestProduct.name){
            RestProduct(
                navController =navController
            )
        }
        composable(Screens.ReturnedProduct.name){
            ReturedProduct(
                navController = navController
            )
        }
        composable(Screens.Statistics.name){
            Statistics(
                navController = navController
            )
        }







    }
}
