package servletContext;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * ServletContext为所有Servlet共享，因此是单例的(this.getServletContext，本质是servletConfig中获取的）
 */
@WebServlet("/servlet3")
public class Servlet01_Context extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-------------------------------------------------------------");
        ServletContext servletContext = this.getServletContext();
        ServletContext servletContext1 = req.getServletContext();
        System.out.println(servletContext1 == servletContext);
        System.out.println(servletContext.getInitParameter("encoding"));
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String pname = initParameterNames.nextElement();
            System.out.println(servletContext.getInitParameter(pname));
        }
    }
}
