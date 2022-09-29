package com.example.crudexampleapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentViewAdapter extends RecyclerView.Adapter<StudentViewHolder> {
    private Context context;
    private List<Student> students;

    public StudentViewAdapter(Context context, List<Student> students) {
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.student_item_layout, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = students.get(position);
        holder.studentIdTextView.setText(String.valueOf(student.getId()));
        holder.studentNameTextView.setText(student.getName());
        holder.studentEmailTextView.setText(student.getEmail());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }
}

class StudentViewHolder extends RecyclerView.ViewHolder {

    TextView studentIdTextView;
    TextView studentNameTextView;
    TextView studentEmailTextView;

    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        studentIdTextView = itemView.findViewById(R.id.studentId);
        studentNameTextView = itemView.findViewById(R.id.studentName);
        studentEmailTextView = itemView.findViewById(R.id.studentEmail);
    }
}