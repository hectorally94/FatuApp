package com.prospect.fatuapp.Activities

import android.R
import android.content.res.Resources.Theme
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.google.android.material.color.MaterialColors
import com.prospect.fatuapp.components.BottomNavigationComponent
import com.prospect.fatuapp.components.DrawerComponent
import com.prospect.fatuapp.components.TopBarComponent
import com.prospect.fatuapp.navigations.NavigationScreens.FatuNavigationScreensConfig
import com.prospect.fatuapp.ui.theme.FatuAppTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FatuAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    //NavigationScreens()
                    ShowDrawerButtonNavigation()
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ShowDrawerButtonNavigation() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBarComponent(scope = scope, scaffoldState = scaffoldState) },
        drawerBackgroundColor = MaterialTheme.colors.primary,
        // scrimColor = Color.Red,  // Color for the fade background when you open/close the drawer
        drawerContent = {
            DrawerComponent(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
        bottomBar = { BottomNavigationComponent(navController = navController) },

        backgroundColor = MaterialTheme.colors.primaryVariant

    ) {

        FatuNavigationScreensConfig(navController = navController)
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FatuAppTheme {
        ShowDrawerButtonNavigation()

    }
}
