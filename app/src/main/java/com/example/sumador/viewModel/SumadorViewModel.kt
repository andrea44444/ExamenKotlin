package com.example.sumador.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class SumadorViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(
        SumadorUiState(
            param1 = 0,
            param2 = 0,
            result= "",
            operaciones = "Result:\n\n"
        )
    )
    val uiState: StateFlow<SumadorUiState> = _uiState

    fun updateCurrentParam1(nuevoNum:String){
        _uiState.update {
            it.copy(param1 = nuevoNum.toIntOrNull() ?: 0)
        }
    }
    fun updateCurrentParam2(nuevoNum:String){
        _uiState.update {
            it.copy(param2 = nuevoNum.toIntOrNull() ?: 0)
        }
    }

    fun resultado(){
        _uiState.update {
            it.copy(result = (uiState.value.param1 + uiState.value.param2).toString())
        }
    }

    fun updateOperaciones(operacion : String){
        _uiState.update {
            it.copy(operaciones = uiState.value.operaciones+operacion)
        }
    }

}

data class SumadorUiState(
    val param1: Int = 0,
    val param2: Int = 0,
    val result: String = "",
    val operaciones : String = ""
)
