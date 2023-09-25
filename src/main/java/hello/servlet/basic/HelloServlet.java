package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "helloServlet", urlPatterns = "/hello") //hello가 호출이 되면 helloservlet이 보여진다
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType("text/plain");  // 아래 두줄 content타입 헤더에 들어간다
        response.setCharacterEncoding("utf-8"); //문자인코딩은 utf-8로 하는게 좋다
        response.getWriter().write("hello " + username);//http 바디에 들어간다

        //쿼리파라미터
    }
}
