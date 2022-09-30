package com.example.mensagem

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.net.URLEncoder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var number: EditText = findViewById(R.id.number)
        var message: EditText = findViewById(R.id.msg)
        var sendButton: Button = findViewById(R.id.sendbtn)

        sendButton.setOnClickListener{
            if(number.text.isNotEmpty() && message.text.isNotEmpty()){
                if(number.text.length >= 14) {

                    var intent = Intent(Intent.ACTION_VIEW)
                    var url = "https://api.whatsapp.com/send?phone=" + number.text.toString() +
                            "&text=" + URLEncoder.encode(message.text.toString(), "UTF-8")
                    intent.setPackage("com.whatsapp")
                    intent.data = Uri.parse(url)
                    if (intent != null) {
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this, "Ocorreu um erro!", Toast.LENGTH_LONG).show()
                    }
                }
                else {
                    Toast.makeText(this, "O número inserido não é válido!", Toast.LENGTH_LONG).show()
                }
            }
            else {
                Toast.makeText(this,"Favor preencher número e mensagem", Toast.LENGTH_LONG).show()
            }
        }
    }
}