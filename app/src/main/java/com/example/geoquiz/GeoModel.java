package com.example.geoquiz;

public class GeoModel {
    private int mTextResId;
    private boolean mAnswer;

    public GeoModel(int mTextResId,boolean mAnswer) {
        this.mTextResId = mTextResId;
        this.mAnswer=mAnswer;
    }

    public boolean isAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean answer) {
        this.mAnswer = answer;
    }



    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int mTextResId) {
        this.mTextResId = mTextResId;
    }
}
