package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";

    private Button mTrueButton,mFalseButton,mNextButton,mCheatButton;
    private TextView mQuestion;

    GeoModel [] quest=new GeoModel []{
            new GeoModel(R.string.question_oceans, true),

            new GeoModel(R.string.question_africa,
                    false),
            new GeoModel(R.string.question_americas,
                    true) };
    private int mCurrentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        if (savedInstanceState != null)      mCurrentIndex =savedInstanceState.getInt(KEY_INDEX, 0);

        mTrueButton = (Button)findViewById(R.id.true_button);
        mFalseButton = (Button)findViewById(R.id.false_button);
        mQuestion=(TextView)findViewById(R.id.question_text);
        mNextButton=(Button)findViewById(R.id.next_button);
        mCheatButton=(Button)findViewById(R.id.cheat_button);


        mQuestion.setText(quest[mCurrentIndex].getTextResId());

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              check(true);
            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(false);
            }
        });
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=(1 +mCurrentIndex)% quest.length;;
                mQuestion.setText(quest[mCurrentIndex].getTextResId());
            }
        });
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean answerIsTrue = quest[mCurrentIndex].isAnswer();
                Intent intent = CheatActivity.newIntent(MainActivity.this, answerIsTrue);
                startActivity(intent);
            }
        });

    }
    public void check(boolean a){
        Toast.makeText(this, (quest[mCurrentIndex].isAnswer() && a)+"", Toast.LENGTH_LONG).show();;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_INDEX,mCurrentIndex);

    }
}
