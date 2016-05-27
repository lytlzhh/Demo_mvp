package com.example.llw.demo_mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import IUserLoginView.IUserLoginView;

public class VIEW extends AppCompatActivity implements IUserLoginView, View.OnClickListener {
    private TextView textviewoneShow;
    private EditText editUsername;
    private TextView textviewtwoShow;
    private EditText editPassword;
    private Button btnLogin;
    private Button btnClear;
    private ProgressBar progressbarShow;

    PRESENTER presenter = new PRESENTER(this);

    private void assignViews() {
        textviewoneShow = (TextView) findViewById(R.id.textviewone_show);
        editUsername = (EditText) findViewById(R.id.edit_username);
        textviewtwoShow = (TextView) findViewById(R.id.textviewtwo_show);
        editPassword = (EditText) findViewById(R.id.edit_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnClear = (Button) findViewById(R.id.btn_clear);
        progressbarShow = (ProgressBar) findViewById(R.id.progressbar_show);

        btnLogin.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        assignViews();
    }

    /*login说明了要有用户名、密码，那么对应两个方法来获取用户名和密码：*/
    @Override
    public String getUserName() {
        return editUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return editPassword.getText().toString();
    }

    /*清除用户名，密码*/
    @Override
    public void clearUserName() {
        editUsername.setText("");
    }

    @Override
    public void clearPassword() {
        editPassword.setText("");
    }

    /*再者login是个耗时操作，我们需要给用户一个友好的提示，一般就是操作ProgressBar，所以再两个：*/
    @Override
    public void showLoading() {
        progressbarShow.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressbarShow.setVisibility(View.GONE);
    }

    /*login当然存在登录成功与失败的处理，我们主要看成功我们是跳转Activity，而失败可能是去给个提醒：*/
    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, user.getUsername() +
                " login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                presenter.login();
                break;
            case R.id.btn_clear:
                presenter.clear();
                break;
        }
    }
}
