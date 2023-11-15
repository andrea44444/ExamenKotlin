package com.example.sumador

import android.os.Bundle
import android.provider.Settings.Global.getString
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.sumador.ui.theme.SumadorTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sumador.screens.ResultadoScreen
import com.example.sumador.screens.SumadorScreen
import com.example.sumador.viewModel.SumadorViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SumadorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainApp()
                }
            }
        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()

    NavigationController(
        navController = navController,
        modifier = Modifier
            .fillMaxSize()
            .padding(46.dp)
    )
}

@Composable
fun NavigationController(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val viewModel: SumadorViewModel = viewModel()
    NavHost(navController = navController, startDestination = R.string.routeSumador.toString()) {
        composable(R.string.routeSumador.toString()) {
            SumadorScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(R.string.routeResultado.toString()) {
            ResultadoScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SumadorTheme {
        MainApp()
    }
}