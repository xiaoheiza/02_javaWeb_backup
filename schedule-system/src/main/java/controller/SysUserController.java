package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pojo.SysUser;
import service.SysUserService;
import service.impl.SysUserServiceImpl;
import util.MD5Util;

import java.io.IOException;


@WebServlet("/user/*")
public class SysUserController extends BaseController {

    private SysUserService userService = new SysUserServiceImpl();

    /**
     * 接受用户注册请求的业务处理方法（接口：不是java中的interface）
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、接收客户端提交的参数
        String username = req.getParameter("username");
        String usePwd = req.getParameter("userPwd");
        // 2、调用服务层的方法，完成注册功能
            // 将参数放入一个SYSUser对象中，在调用regist方法时传入
        SysUser sysUser = new SysUser(null, username, usePwd);
        int rows = userService.regist(sysUser);
        // 3、根据注册结果，完成页面跳转
        if (rows > 0) {
            resp.sendRedirect("/registSuccess.html");
        } else {
            resp.sendRedirect("/registFail.html");
        }
    }

    /**
     * 接收用户登录请求，完成登陆的业务接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、接收用户名和密码
        String username = req.getParameter("username");
        String usePwd = req.getParameter("userPwd");
        // 2、调用服务层方法，根据用户名查询信息
        SysUser loginUser = userService.findByUsername(username);
        if (null == loginUser) {
            resp.sendRedirect("/loginUsernameError.html");
        } else if (!MD5Util.encrypt(usePwd).equals(loginUser.getUserPwd())) {
            // 3、判断密码是否匹配
            // 密码有误提示页
            resp.sendRedirect("/loginUserPwdError.html");
        } else {
            // 登录成功之后将登陆的用户信息放入session
            HttpSession session = req.getSession();
            session.setAttribute("sysUser", loginUser);

            // 4、跳转页面
            resp.sendRedirect("/showSchedule.html");
        }
    }
}
