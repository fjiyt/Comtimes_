package com.comtimes.android.comtimes.src.login;

<<<<<<< HEAD
import android.app.Dialog;
=======
>>>>>>> d70722b00aaa4c63b1df89195486b802731024c0
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.comtimes.android.comtimes.R;
import com.comtimes.android.comtimes.src.BaseActivity;
import com.comtimes.android.comtimes.src.register.RegisterActivity;

import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.validation.Validator;


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
                    Toast.makeText(LoginActivity.this,"아이디 형식을 지켜주세요.",Toast.LENGTH_SHORT).show();
                }
                if(!Pattern.matches("^[a-zA-Z0-9@!.#$%^&*_~()]*$", mPwEt.getText().toString())){
                    Toast.makeText(LoginActivity.this,"비밀번호 형식을 지켜주세요.",Toast.LENGTH_SHORT).show();
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
<<<<<<< HEAD
=======

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
>>>>>>> d70722b00aaa4c63b1df89195486b802731024c0
}
