package com.example.sumador.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sumador.R
import com.example.sumador.viewModel.SumadorViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ResultadoScreen (
        navController: NavHostController,
        viewModel: SumadorViewModel
    ){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = viewModel.uiState.value.param1.toString() + " + "+
                    viewModel.uiState.value.param2.toString() + " = "+
                    viewModel.uiState.value.result,
            style = TextStyle(fontSize = 25.sp))
        Text(text = viewModel.uiState.value.operaciones,
            style = TextStyle(fontSize = 25.sp))
        Button(
            onClick = {
                navController.navigateUp()
            },
            modifier = Modifier
                .size(width = 200.dp, height = 60.dp)
        ){
            Text(text = stringResource(R.string.boton),
                style = TextStyle(fontSize = 28.sp)
            )
        }
    }
}