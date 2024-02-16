package com.example.enviarmensaje


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.Manifest
import android.content.pm.PackageManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        val MY_PERMISSIONS_REQUEST_SEND_SMS = 1
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)



        button.setOnClickListener {
            val phone = "+52 7331097828"
            val text = "Este es un mensaje de prueva."
            val sms = SmsManager.getDefault()
            sms.sendTextMessage(phone, null, text, null, null)
        }
        button2.setOnClickListener {
            val phone:EditText = findViewById(R.id.PhoneNumber)
            val texto : EditText= findViewById(R.id.Mensaje)
            val numero = phone.text.toString()
            val mensaje = texto.text.toString()
            if (numero.isEmpty() || mensaje.isEmpty()) {
                Toast.makeText(this, "Número o mensaje vacíos, favor de llenar los campos", Toast.LENGTH_SHORT).show()
            } else {
                val sms = SmsManager.getDefault()
                sms.sendTextMessage(numero, null, mensaje, null, null)
                val numero = phone.setText("")
                val mensaje = texto.setText("")
                Toast.makeText(this, "Mensaje enviado", Toast.LENGTH_SHORT).show()
            }
        }
        button3.setOnClickListener {
            val phone:EditText = findViewById(R.id.PhoneNumber)
            val texto : EditText= findViewById(R.id.Mensaje)
            val numero = phone.setText("")
            val mensaje = texto.setText("")
        }

    }
}
