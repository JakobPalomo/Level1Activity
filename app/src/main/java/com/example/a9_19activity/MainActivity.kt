package com.example.a9_19activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //arrayList
        var arrayAccount = ArrayList<String>()
        var arrayPassword = ArrayList<String>()

        //array
        var number_one = arrayOf(1,2,3,"String_number",4,5,6)
        var number_two = arrayOf<Int>(1,2,3,4,5,6)

        var textAccount = findViewById<TextView>(R.id.txtAccount)
        var buttonAccount = findViewById<Button>(R.id.btnAccount)
        var buttonFind = findViewById<Button>(R.id.btnFind)
        var editAccount = findViewById<EditText>(R.id.edtAccount)
        var editPassword = findViewById<EditText>(R.id.edtPassword)
        
        buttonAccount.setOnClickListener {
            //getText() && setText()

            arrayAccount.add(editAccount.text.toString())
            arrayPassword.add(editPassword.text.toString())
            textAccount.setText(arrayAccount.size.toString())
            Toast.makeText(this, "Added Account!", Toast.LENGTH_SHORT).show()

            for (x in arrayPassword){
                Log.i("info","Pass: "+x.toString())
            }
            for (x in arrayAccount){
                Log.i("info",x.toString())
            }

        }
        
    }
    
}
