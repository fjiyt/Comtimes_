package com.comtimes.android.comtimes.src.register;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.comtimes.android.comtimes.R;
import com.comtimes.android.comtimes.src.login.LoginActivity;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    ImageView mBackIv;
    EditText mIdEt, mPwEt, mPwCheckEt, mNameEt, mEmailEt;
    TextView mIdErrorTv, mPwErrorTv, mEmailErrorTv;
    ImageButton mRegisterIbtn;
    InputMethodManager imm;
    boolean idValidation = true;
    boolean pwValidation = true;
    boolean pwCheckValidation = true;
    boolean emailValidation=true;
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();
    }

    protected InputFilter filter=new InputFilter() {
        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            Pattern ps= Pattern.compile("^[a-zA-Z0-9]+$");
            if(!ps.matcher(source).matches())
                idValidation=false;
            else
                idValidation=true;
            return null;
        }
    };

    void initViews() {

        mBackIv = findViewById(R.id.reg_back_iv);

        mIdEt = findViewById(R.id.reg_id_et);
        mIdEt.setFilters(new InputFilter[]{filter});

        mPwEt = findViewById(R.id.reg_pw_et);
        mPwEt.setFilters(new InputFilter[]{filter});


        mPwCheckEt = findViewById(R.id.reg_pw_check_et);
        mPwCheckEt.setFilters(new InputFilter[]{filter});

        mNameEt = findViewById(R.id.reg_name_et);

        mEmailEt = findViewById(R.id.reg_email_et);

        mIdErrorTv=findViewById(R.id.reg_id_error_tv);
        mPwErrorTv=findViewById(R.id.reg_pw_error_tv);
        mEmailErrorTv=findViewById(R.id.reg_email_error_tv);

        mRegisterIbtn = findViewById(R.id.reg_register_Ibtn);

        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        

        mRegisterIbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!idValidation){
                    mIdEt.setBackground(getDrawable(R.drawable.login_et_red_border));
                    mIdErrorTv.setVisibility(View.VISIBLE);
                    mIdErrorTv.setText("지원하지 않는 아이디 형식입니다.");
                }
                else {
                    mIdEt.setBackground(getDrawable(R.drawable.login_et_border));
                    mIdErrorTv.setVisibility(View.GONE);
                }

                if(!Pattern.matches("^[a-zA-Z0-9@!.#$%^&*_~()]*$", mPwEt.getText().toString())){
                    mPwEt.setBackground(getDrawable(R.drawable.login_et_red_border));
                    mPwCheckEt.setBackground(getDrawable(R.drawable.login_et_red_border));

                    mPwErrorTv.setVisibility(View.VISIBLE);
                    mPwErrorTv.setText("지원하지 않는 비밀번호 형식입니다.");

                    mPwEt.setBackground(getDrawable(R.drawable.login_et_red_border));
                    mPwCheckEt.setBackground(getDrawable(R.drawable.login_et_red_border));

                    mPwErrorTv.setVisibility(View.VISIBLE);
                    mPwErrorTv.setText("지원하지 않는 비밀번호 형식입니다.");
                }
                else {
                    if (!mPwEt.getText().toString().equals(mPwCheckEt.getText().toString())) {
                        mPwEt.setBackground(getDrawable(R.drawable.login_et_red_border));
                        mPwCheckEt.setBackground(getDrawable(R.drawable.login_et_red_border));

                        mPwErrorTv.setVisibility(View.VISIBLE);
                        mPwErrorTv.setText("비밀번호가 일치하지 않습니다.");
                    }
                    else {
                        mPwEt.setBackground(getDrawable(R.drawable.login_et_border));
                        mPwCheckEt.setBackground(getDrawable(R.drawable.login_et_border));
                        mPwErrorTv.setVisibility(View.GONE);
                    }
                }
                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(mEmailEt.getText()).matches()) {
                    mEmailEt.setBackground(getDrawable(R.drawable.login_et_red_border));
                    mEmailErrorTv.setVisibility(View.VISIBLE);
                    mEmailErrorTv.setText("지원하지 않는 이메일 형식입니다.");
                }
                else{
                    mEmailEt.setBackground(getDrawable(R.drawable.login_et_border));
                    mEmailErrorTv.setVisibility(View.GONE);
                }
//                    String id =  mIdEt.getText().toString();
//                    String pw=mPwEt.getText().toString();
//                    Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
//                    intent.putExtra("id", id);
//                    intent.putExtra("pw", pw);
//                    startActivity(intent);
//                    finish();
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
