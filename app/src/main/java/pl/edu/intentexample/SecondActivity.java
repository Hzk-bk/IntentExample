package pl.edu.intentexample;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textMessage = findViewById(R.id.textMessage);
        Button buttonBack = findViewById(R.id.buttonBack);

        // Retrieve the value sent by MainActivity
        Intent intent = getIntent();
        String message = intent.getStringExtra("MESSAGE");
        if (message != null) {
            textMessage.setText(message);
        }

        // Return to the main activity
        buttonBack.setOnClickListener(v -> finish());
    }
}