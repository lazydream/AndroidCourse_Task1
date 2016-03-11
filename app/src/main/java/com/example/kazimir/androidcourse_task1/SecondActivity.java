package com.example.kazimir.androidcourse_task1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    public static final String RESPONSE_KEY = "backIntentValue";

    TextView secondActivityTextView;
    EditText secondActivityEditText;
    Button secondActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        secondActivityTextView = (TextView) findViewById(R.id.secondActivityTextView);
        secondActivityEditText = (EditText) findViewById(R.id.secondActivityEditText);
        secondActivityButton = (Button) findViewById(R.id.secondActivityButton);

        String messageFromFirstActivity = getIntent().getExtras().getString(MainActivity.PUT_EXTRA_KEY);
        secondActivityTextView.setText(messageFromFirstActivity);

        secondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent();
                if ((secondActivityEditText.getText().toString().equals("")) | (secondActivityEditText.getText().equals(null))) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Enter some text into EditText field!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    backIntent.putExtra(RESPONSE_KEY, secondActivityEditText.getText().toString());
                    setResult(RESULT_OK, backIntent);
                    finish();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent backIntent = new Intent();
        if ((secondActivityEditText.getText().toString() != "") | (secondActivityEditText.getText() != null)) {
            backIntent.putExtra(RESPONSE_KEY, secondActivityEditText.getText().toString());
            setResult(RESULT_OK, backIntent);
            super.onBackPressed();
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(), "Enter some text into EditText field!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
