package com.comtimes.android.comtimes.src.register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.comtimes.android.comtimes.R;
import com.comtimes.android.comtimes.src.login.LoginActivity;

public class RegisterActivity extends AppCompatActivity {
    RelativeLayout rl;
    ImageView mBackIv;
    EditText mIdEt, mPwEt, mPwCheckEt, mEmailEt;
    ImageButton mRegisterIbtn;
    InputMethodManager imm;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();
    }

    void initViews(){
        rl=findViewById(R.id.reg_rl);
        mBackIv=findViewById(R.id.reg_back_iv);
        mIdEt=findViewById(R.id.reg_id_et);
        mPwEt=findViewById(R.id.reg_pw_et);
        mPwCheckEt=findViewById(R.id.reg_pw_check_et);
        mEmailEt=findViewById(R.id.reg_email_et);
        mRegisterIbtn=findViewById(R.id.reg_register_iv);
        imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

        rl.setOnClickListener(myClickListener);
        mRegisterIbtn.setOnClickListener(myClickListener);

        mBackIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id =  mIdEt.getText().toString();
                Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
                finish();
            }
        });
    }
    View.OnClickListener myClickListener=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            hideKeyboard();

            switch(v.getId()){
                case R.id.reg_rl:
                case R.id.reg_register_iv:
                    break;
            }
        }
    };
    private void hideKeyboard(){
        imm.hideSoftInputFromWindow(mIdEt.getWindowToken(),0);
        imm.hideSoftInputFromWindow(mPwEt.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(mPwCheckEt.getWindowToken(),0);
        imm.hideSoftInputFromWindow(mEmailEt.getWindowToken(),0);
    }


}
