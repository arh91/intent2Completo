package com.example.ejemplointent2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.*

class FifthActivity : AppCompatActivity() {

    // Creamos variables para editText y Buttons
    lateinit var codigoCliente:EditText
    lateinit var nombreCliente:EditText
    lateinit var telefonoCliente: EditText
    lateinit var direccionCliente: EditText

    lateinit var insertarDatos: Button
    lateinit var atras: Button
    lateinit var masOpciones: Button

    lateinit var firebaseDatabase: FirebaseDatabase

    //Creamos variable para referenciar nuestra base de datos
    lateinit var databaseReference: DatabaseReference


    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)

        //Inicializamos variables para identificar los editText y Buttons del layout
        codigoCliente = findViewById<EditText>(R.id.edtCodigoCliente)
        nombreCliente = findViewById<EditText>(R.id.edtNombreCliente)
        telefonoCliente = findViewById<EditText>(R.id.edtTelefonoCliente)
        direccionCliente = findViewById<EditText>(R.id.edtDireccionCliente)

        insertarDatos = findViewById<Button>(R.id.btnEnviarCliente)
        atras = findViewById<Button>(R.id.btnAtrasFifth)
        masOpciones = findViewById<Button>(R.id.btnOpcionesCliente)


        firebaseDatabase = FirebaseDatabase.getInstance()

        // Obtenemos la referencia a nuestra base de datos en Firebase
        databaseReference = firebaseDatabase!!.getReference("MyDatabase")


        //Añadimos evento al botón insertarDatos

        insertarDatos.setOnClickListener {
            // Capturamos cadenas introducidas por usuario y las almacenamos en variables
            var code: String = codigoCliente.text.toString()
            var name: String = nombreCliente.text.toString()
            var phone: String = telefonoCliente.text.toString()
            var address: String = direccionCliente.text.toString()

            // Si alguno de los campos está sin rellenar, lanzamos aviso al usuario para que los rellene todos.
            if (TextUtils.isEmpty(code) || TextUtils.isEmpty(name) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(address)) {
                Toast.makeText(this@FifthActivity, "Por favor, rellena todos los campos.", Toast.LENGTH_SHORT).show()
            } else {
                //En caso contrario, llamamos al método que añadirá los datos introducidos a Firebase, y posteriormente dejamos en blanco otra vez todos los campos
                addDatatoFirebase(code, name, address, phone)
                clearFields()
            }
        }


        //Añadimos evento al boton masOpciones

        masOpciones.setOnClickListener(){
            val toSeventh = Intent(this, SeventhActivity::class.java)
            startActivity(toSeventh)
        }


        //Añadimos evento al botón atras

        atras.setOnClickListener{
            val toThird = Intent(this, ThirdActivity::class.java)
            startActivity(toThird)
        }
    }


    private fun addDatatoFirebase(code: String, name: String, address: String, phone: String) {

        //Creamos un objeto de nuestra clase Cliente al que le pasamos las 4 cadenas introducidas por el usuario en los editText
        val cliente = Cliente(code, name, address, phone)


        // Ahora comprobamos si el código introducido por el usuario ya está registrado en nuestra base de datos o no

        databaseReference.child("Clientes").orderByChild("codigo").equalTo(code).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                //Si el código ya está registrado, lanzamos un aviso al usuario para que pruebe con otro distinto
                if(snapshot.exists()){
                    Toast.makeText(this@FifthActivity, "El código introducido ya existe.", Toast.LENGTH_SHORT).show()
                }else {
                    //En caso contrario, la aplicación registrará el nuevo objeto cliente en la tabla Clientes de nuestra base de datos
                    databaseReference.child("Clientes").child(code).setValue(cliente)

                    // Avisamos al usuario que los datos se han guardado correctamente
                    Toast.makeText(this@FifthActivity, "Datos guardados.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Si los datos no se han podido guardar correctamente, lanzamos aviso al usuario
                Toast.makeText(this@FifthActivity, "No se pudieron guardar los datos. $error", Toast.LENGTH_SHORT).show()
            }
        })
    }

    //Método que vuelve a dejar en blanco todos los campos del layout
    fun clearFields(){
       codigoCliente.setText("")
       nombreCliente.setText("")
       direccionCliente.setText("")
       telefonoCliente.setText("")
    }
}