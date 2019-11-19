package com.comtimes.android.comtimes.src.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.comtimes.android.comtimes.R;
import com.comtimes.android.comtimes.src.BaseActivity;
import com.comtimes.android.comtimes.src.main.MainActivity;


public class LoginActivity extends BaseActivity {
    ImageView ivBack, ivLogin;
    EditText etId, etPw;
    TextView tvFindId, tvFindPw, tvResiter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("id", etId.getText().toString());

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initViews() {
        ivBack = findViewById(R.id.login_back_btn);
        ivLogin = findViewById(R.id.login_back_btn);

        etId = findViewById(R.id.login_id_et);
        etPw = findViewById(R.id.login_pw_et);


        tvFindId = findViewById(R.id.login_find_id_tv);
        tvFindPw = findViewById(R.id.login_find_pw_tv);

        tvResiter = findViewById(R.id.login_register_tv);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
