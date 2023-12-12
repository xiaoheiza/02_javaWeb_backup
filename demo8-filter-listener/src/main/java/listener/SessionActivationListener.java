package listener;

import jakarta.servlet.http.HttpSessionActivationListener;
import jakarta.servlet.http.HttpSessionEvent;

/**
 * @description:
 * @author：xiaozheng
 * @date: 20
 */
public class SessionActivationListener implements HttpSessionActivationListener {
    /*
    * MyApplicationListener myApplicationListener = new MyApplicationListener();
        session.setAttribute("lis", myApplicationListener);
    * 放入后生效
    * */

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        // session对象即将进行钝化之前执行
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        // session对象活化后执行
    }
}
