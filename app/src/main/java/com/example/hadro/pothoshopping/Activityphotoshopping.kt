package com.example.hadro.pothoshopping

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.io.*
import java.util.*
import java.util.*


class Activityphotoshopping : AppCompatActivity() {

    val texto= findViewById(R.id.parbuscar) as EditText
    val check = findViewById(R.id.botbuscar) as Button
    var adapter : ArrayAdapter<String>? = null
    var lang : ArrayList<String> = ArrayList <String>()


  /**  fun main(args:Array<String>){

       var str: String = texto.toString()
        WriteToFile(str)

    }

    fun WriteToFile(str:String){
        try{    var fo=FileWriter("historial.txt",true)
                fo.write(str + "\n")
               fo.close()
       }       catch (ex:Exception){ Toast.makeText(applicationContext,ex.message, Toast.LENGTH_SHORT).show()}
    }

    fun ReadFromFile(){
        try{    var fin=FileReader("historial.txt")
                var c:Int?
                do{ c=fin.read()
            }   while(c!=-1)
        }       catch (ex:Exception){Toast.makeText(applicationContext,ex.message, Toast.LENGTH_SHORT).show()}


    }*/

  private fun eliminar (pos : Int) {
      lang.removeAt(pos)
      adapter?.notifyDataSetChanged()
  }

  fun WriteToFile(str:String){
      val fo = PrintStream(
          openFileOutput("data.txt", MODE_APPEND))

      try{
          fo.println(str + "\n")
          fo.close()
      }       catch (ex:Exception){ Toast.makeText(applicationContext,ex.message, Toast.LENGTH_SHORT).show()}
  }


    fun ReadFromFile(args:Array<String>){
        try{

            val scan = Scanner(
                openFileInput("data.txt"))
            var allText = "" // read entire file
            while (scan.hasNextLine()) {
                val line = scan.nextLine()
                lang.add(line)
                adapter?.notifyDataSetChanged()
                allText += line

            }
          //  myTextView.setText(allText)
            scan.close()
        }       catch (ex:Exception){Toast.makeText(applicationContext,ex.message, Toast.LENGTH_SHORT).show()}


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layoutphotoshopping)

         check.setOnClickListener{
            var str: String = texto.toString()
            WriteToFile(str)
         }

        var Lista1 = findViewById<ListView>(R.id.Historial)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lang)
        Lista1.adapter = adapter

        Lista1.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, id ->

            when (i) {
                0 ->  Toast.makeText(applicationContext, "No se Puede eliminar ", Toast.LENGTH_SHORT).show()
                else ->  eliminar(i)
            }
        }

}


}
