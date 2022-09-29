package com.example.crudexampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextStudentFirstName;
    EditText editTextStudentEmail;
    Button button;
    Button studentsViewButton;
    TextView countView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StudentController studentController = new StudentController(this);

        editTextStudentEmail = findViewById(R.id.editTextStudentEmail);
        editTextStudentFirstName = findViewById(R.id.editTextStudentFirstName);
        button = findViewById(R.id.submitButton);
        studentsViewButton = findViewById(R.id.showStudents);
        countView = findViewById(R.id.textViewCount);
        countView.setText(String.valueOf(studentController.count()));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String studentName = editTextStudentFirstName.getText().toString();
                String studentEmail = editTextStudentEmail.getText().toString();
                if (studentName.equals("")) {
                    Toast.makeText(MainActivity.this, "Please write your name", Toast.LENGTH_SHORT).show();
                    return ;
                }
                boolean isSuccessful = studentController.create(new Student(studentName, studentEmail));
                if (isSuccessful) {
                    Toast.makeText(MainActivity.this, "Successfully Created!", Toast.LENGTH_SHORT).show();
                    countView.setText(String.valueOf(studentController.count()));
                }
                else {
                    Toast.makeText(MainActivity.this, "Jhamela Hoise!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        studentsViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StudentsViewActivity.class);
                startActivity(intent);
            }
        });
    }
}