package com.example.questuserinput_200

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormulirPendaftaran() {
    // variabel data
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jk by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    val listJK = listOf("Laki-laki", "Perempuan")
    val listStatus = listOf("Lajang", "Menikah", "Duda / Janda")

    // warna background gradasi
    val gradientBg = Brush.verticalGradient(
        colors = listOf(Color(0xFF6A5AE0), Color(0xFF9D84FF))
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBg)
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Formulir Pendaftaran",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4B3AE3)
                )

                Spacer(modifier = Modifier.height(15.dp))

                // Input Nama
                OutlinedTextField(
                    value = nama,
                    onValueChange = { nama = it },
                    label = { Text("Nama Lengkap") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Jenis Kelamin
                Text("Jenis Kelamin", fontWeight = FontWeight.SemiBold)
                listJK.forEach { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = jk == item,
                                onClick = { jk = item }
                            )
                            .padding(vertical = 3.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(selected = jk == item, onClick = { jk = item })
                        Text(item)
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Status Perkawinan
                Text("Status", fontWeight = FontWeight.SemiBold)
                listStatus.forEach { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = status == item,
                                onClick = { status = item }
                            )
                            .padding(vertical = 3.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(selected = status == item, onClick = { status = item })
                        Text(item)
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Input Alamat
                OutlinedTextField(
                    value = alamat,
                    onValueChange = { alamat = it },
                    label = { Text("Alamat Lengkap") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Tombol submit
                Button(
                    onClick = {
                        println("Data terkirim: $nama, $jk, $status, $alamat")
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5C4BFF)),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text("Kirim", fontSize = 16.sp, color = Color.White)
                }
            }
        }
    }
}
