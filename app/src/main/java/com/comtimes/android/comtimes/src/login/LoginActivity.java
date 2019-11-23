package com.comtimes.android.comtimes.src.login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.comtimes.android.comtimes.R;
import com.comtimes.android.comtimes.src.BaseActivity;


public class LoginActivity extends BaseActivity {
    private ImageButton mBackIbtn, mLoginIbtn;
    private EditText mIdEt, mPwEt;
    private TextView mFindIdTv, mFindPwTv, mRegisterTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
      }

    @Override
    public void initViews() {
        mBackIbtn = findViewById(R.id.login_back_ibtn);
        mIdEt = findViewById(R.id.login_id_et);
        mPwEt = findViewById(R.id.login_pw_et);
        mLoginIbtn = findViewById(R.id.login_login_ibtn);
        mFindIdTv = findViewById(R.id.login_find_id_tv);
        mFindPwTv = findViewById(R.id.login_find_pw_tv);
        mRegisterTv = findViewById(R.id.login_register_tv);

        mBackIbtn.setOnClickListener(this);
        mLoginIbtn.setOnClickListener(this);
        mRegisterTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_login_ibtn:
                break;
            case R.id.login_back_ibtn:
                finish();
                break;
        }
    }


}
