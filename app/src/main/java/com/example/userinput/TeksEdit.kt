package com.example.userinput

import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp


@Composable
fun FormDataDiri(modifier: Modifier
){
    // variabel untuk mengingat nilai masukan dari keyboard
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }

    //Variabel Untuk Menyimpan data yang diperoleh dari komponen ui
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }

    val gender: List<String> = listOf("Laki-Laki","Perempuan")

    Column(modifier = Modifier.padding(top = 50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = textNama,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(width = 250.dp),
            label = { Text(text = "Nama Lengkap") },
            onValueChange = {
                textNama = it
            }
        )
    }
    Row {
        gender.forEach { item ->
            Row(modifier = Modifier.selectable(
                selected = textJK == item,
                onClick = {textJK = item}
            ), verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = textJK == item,
                    onClick = {
                        textJK = item
                    })
                Text(text = item)
            }
        }
    }
    OutlinedTextField(
        value = textAlamat,
        singleLine =true,
        modifier = Modifier.width(250.dp),
        label ={Text("Alamat Lengkap")},
        onValueChange = {
            textAlamat = it
        }

    )
    Divider(
        modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium),
            top = dimensionResource(R.dimen.padding_medium
            )),
        thickness = dimensionResource(R.dimen.divider_tipis),
        color = Color.DarkGray
    )
    Button(
        modifier = Modifier.fillMaxWidth(1f),
        //the button is enabled when user makes a selection
        enabled = textAlamat.isNotEmpty(),
        onClick = {
            nama=textNama
            jenis=textJK
            alamat=textAlamat
        }
    )
}