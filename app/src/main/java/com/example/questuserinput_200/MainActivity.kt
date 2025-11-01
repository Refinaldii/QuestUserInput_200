package com.example.questuserinput_200

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.questuserinput_200.ui.theme.QuestUserInput_200Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuestUserInput_200Theme {
                FormulirPendaftaran()
            }
        }
    }
}
