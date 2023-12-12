package listener;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

/**
 * @description:
 * @author：xiaozheng
 * @date: 20
 */
public class SessionBindingListener implements HttpSessionBindingListener {
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
//        当前监听器实力放入某个session中作为数据绑定
        /*
            SessionBindingListener sb = new SessionBindingListener();
            session.setAttribute("sb1", sb);
            放入后生效
        */
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        // 当前监听器实力从某个session中移除 解绑定
    }
}
