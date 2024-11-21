package com.example.pertemuan7.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import model.DataMahasiswa

data class MahasiswaViewModel: ViewModel(){
    private val _uiStatae = MutableStateFlow(DataMahasiswa())
    val uiState: StateFlow<DataMahasiswa> = _uiStatae.asStateFlow()

    fun saveDataMahasiswa(listDM: List<String>){
        _uiStatae.update { dataMhs ->
            dataMhs.copy(
                nama = listDM[0],
                gender = listDM [1],
                alamat = listDM[2]
            )
        }
    }
}
