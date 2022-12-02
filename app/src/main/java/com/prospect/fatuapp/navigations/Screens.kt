package com.prospect.fatuapp.navigations

import com.prospect.fatuapp.screens.ReturedProduct

enum class Screens {
    Splash,
    AddProductToPos,
    DashBoard,
    Login,
    Oder,
    OderedProduct,
    OderReport,
    OderReportDetails,
    RecyclerBinOder,
    RecyclerBinPos,
    RecyclerBinStock,
    Registration,
    Report,
    ReportDetails,
    RestProduct,
    ReturnedProduct,
    Statistics;

    companion object{
        fun fromRoute(route:String?): Screens
                =when(route?.substringBefore("/")){
            Splash.name-> Splash
            AddProductToPos.name-> AddProductToPos
            DashBoard.name-> DashBoard
            Login.name-> Login
            Oder.name-> Oder
            OderedProduct.name-> OderedProduct
            OderReport.name-> OderReport
            OderReportDetails.name-> OderReportDetails
            RecyclerBinOder.name-> RecyclerBinOder
            RecyclerBinPos.name-> RecyclerBinPos
            RecyclerBinStock.name-> RecyclerBinStock
            Registration.name-> Registration
            Report.name-> Report
            ReportDetails.name-> ReportDetails
            RestProduct.name-> RestProduct
            ReturnedProduct.name-> ReturnedProduct
            Statistics.name-> Statistics
            null-> Splash
            else->throw IllegalArgumentException("Route $route Not recognize")
        }
    }
}