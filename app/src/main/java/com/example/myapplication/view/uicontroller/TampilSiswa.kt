package com.example.myapplication.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.viewmodel.SiswaUIState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilSiswa(
    statusUISiswa: SiswaUIState,
    onBackButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Mapping label menggunakan resource string terbaru
    val items = listOf(
        Pair(stringResource(id = R.string.nama), statusUISiswa.nama),
        Pair(stringResource(id = R.string.gender), statusUISiswa.gender),
        Pair(stringResource(id = R.string.alamat), statusUISiswa.alamat)
    )

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                // Menggunakan R.string.detail
                title = { Text(text = stringResource(id = R.string.detail), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.purple_500)
                )
            )
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier
                .padding(isiRuang)
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = dimensionResource(id = R.dimen.padding_medium)),
                verticalArrangement = Arrangement.spacedBy(space = dimensionResource(id = R.dimen.padding_medium))
            ) {
                items.forEach { item ->
                    Column {
                        Text(text = item.first.uppercase(), fontSize = 16.sp)
                        Text(text = item.second, fontWeight = FontWeight.Bold, fontSize = 16.sp)

                        Divider(thickness = dimensionResource(id = R.dimen.thickness_divider))
                    }
                }

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))

                // Tombol Back
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onBackButtonClicked
                ) {
                    // Menggunakan R.string.back
                    Text(text = stringResource(R.string.back))
                }
            }
        }
    }
}