package com.comtimes.android.comtimes.src.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.comtimes.android.comtimes.R;
import com.comtimes.android.comtimes.src.BaseActivity;
import com.comtimes.android.comtimes.src.register.RegisterActivity;

import java.util.regex.Pattern;


public class LoginActivity extends BaseActivity {
    private ImageButton mBackIbtn, mLoginIbtn;
    private EditText mIdEt, mPwEt;
    private TextView mFindIdTv, mFindPwTv, mRegisterTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mRegisterTv = findViewById(R.id.login_register_tv);
        mRegisterTv.setOnClickListener(this);
        initViews();

      }

    @Override
    public void initViews() {
        mBackIbtn = findViewById(R.id.login_back_ibtn);
        mIdEt = findViewById(R.id.login_id_et);
//        mIdEt.setFilters(new InputFilter[]{filter});

        mPwEt = findViewById(R.id.login_pw_et);
        mLoginIbtn = findViewById(R.id.login_login_ibtn);
        mFindIdTv = findViewById(R.id.login_find_id_tv);
        mFindPwTv = findViewById(R.id.login_find_pw_tv);
        mRegisterTv = findViewById(R.id.login_register_tv);



        mBackIbtn.setOnClickListener(this);
        mLoginIbtn.setOnClickListener(this);
        mRegisterTv.setOnClickListener(this);

        Intent intent=getIntent();
        String id = intent.getStringExtra("id");
        String pw  =  intent.getStringExtra("pw");
        mIdEt.setText(id);
        mPwEt.setText(pw);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.login_login_ibtn:
                if(!Pattern.matches("^[a-zA-Z0-9]*$", mIdEt.getText().toString())){
                    mIdEt.setBackground(getDrawable(R.drawable.login_et_red_border));
                }else {
                    mIdEt.setBackground(getDrawable(R.drawable.login_et_border));
                }
                if(!Pattern.matches("^[a-zA-Z0-9@!.#$%^&*_~()]*$", mPwEt.getText().toString())){
                    mPwEt.setBackground(getDrawable(R.drawable.login_et_red_border));
                }else {
                    mPwEt.setBackground(getDrawable(R.drawable.login_et_border));
                }
                break;

            case R.id.login_back_ibtn:
                finish();
                break;
            case R.id.login_register_tv:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                finish();

        }
    }
}
