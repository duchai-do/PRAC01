package com.example.prac01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    EditText edtName, edtGPA;
    Button btnSubmit;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtName = findViewById(R.id.edtName);
        edtGPA = findViewById(R.id.edtGPA);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {
            intent = new Intent(MainActivity2.this, MainActivity.class);
            String name = edtName.getText().toString();
            String GPA = edtGPA.getText().toString();
            intent.putExtra("name", name);
            intent.putExtra("GPA", GPA);
            setResult(RESULT_OK, intent);
            finish();
        });

    }
}