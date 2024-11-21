package com.example.pertemuan7.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import model.DataMahasiswa

@Composable
fun DataMahasiswaView(
    modifier: Modifier = Modifier,
    uiStateMahasiswa: DataMahasiswa,
){
    val listDataMahasiswa = listOf(
        Pair("Nama", uiStateMahasiswa.nama),
        Pair("gender", uiStateMahasiswa.gender),
        Pair("Alamat", uiStateMahasiswa.alamat)
    )

    Column {
        listDataMahasiswa.forEach{items ->
            CardSection(
                judulParam = items.first,
                Isiparams  = items.second
            )
        }
    }
}