package com.example.mywish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity()
{
    //lateinit var items: List<Item>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rv)


        val button: Button = findViewById(R.id.button)

        val etName: EditText = findViewById(R.id.name)
        val etCost: EditText = findViewById(R.id.cost)
        val etURL: EditText = findViewById(R.id.url)

        var items: MutableList<Item> = mutableListOf<Item>()

        button.setOnClickListener()
        {

            if(etName.text.isEmpty() || etCost.text.isEmpty() || etURL.text.isEmpty())
            {
                Toast.makeText(it.context, "complete all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val chosen = Item(etName.text.toString(), etCost.text.toString().toDouble(), etURL.text.toString())
//            items = mutableListOf()
//            (items as MutableList<Item>).add(chosen)

            items.add(chosen)
            etName.setText(null)
            etCost.setText(null)
            etURL.setText(null)

            val adapter = ItemAdapter(items)

            rv.adapter = adapter
            rv.layoutManager = LinearLayoutManager(this)

        }

    }
}