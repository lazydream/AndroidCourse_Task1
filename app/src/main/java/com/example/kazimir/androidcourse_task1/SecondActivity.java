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

    TextView textViewSecondActivity;
    EditText editTextForWriteMessage;
    Button sendMessageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewSecondActivity = (TextView) findViewById(R.id.secondActivityTextView);
        editTextForWriteMessage = (EditText) findViewById(R.id.secondActivityEditText);
        sendMessageButton = (Button) findViewById(R.id.secondActivityButton);

        String messageFromFirstActivity = getIntent().getExtras().getString(MainActivity.PUT_EXTRA_KEY);
        textViewSecondActivity.setText(messageFromFirstActivity);
    }

    @Override
    public void onBackPressed() {
        if ((editTextForWriteMessage.getText().toString() != "") & (editTextForWriteMessage.getText() != null)) {
            Intent backIntent = new Intent();
            backIntent.putExtra(RESPONSE_KEY, editTextForWriteMessage.getText().toString());
            setResult(MainActivity.REQUEST_ID, backIntent);
            super.onBackPressed();
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(), "Enter some text into EditText field!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
