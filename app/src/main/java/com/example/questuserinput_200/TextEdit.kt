package com.example.questuserinput_200

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.questuserinput_200.R

@Composable
fun FormDataDiri(modifier: Modifier = Modifier) {
    var textNama by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(top = 50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = textNama,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(250.dp),
            label = { Text(text = "Nama Lengkap") },
            onValueChange = { textNama = it }
        )
    }
}
val gender: List<String> = listOf("Laki-laki", "Perempuan")
var textJK by remember { mutableStateOf("") }

Row {
    gender.forEach { item ->
        Row(
            modifier = Modifier.selectable(
                selected = textJK == item,
                onClick = { textJK = item }
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = textJK == item,
                onClick = { textJK = item }
            )
            Text(item)
        }
    }
}
var textAlamat by remember { mutableStateOf("") }

OutlinedTextField(
value = textAlamat,
singleLine = true,
modifier = Modifier.width(250.dp),
label = { Text(text = "Alamat Lengkap") },
onValueChange = { textAlamat = it }
)

Divider(
modifier = Modifier.padding(vertical = 8.dp),
thickness = 1.dp,
color = Color.DarkGray
)

