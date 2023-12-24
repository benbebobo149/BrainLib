package com.example.demo.dto;

import com.example.demo.model.Activity;

public class ActivityResult {
    private Activity activity;
    private int resultCode;

    // getter 和 setter 方法

    public Activity getActivity() {
        return activity;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }
}  