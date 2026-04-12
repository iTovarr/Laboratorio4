package com.example.laboratorio4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn // Nuevo Import
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio4.ui.theme.Laboratorio4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        item {
                            Tarjeta(
                                titulo = "Componente 1: Tarjeta",
                                desc = "Contenedor con bordes y color.",
                                color = Color(0xFF1A1A1A),
                                accentColor = Color(0xFF00E5FF)
                            ) {
                                Text("Elemento dentro de una Card", color = Color.White)
                            }
                        }

                        item {
                            Tarjeta(
                                titulo = "Componente 2: LazyColumn",
                                desc = "Este contenedor permite scroll eficiente.",
                                color = Color(0xFF1A1A1A),
                                accentColor = Color(0xFFBB86FC)
                            ) {
                                Text("Estamos dentro de una lista", color = Color.White)
                            }
                        }
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