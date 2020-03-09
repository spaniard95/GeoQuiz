package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private Button mTrueButton,mFalseButton,mNextButton;
private TextView mQuestion;
    GeoModel [] quest=new GeoModel []{
            new GeoModel(R.string.question_oceans, true),

            new GeoModel(R.string.question_africa,
                    false),
            new GeoModel(R.string.question_americas,
                    true) };
    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mTrueButton = (Button)findViewById(R.id.true_button);
        mFalseButton = (Button)findViewById(R.id.false_button);
        mQuestion=(TextView)findViewById(R.id.question_text);
        mNextButton=(Button)findViewById(R.id.next_button);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              // Does nothing yet, but soon!
            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Does nothing yet, but soon!
            }
        });
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=(1 +mCurrentIndex)% quest.length;;
                mQuestion.setText(mCurrentIndex);
            }
        });

    }
    public void reply(){
        //toast
    }
}
