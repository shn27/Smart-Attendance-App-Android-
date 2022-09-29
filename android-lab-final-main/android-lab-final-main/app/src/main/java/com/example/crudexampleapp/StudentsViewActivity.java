package com.example.crudexampleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class StudentsViewActivity extends AppCompatActivity {

    RecyclerView studentsViewRecyclerView;
    StudentViewAdapter adapter;
    List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_view);

        StudentController studentController = new StudentController(this);

        studentsViewRecyclerView = findViewById(R.id.studentsRecyclerView);
        studentList = studentController.getStudents();
        studentsViewRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new StudentViewAdapter(this, studentList);
        studentsViewRecyclerView.setAdapter(adapter);
    }
}