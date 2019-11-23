package com.comtimes.android.comtimes.src.edit;

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
import com.comtimes.android.comtimes.src.register.RegisterActivity;

public class EditActivity extends AppCompatActivity {
    ImageView mBackIv;
    EditText mIdEt, mPwEt, mPwCheckEt, mEmailEt;
    ImageButton mSubmitIbtn;
    InputMethodManager imm;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_useredit);
        initViews();
    }

    void initViews(){
        mBackIv=findViewById(R.id.edit_back_iv);
        mIdEt=findViewById(R.id.edit_name_et);
        mPwEt=findViewById(R.id.edit_pw_et);
        mPwCheckEt=findViewById(R.id.edit_pw_check_et);
        mEmailEt=findViewById(R.id.edit_email_et);
        mSubmitIbtn=findViewById(R.id.edit_submit_iv);
        imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

        mSubmitIbtn.setOnClickListener(myClickListener);

        mBackIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id =  mIdEt.getText().toString();
                Intent intent=new Intent(EditActivity.this, LoginActivity.class);
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
                case R.id.edit_submit_iv:
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
