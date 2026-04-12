package com.example.laboratorio4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.laboratorio4.ui.theme.Laboratorio4Theme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Tarjeta(
                        titulo = "Componente 1",
                        desc = "Contenedor con bordes y color.",
                        color = Color(0xFF1A1A1A),
                        accentColor = Color(0xFF00E5FF),
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        Text("Ya estás dentro de una Card", color = Color.White)
                    }
                }
            }
        }
    }
}

@Composable
fun Tarjeta(titulo: String, desc: String, color: Color, accentColor: Color, modifier: Modifier = Modifier, contenido: @Composable () -> Unit) {
    Card(
        modifier = modifier.fillMaxWidth().padding(16.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = color)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(titulo, fontWeight = FontWeight.Bold, fontSize = 20.sp, color = accentColor)
            Text(desc, fontSize = 12.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(16.dp))
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
                contenido()
            }
        }
    }
}