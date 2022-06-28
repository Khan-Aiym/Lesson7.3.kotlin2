package com.geektech.lesson73kotlin2

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.geektech.lesson73kotlin2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var adapter = AnimalAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycler()
        loadAdapter()
        initListener()
    }

    private fun initListener() {
        adapter.onLongClick = {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Удалить объект?")
            dialog.setMessage("Вы действительно хотитие удалить данный объект?")
            dialog.setPositiveButton("Да") { _, _ ->
                Toast.makeText(
                    this,
                    "Удален объект под названием: $it" + " "  + adapter.animal[it],
                    Toast.LENGTH_SHORT
                ).show()
                adapter.remove(it)
                binding.recyclerView.adapter = adapter
            }
            dialog.setNegativeButton("Нет") { dialogCancel, _ -> dialogCancel.cancel() }
            dialog.show()
        }
    }

    private fun initRecycler() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun loadAdapter() {
        adapter.addAnimal("Dog")
        adapter.addAnimal("Snake")
        adapter.addAnimal("Horse")
        adapter.addAnimal("Fox")
        adapter.addAnimal("Bars")
        adapter.addAnimal("Mouse")
        adapter.addAnimal("Fish")
        adapter.addAnimal("Cow")
        adapter.addAnimal("Cat")
        adapter.addAnimal("Lion")
    }
}