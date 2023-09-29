package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //status-line
        response.setStatus(HttpServletResponse.SC_OK);    //http기본응답 코드를 넣어줄수 있다,200적는거보다 이렇게 sc_ok가 좋다
        //response-headers
        response.setHeader("Content-type", "text/plain");
        response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); //캐시 완전 무효화
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "hello");
        //헤더의 편의 메서드
        content(response);
        cookie(response);
        redirect(response);

        //messageBody
        PrintWriter writer = response.getWriter();
        writer.print("ok");
    }

    private void content(HttpServletResponse response) {
        response.setContentType("text/plain"); //        response.setHeader("Content-type","text/plain");을 대신할 수 있음
        response.setCharacterEncoding("utf-8");
        //response.setContentLength(2) //생략시 자동생성
    }

    private void cookie(HttpServletResponse response) {
       /* Set-Cookie:myCookie = good;Max - Age = 600;*/ //키 벨류 600초동안 유효하다
        Cookie cookie = new Cookie("myCookie", "good"); //쿠키란 객체 만들고
        cookie.setMaxAge(600);
        response.addCookie(cookie); //response.setHeader("Set-Cookie","myCooke=good;Max-age=600"

    }
    private void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/basic/hello-form.html"); //redirect작용을 하는거다 statusnum은 302
    }
}
