package com.example.buttonclickapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    MediaPlayer mp;
    private EditText userInput;
    private static final String TAG = "MainActivity";
    private TextView textView;
    private final String TEXT_CONTENTS = "TextContents";

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        String savedString = savedInstanceState.getString(TEXT_CONTENTS);
        textView.setText(savedString);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        outState.putString(TEXT_CONTENTS, textView.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(this,R.raw.sound3);

        userInput = (EditText) findViewById(R.id.editTextTextPersonName);
        Button button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("");//<----------------------------------------SET A BLANK TEXT VIEW
        textView.setMovementMethod(new ScrollingMovementMethod());

        View.OnClickListener ourOnClickListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                //Editable e = userInput.getText(); <-----
                //String result = e.toString();<----------
                String result = userInput.getText().toString(); // THIS  ONE LINE IS THE SAME AS BOTH  40 AND 41
                result = result + "\n";
                textView.append(result);
                userInput.getText().clear();//<---------------YAY FOR ME!!!! :~)
            }
        };
        button.setOnClickListener(ourOnClickListener);
    }

    public void startMusic(View view)
    {
        {

            mp.start();
        }
    }

    public void stopMusic(View view)
    {

        {
            mp.stop();
            mp=MediaPlayer.create(this, R.raw.sound3);
        }

    }
}