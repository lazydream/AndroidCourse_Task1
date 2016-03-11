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

    TextView firstActivityTextView;
    EditText firstActivityEditText;
    Button firstActivityButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstActivityTextView = (TextView) findViewById(R.id.firstActivityTextView);
        firstActivityEditText = (EditText) findViewById(R.id.firstActivityEditText);
        firstActivityButton = (Button) findViewById(R.id.firstActivityButton);


        firstActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((firstActivityEditText.getText().toString().equals("")) | (firstActivityEditText.getText().equals(null))) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Enter some text into EditText field!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra(PUT_EXTRA_KEY, firstActivityEditText.getText().toString());
                    startActivityForResult(intent, REQUEST_ID);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent backIntent) {
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_ID) {
                String result = backIntent.getExtras().getString(SecondActivity.RESPONSE_KEY);
                firstActivityTextView.setText(result);
            }
        }
    }
}
