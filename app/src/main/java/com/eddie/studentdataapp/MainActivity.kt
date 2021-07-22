package com.eddie.studentdataapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.eddie.studentdataapp.databinding.ActivityMainBinding
import com.eddie.studentdataapp.ui.ItemAdapter
import com.eddie.studentdataapp.ui.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addStudentButton.setOnClickListener {
            val intent = Intent(this, AddStudentActivity::class.java)
            startActivity(intent)
        }
        itemAdapter = ItemAdapter(listOf())
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.itemRv.apply {
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)


        }
        
        viewModel.run {
            getItems()
            itemsLiveData.observe(this@MainActivity, {items ->
                itemAdapter.items = items
                itemAdapter.notifyDataSetChanged()
            })
        }


        }

}