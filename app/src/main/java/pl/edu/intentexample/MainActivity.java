package pl.edu.intentexample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSecond = findViewById(R.id.buttonSecond);
        Button buttonWebsite = findViewById(R.id.buttonWebsite);
        Button buttonLocation = findViewById(R.id.buttonLocation);

        // Explicit Intent: the target class is named directly
        buttonSecond.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("MESSAGE", "Message sent from MainActivity");
            startActivity(intent);
        });

        // Implicit Intent: Android chooses an app that can open the URL
        buttonWebsite.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.android.com");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        // Implicit Intent: open a geographic location in a map application
        buttonLocation.setOnClickListener(v -> {
            Uri geoUri = Uri.parse("geo:50.3217,19.1949");
            Intent intent = new Intent(Intent.ACTION_VIEW, geoUri);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this,
                        "No map application found", Toast.LENGTH_LONG).show();
            }
        });
    }
}