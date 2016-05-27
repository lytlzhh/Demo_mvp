package com.example.llw.demo_mvp;

import IUserLoginView.IUserLoginView;
import onloginlisenter.OnLoginListener;

/**
 * Created by llw on 2016/5/26.
 */
public class PRESENTER {
    private MODEL iUserBize;
    //private IUserLoginView userLoginView;
    private IUserLoginView iUserLoginView;
    //private android.os.Handler mhandler;
    // public Handler mHandler = new Handler();
    public android.os.Handler mhandler = new android.os.Handler();

    public PRESENTER(IUserLoginView userLoginView) {
        this.iUserLoginView = userLoginView;
        this.iUserBize = new MODEL();
    }

    public void login() {
        iUserLoginView.showLoading();
        iUserBize.login(iUserLoginView.getUserName(), iUserLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                //需要在UI线程执行
                mhandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserLoginView.toMainActivity(user);
                        iUserLoginView.hideLoading();
                    }
                });

            }

            @Override
            public void loginFailed() {
                //需要在UI线程执行
                mhandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserLoginView.showFailedError();
                        iUserLoginView.hideLoading();
                    }
                });

            }
        });
    }

    public void clear() {
        iUserLoginView.clearUserName();
        iUserLoginView.clearPassword();
    }

}
