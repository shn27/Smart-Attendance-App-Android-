package com.example.crudexampleapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class StudentController extends DatabaseHelper {

    public StudentController(@Nullable Context context) {
        super(context);
    }

    public boolean create(Student student) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("first_name", student.getName());
        contentValues.put("email", student.getEmail());
        SQLiteDatabase db = this.getWritableDatabase();
        boolean isSuccessful = db.insert("students", null, contentValues) > 0;
        db.close();
        return isSuccessful;
    }

    public int count() {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM students";
        Cursor cursor = db.rawQuery(sql, null);
        int recordCount = cursor.getCount();
        return recordCount;
    }

    @SuppressLint("Range")
    public List<Student> getStudents() {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM students";
        Cursor cursor = db.rawQuery(sql, null);
        List<Student> students = new ArrayList<>();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("first_name"));
            String email = cursor.getString(cursor.getColumnIndex("email"));
            students.add(new Student(id, name, email));
        }
        return students;
    }
}
