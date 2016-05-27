package onloginlisenter;

import com.example.llw.demo_mvp.User;

/**
 * Created by llw on 2016/5/26.
 */
public interface OnLoginListener {
    void loginSuccess(User user);

    void loginFailed();
}
