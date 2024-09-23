package com.rbk.tweetsyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import com.rbk.tweetsyapp.screens.CategoryScreen
import com.rbk.tweetsyapp.ui.theme.TweetsyAppDITheme
import dagger.hilt.android.AndroidEntryPoint

//imported explicitly because composable{} block was showing red
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.rbk.tweetsyapp.screens.DetailScreen


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            TweetsyAppDITheme {
             App()
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
   val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "category") {
        composable(route="category"){
            //if we have last parameter as lamda fun we can move lamda outside the parenthesis
            CategoryScreen(onClick = {
                navController.navigate("details/${it}")
            })
        }
        composable(route="details/{category}",
            arguments = listOf(
                navArgument("category"){
                    type=NavType.StringType
                }
            )
            ){
            DetailScreen()
        }

    }
}