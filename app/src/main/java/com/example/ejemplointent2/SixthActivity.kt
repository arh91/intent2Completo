package com.example.ejemplointent2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SixthActivity : AppCompatActivity() {

    lateinit var codigoProveedor: EditText
    lateinit var nombreProveedor: EditText
    lateinit var telefonoProveedor: EditText
    lateinit var direccionProveedor: EditText
    lateinit var buscarProveedor: Button
    lateinit var eliminarProveedor: Button
    lateinit var modificarProveedor: Button
    lateinit var ok: Button
    lateinit var atras: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sixth)

        codigoProveedor = findViewById<EditText>(R.id.edtBuscarCodigoProveedor)
        nombreProveedor = findViewById<EditText>(R.id.edtBuscarNombreProveedor)
        telefonoProveedor = findViewById<EditText>(R.id.edtBuscarTelefonoProveedor)
        direccionProveedor = findViewById<EditText>(R.id.edtBuscarDireccionProveedor)

        buscarProveedor = findViewById<Button>(R.id.btnBuscarProveedor)
        eliminarProveedor = findViewById<Button>(R.id.btnEliminarProveedor)
        modificarProveedor = findViewById<Button>(R.id.btnModificarProveedor)
        ok = findViewById<Button>(R.id.btnOkSeventh)
        atras = findViewById<Button>(R.id.btnAtrásSixth)


        buscarProveedor.setOnClickListener{

        }

        eliminarProveedor.setOnClickListener{

        }

        modificarProveedor.setOnClickListener{

        }

        ok.setOnClickListener{

        }

        atras.setOnClickListener{
            val intentFourth = Intent(this, FourthActivity::class.java)
            startActivity(intentFourth)
        }
    }
}