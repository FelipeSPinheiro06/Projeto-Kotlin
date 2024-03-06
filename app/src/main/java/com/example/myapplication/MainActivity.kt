package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnCalcular = findViewById<Button>(R.id.btnCalcular)
        // Função que implementa o evento de clique em um botão
        btnCalcular.setOnClickListener {view : View? ->
            var txtAlcool = findViewById<EditText>(R.id.txtPrecoAlcool)
            // declaração implícita do tipo de variável
            var precoAlcool = txtAlcool.text.toString().toDouble()
            var txtGasolina = findViewById<EditText>(R.id.txtPrecoGasolina)
            var precoGasolina = txtGasolina.text.toString().toDouble()
            // declaração explícita do tipo da variável
            var resultado : Double = precoAlcool / precoGasolina
            var mensagem = ""
            if (resultado > 0.7) {
                mensagem = "Gasolina"
            }
            else if (resultado < 0.7) {
                mensagem = "Álcool"
            }
            else {
                mensagem = "Tanto faz"
            }
            Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show()
        }


    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}