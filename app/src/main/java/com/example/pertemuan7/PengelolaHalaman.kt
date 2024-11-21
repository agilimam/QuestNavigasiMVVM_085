package com.example.pertemuan7

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.arsitektumvvm.ui.viewmodel.MahasiswaViewModel
import model.DataKelamin
import model.DataMahasiswa


enum class  Halaman {
    Formulir,
    Detail,
}
@Composable
fun PengelolaHalaman(
    navController: NavController = rememberNavController(),
    viewModel: MahasiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()
){
    Scaffold { isipadding ->
        val  uiState by viewModel.uiState.collectAsState()
        NavHost(
            modifier = modifier.padding(isipadding),
            navController = navHost, startDestination = Halaman.Formulir.name
        ) {
            composable(route= Halaman.Formulir.name){
                val konteks = LocalContext.current
                FormulirView(

                    //dibawh ini merupakan parameter halaman formulirview
                    pilihanJK = DataKelamin.listJK.map {
                        list -> konteks.resources.getString(list)
                    },
                )

            }


        }
    }

}