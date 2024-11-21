package com.example.arsitektumvvm

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.arsitektumvvm.ui.viewmodel.MahasiswaViewModel
import com.example.pertemuan7.ui.view.DataMahasiswaView
import com.example.pertemuan7.ui.view.FormMahasiswaView
import model.DataKelamin

enum class Halaman{
    Formulir,
    Detail,
}

@Composable
fun PengelolaanHalaman(
    modifier: Modifier = Modifier,
    navHost: NavHostController = rememberNavController(),
    viewModel: MahasiswaViewModel = viewModel()
){
    Scaffold { isipadding ->
        val uiState by viewModel.uiState.collectAsState()
        NavHost(
            modifier = modifier.padding(isipadding),
            navController = navHost, startDestination = Halaman.Formulir.name
        ) {
            composable(route = Halaman.Formulir.name) {
                val konteks = LocalContext.current
                FormMahasiswaView(
                    listJk =  DataKelamin.listJK.map {
                            isi -> konteks.resources.getString(isi)
                    },
                    onSubmitClicked = {
                        viewModel.saveDataMahasiswa(it)
                        navHost.navigate(Halaman.Detail.name)
                    }
                )
            }
            composable(route = Halaman.Detail.name){
                DataMahasiswaView(
                    uiStateMahasiswa = uiState,
                    onClikButton = {
                        navHost.popBackStack()
                    }
                )
            }
        }
    }
}


