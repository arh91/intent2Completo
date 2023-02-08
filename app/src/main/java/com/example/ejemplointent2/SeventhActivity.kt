package com.example.ejemplointent2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SeventhActivity : AppCompatActivity() {

    lateinit var codigoCliente: EditText
    lateinit var nombreCliente: EditText
    lateinit var telefonoCliente: EditText
    lateinit var direccionCliente: EditText
    lateinit var buscarCliente: Button
    lateinit var eliminarCliente: Button
    lateinit var modificarCliente: Button
    lateinit var ok: Button
    lateinit var atras: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seventh)

        codigoCliente = findViewById<EditText>(R.id.edtBuscarCodigoCliente)
        nombreCliente = findViewById<EditText>(R.id.edtBuscarNombreCliente)
        telefonoCliente = findViewById<EditText>(R.id.edtBuscarTelefonoCliente)
        direccionCliente = findViewById<EditText>(R.id.edtBuscarDireccionCliente)

        buscarCliente = findViewById<Button>(R.id.btnBuscarCliente)
        eliminarCliente = findViewById<Button>(R.id.btnEliminarCliente)
        modificarCliente = findViewById<Button>(R.id.btnModificarCliente)
        ok = findViewById<Button>(R.id.btnOkSeventh)
        atras = findViewById<Button>(R.id.btnAtrásSeventh)


        buscarCliente.setOnClickListener{

        }

        eliminarCliente.setOnClickListener{

        }

        modificarCliente.setOnClickListener{

        }

        ok.setOnClickListener{

        }

        atras.setOnClickListener{
            val intentFifth = Intent(this, FifthActivity::class.java)
            startActivity(intentFifth)
        }
    }
}