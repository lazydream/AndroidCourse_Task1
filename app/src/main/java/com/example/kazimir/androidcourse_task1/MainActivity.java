package com.example.kazimir.androidcourse_task1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public  static  final String PUT_EXTRA_KEY = "sharedValue";
    public static final int REQUEST_ID = 1;

    TextView textViewFirstActivity;
    EditText editTextForWriteMessage;
    Button sendMessageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewFirstActivity = (TextView) findViewById(R.id.firstActivityTextView);
        editTextForWriteMessage = (EditText) findViewById(R.id.firstActivityEditText);
        sendMessageButton = (Button) findViewById(R.id.firstActivityButton);


        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((editTextForWriteMessage.getText().toString() != "") & (editTextForWriteMessage.getText() != null)) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra(PUT_EXTRA_KEY, editTextForWriteMessage.getText().toString());
                    startActivityForResult(intent, REQUEST_ID);
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Enter some text into EditText field!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent backIntent) {
        if (requestCode == REQUEST_ID) {
            String result = getIntent().getExtras().getString(SecondActivity.RESPONSE_KEY);
            textViewFirstActivity.setText(result);
        }
    }
}
