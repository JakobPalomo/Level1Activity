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
//        var number_one = arrayOf(1,2,3,"String_number",4,5,6)
//        var number_two = arrayOf<Int>(1,2,3,4,5,6)

        var textAccount = findViewById<TextView>(R.id.txtAccount)
        var buttonAccount = findViewById<Button>(R.id.btnAccount)
        var buttonUpdate = findViewById<Button>(R.id.btnUpdate)
        var editAccount = findViewById<EditText>(R.id.edtAccount)
        var buttonDelete = findViewById<Button>(R.id.btnDelete)
        var buttonShow = findViewById<Button>(R.id.btnFind)
        var editPassword = findViewById<EditText>(R.id.edtPassword)
        var addToastStatement: String="Account Existing"
        var updateToastStatement: String = "Not Existing Account"
        var deleteToastStatement: String = "Account not made"

        
        buttonAccount.setOnClickListener {
            //getText() && setText()

            try{
                val existingAccount = arrayAccount.stream().anyMatch{x -> x == editAccount.text.toString()}
                Log.i("info_palomo",existingAccount.toString())
                if (!existingAccount){
                    arrayAccount.add(editAccount.text.toString())
//                    arrayPassword.add(editPassword.text.toString())
                    textAccount.setText(arrayAccount.size.toString())

                    addToastStatement="Account Added"
                    Log.i("info_palomo",addToastStatement)
                }
                Toast.makeText(this, addToastStatement,Toast.LENGTH_SHORT).show()
                addToastStatement="Account is already existing"

            }catch(e: Exception){
                Log.i("error_palomo",e.message.toString())
            }

//            arrayAccount.add(editAccount.text.toString())
//            arrayPassword.add(editPassword.text.toString())
//            textAccount.setText(arrayAccount.size.toString())
//            Toast.makeText(this, "Added Account!", Toast.LENGTH_SHORT).show()
//
//            for (x in arrayPassword){
//                Log.i("info","Pass: "+x.toString())
//            }
            for (x in arrayAccount){
                Log.i("info",x.toString())
            }

        }

        buttonUpdate.setOnClickListener {

            try{
                var existingAccount = arrayAccount.indexOf(editAccount.text.toString())
                Log.i("info_palomo",existingAccount.toString())
                if (existingAccount >= 0){
                    arrayAccount[existingAccount] = arrayAccount[existingAccount] + "_updated"
                    updateToastStatement = "Update Successful"
                    Log.i("info_palomo",updateToastStatement)
                }
                    Toast.makeText(this, updateToastStatement,Toast.LENGTH_SHORT).show()
                    updateToastStatement = "Account is not Existing"

            }catch(e: Exception){
                Log.i("error_palomo",e.message.toString())
            }



        }

        buttonDelete.setOnClickListener {

            try{
                var existingAccount = arrayAccount.indexOf(editAccount.text.toString())
                Log.i("info_palomo",existingAccount.toString())
                if (existingAccount >= 0){
                    arrayAccount.removeAt(existingAccount)
                    textAccount.setText(arrayAccount.size.toString())
                    editAccount.setText(" ")
                    deleteToastStatement = "Account Deleted"
                    Log.i("info_palomo",deleteToastStatement)
                }
                Toast.makeText(this, deleteToastStatement,Toast.LENGTH_SHORT).show()
                deleteToastStatement = "Account has not been made"

            }catch(e: Exception){
                Log.i("error_palomo",e.message.toString())
            }


        }

        buttonShow.setOnClickListener {
            var arraySize = arrayAccount.size
            for (x in arrayAccount){
                Log.i("info_for",x)
            }
            while (arraySize > 0){
                Log.i("info_while",arrayAccount[arraySize-1])
                arraySize--
            }

            var arraySize_do=0

            do{
                arraySize_do++
                Log.i("info_dowhile",arrayAccount[arraySize_do-1])
            }while (arraySize_do < arrayAccount.size)

        }
        
    }
    
}
