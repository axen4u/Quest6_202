package com.example.myapplication.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormSiswa(
    pilihanJK: List<String>,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier
) {
    var txtNama by rememberSaveable { mutableStateOf("") }
    var txtAlamat by rememberSaveable { mutableStateOf("") }
    var txtGender by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                // Menggunakan R.string.app_name (My Application)
                title = { Text(text = stringResource(id = R.string.app_name), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.purple_500)
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Input Nama
            OutlinedTextField(
                value = txtNama,
                singleLine = true,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.width(250.dp).padding(top = 20.dp),
                // Menggunakan R.string.nama
                label = { Text(text = stringResource(id = R.string.nama)) },
                onValueChange = { txtNama = it }
            )

            // Divider 1
            HorizontalDivider(
                modifier = Modifier
                    .padding(all = 12.dp)
                    .width(250.dp),
                thickness = dimensionResource(id = R.dimen.thickness_divider),
                color = Color.Blue
            )

            // Pilihan Jenis Kelamin
            Row {
                pilihanJK.forEach { item ->
                    Row(
                        modifier = Modifier.selectable(
                            selected = txtGender == item,
                            onClick = { txtGender = item }
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = txtGender == item,
                            onClick = { txtGender = item }
                        )
                        Text(text = item)
                    }
                }
            }

            // Divider 2
            HorizontalDivider(
                modifier = Modifier
                    .padding(all = 5.dp)
                    .width(250.dp),
                thickness = dimensionResource(id = R.dimen.thickness_divider),
                color = Color.Blue
            )

            // Input Alamat
            OutlinedTextField(
                modifier = Modifier.width(250.dp),
                value = txtAlamat,
                singleLine = true,
                shape = MaterialTheme.shapes.medium,
                // Menggunakan R.string.alamat
                label = { Text(text = stringResource(id = R.string.alamat)) },
                onValueChange = { txtAlamat = it }
            )

