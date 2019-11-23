package com.comtimes.android.comtimes.src.register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.comtimes.android.comtimes.R;
import com.comtimes.android.comtimes.src.login.LoginActivity;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    ImageView mBackIv;
    EditText mIdEt, mPwEt, mPwCheckEt, mNameEt, mEmailEt;
    ImageButton mRegisterIbtn;
    InputMethodManager imm;
    boolean Validation = true;
    boolean Validation2 = true;

    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();
    }

    private void fillEt(EditText editText) {
        if (editText.getText().toString().matches(" "))
            Validation2 = false;
        else
            Validation2 = true;
    }


    protected InputFilter filter=new InputFilter() {
        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            Pattern ps= Pattern.compile("^[a-zA-Z0-9]+$");
            if(!ps.matcher(source).matches())
                Validation=false;
            else
                Validation=true;
            return null;
        }
    };


    void initViews() {

        mBackIv = findViewById(R.id.reg_back_iv);

        mIdEt = findViewById(R.id.reg_id_et);
        fillEt(mIdEt);
        mIdEt.setFilters(new InputFilter[]{filter});

        mPwEt = findViewById(R.id.reg_pw_et);
        fillEt(mPwEt);
        mPwEt.setFilters(new InputFilter[]{filter});


        mPwCheckEt = findViewById(R.id.reg_pw_check_et);
        fillEt(mPwCheckEt);
        mPwCheckEt.setFilters(new InputFilter[]{filter});

        mNameEt = findViewById(R.id.reg_name_et);
        fillEt(mNameEt);

        mEmailEt = findViewById(R.id.reg_email_et);
        fillEt(mEmailEt);

        mRegisterIbtn = findViewById(R.id.reg_register_Ibtn);

        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        

        mRegisterIbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Validation){
                    Toast.makeText(RegisterActivity.this,"형식을 지켜주세요.",Toast.LENGTH_SHORT).show();
                }
                else if(!Validation2){
                    Toast.makeText(RegisterActivity.this,"입력하지 않은 값이 있습니다.", Toast.LENGTH_SHORT).show();
                }
                else if(!mPwEt.getText().toString().equals(mPwCheckEt.getText().toString())){
                    Toast.makeText(RegisterActivity.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    String id =  mIdEt.getText().toString();
                    String pw=mPwEt.getText().toString();
                    Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
                    intent.putExtra("id", id);
                    intent.putExtra("pw", pw);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }
//    private void hideKeyboard(){
//        imm.hideSoftInputFromWindow(mIdEt.getWindowToken(),0);
//        imm.hideSoftInputFromWindow(mPwEt.getWindowToken(), 0);
//        imm.hideSoftInputFromWindow(mPwCheckEt.getWindowToken(),0);
//        imm.hideSoftInputFromWindow(mNameEt.getWindowToken(), 0);
//        imm.hideSoftInputFromWindow(mEmailEt.getWindowToken(),0);
//    }
}
