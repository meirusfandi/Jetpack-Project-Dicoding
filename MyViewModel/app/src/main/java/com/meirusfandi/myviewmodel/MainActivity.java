package com.meirusfandi.myviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    EditText ed_width, ed_length, ed_height;
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        ed_height = findViewById(R.id.edit_height);
        ed_length = findViewById(R.id.edit_length);
        ed_width = findViewById(R.id.edit_width);
        result = findViewById(R.id.tv_result);

        displayResult();

        displayResult();

        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String width = ed_width.getText().toString();
                String height = ed_height.getText().toString();
                String length = ed_length.getText().toString();
                if (width.isEmpty()) {
                    ed_width.setError("Masih kosong");
                } else if (height.isEmpty()) {
                    ed_height.setError("Masih kosong");
                } else if (length.isEmpty()) {
                    ed_length.setError("Masih kosong");
                } else {
                    mainViewModel.calculate(width, height, length);
                    displayResult();
                }
            }
        });
    }

    private void displayResult() {
        result.setText(String.valueOf(mainViewModel.result));
    }


}
