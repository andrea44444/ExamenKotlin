package com.example.sumador.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavHostController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sumador.R
import com.example.sumador.viewModel.SumadorViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SumadorScreen (
    navController: NavHostController,
    viewModel: SumadorViewModel,
){
    var param1 by rememberSaveable { mutableStateOf("") }
    var param2 by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Column{
        TextField(
            value = param1,
            onValueChange = { param1= it  },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )
            Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = param2,
            onValueChange = { param2 = it},
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )}
        Button(
            onClick = {
                viewModel.updateCurrentParam1(param1)
                viewModel.updateCurrentParam2(param2)
                viewModel.resultado()
                viewModel.updateOperaciones(viewModel.uiState.value.param1.toString()+ " + " +viewModel.uiState.value.param2.toString() + " = " +viewModel.uiState.value.result+"\n")
                navController.navigate(R.string.routeResultado.toString())
            },
            modifier = Modifier
                .size(width = 100.dp, height = 60.dp)
        ){
            Text(text = "+",
                style = TextStyle(fontSize = 28.sp)
            )
        }

    }
}
