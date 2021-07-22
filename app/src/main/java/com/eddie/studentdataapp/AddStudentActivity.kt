package com.eddie.studentdataapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.eddie.studentdataapp.databinding.ActivityAddStudentBinding
import com.eddie.studentdataapp.models.Student
import com.eddie.studentdataapp.ui.MainViewModel


class AddStudentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddStudentBinding
    private lateinit var viewModel: MainViewModel

      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.saveButton.setOnClickListener {
            addStudent()
        }


    }

    private fun addStudent(){
        val className = binding.classInput.text.toString()
        val name = binding.nameInput.text.toString()
        val seat = binding.seatNumberInput.text.toString()


        if (className.isNotEmpty() && name.isNotEmpty() && seat.isNotEmpty()){
            val newStudent = Student(className, name, seat)

            viewModel.addStudent(newStudent)

            Toast.makeText(this, "Student Added Successfully", Toast.LENGTH_LONG).show()
        } else{
            Toast.makeText(this, "Please Complete all Fields", Toast.LENGTH_LONG).show()
        }
    }
}
