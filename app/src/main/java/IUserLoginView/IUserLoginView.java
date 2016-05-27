package IUserLoginView;

import com.example.llw.demo_mvp.User;

/**
 * Created by llw on 2016/5/26.
 */
public interface IUserLoginView {
    //改接口是用于view和presenter之间交互的接口

    /*login说明了要有用户名、密码，那么对应两个方法来获取用户名和密码：*/
    String getUserName();

    String getPassword();

    /*清除用户名，密码*/
    void clearUserName();

    void clearPassword();

    /*再者login是个耗时操作，我们需要给用户一个友好的提示，一般就是操作ProgressBar，所以再两个：*/
    void showLoading();

    void hideLoading();

    /*login当然存在登录成功与失败的处理，我们主要看成功我们是跳转Activity，而失败可能是去给个提醒：*/
    void toMainActivity(User user);

    void showFailedError();

}
