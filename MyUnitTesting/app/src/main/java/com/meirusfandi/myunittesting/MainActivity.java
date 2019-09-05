package com.meirusfandi.myunittesting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private MainViewModel mainViewModel;
    private EditText width, length, height;
    TextView result;
    Button save, circumference, surfacearea, volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new MainViewModel(new CuboidModel());

        width = findViewById(R.id.edit_width);
        length = findViewById(R.id.edit_length);
        height = findViewById(R.id.edit_height);
        result = findViewById(R.id.tv_result);
        save = findViewById(R.id.btn_save);
        circumference = findViewById(R.id.calculate_circumference);
        surfacearea = findViewById(R.id.calculate_surface_area);
        volume = findViewById(R.id.calculate_volume);

        save.setOnClickListener(this);
        circumference.setOnClickListener(this);
        surfacearea.setOnClickListener(this);
        volume.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String l = length.getText().toString().trim();
        String w = width.getText().toString().trim();
        String h = height.getText().toString().trim();

        if (TextUtils.isEmpty(l)) {
            length.setError("Field cannot empty");
        } else if (TextUtils.isEmpty(w)) {
            length.setError("Field cannot empty");
        } else if (TextUtils.isEmpty(h)) {
            length.setError("Field cannot empty");
        } else {
            double v_l = Double.parseDouble(l);
            double v_h = Double.parseDouble(h);
            double v_w = Double.parseDouble(w);

            if (view.getId() == R.id.btn_save) {
                mainViewModel.save(v_l, v_w, v_h);
                visible();
            } else if (view.getId() == R.id.calculate_circumference) {
                result.setText(String.valueOf(mainViewModel.getCircumference()));
                gone();
            } else if (view.getId() == R.id.calculate_surface_area) {
                result.setText(String.valueOf(mainViewModel.getSurfaceArea()));
                gone();
            } else if (view.getId() == R.id.calculate_volume) {
                result.setText(String.valueOf(mainViewModel.getVolume()));
                gone();
            }
        }
    }

    void visible() {
        save.setVisibility(View.GONE);
        circumference.setVisibility(View.VISIBLE);
        volume.setVisibility(View.VISIBLE);
        surfacearea.setVisibility(View.VISIBLE);
    }

    void gone() {
        save.setVisibility(View.VISIBLE);
        circumference.setVisibility(View.GONE);
        volume.setVisibility(View.GONE);
        surfacearea.setVisibility(View.GONE);
    }
}
