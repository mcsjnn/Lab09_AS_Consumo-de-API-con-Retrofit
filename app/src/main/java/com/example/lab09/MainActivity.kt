package com.example.lab09

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab09.ui.theme.Lab09Theme
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab09Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProgPrincipal9()
                }
            }
        }
    }
}

@Composable
fun ProgPrincipal9() {
    val urlBase = "https://jsonplaceholder.typicode.com/"
    val retrofit = Retrofit.Builder().baseUrl(urlBase)
        .addConverterFactory(GsonConverterFactory.create()).build()
    // Servicio inicializado
    val servicio = retrofit.create(PostApiService::class.java)
    val navController = rememberNavController()

    Scaffold(
        topBar = { BarraSuperior() },
        bottomBar = { BarraInferior(navController) },
        content = { paddingValues -> Contenido(paddingValues, navController, servicio) }
    )
}

@Composable
fun BarraSuperior() {
    // Implementación de la barra superior
}

@Composable
fun BarraInferior(navController: Unit) {
    // Implementación de la barra inferior
}

@Composable
fun Contenido(paddingValues: PaddingValues, navController: Unit, servicio: PostApiService) {
    // Implementación del contenido principal
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab09Theme {
        ProgPrincipal9()
    }
}

fun rememberNavController() {
    TODO("Not yet implemented")
}