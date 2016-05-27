package IUserbize.com;

import onloginlisenter.OnLoginListener;

/**
 * Created by llw on 2016/5/26.
 */
public interface IUserBize {
    public void login(String username, String password, OnLoginListener loginListener);
}
