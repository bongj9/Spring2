package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     /*   System.out.println("[전체 파라미터 조회] - start");
        request.getHeaderNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + ":" + request.getParameter(paramName))); //이렇게 하는 이유는 paramnames는 이름이고 값을 뽑아 내기위해서는 request.getParameter(value)이런식으로 해야한다
        //localhost:8080/request-param?uesrname=hello&age=20이런식으로 만들기 위해서 paraName은 위의 username이고 그뒤의값은 getParameter등등이
        *//*Enumeration<String> parameterNames = request.getParameterNames();*//*
        System.out.println("[전체 파라미터 조회] - end");*/
        System.out.println("[전체 파라미터 조회] -start");
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName +
                        "=" + request.getParameter(paramName))); System.out.println("[전체 파라미터 조회] - end");
        System.out.println();
        System.out.println("[단일 파라미터 조회]");
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println(); //값이 중복되어 넘어갈 수 있다 내부 우선순위에서 잡히는 얘가 먼저 나온다

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String[] usernames = request.getParameterValues("username");//배열로 나온다
        for (String name : usernames) { //iter에 대해 알아보기!
            System.out.println("username= " +
                    name);
        }
        response.getWriter().write("ok");
/*        System.out.println("[단일 파라미터 조회]");
        String username = request.getParameter("username"); System.out.println("request.getParameter(username) = " + username);
        String age = request.getParameter("age");
        System.out.println("request.getParameter(age) = " + age);
        System.out.println();
        System.out.println("[이름이 같은 복수 파라미터 조회]"); System.out.println("request.getParameterValues(username)"); String[] usernames = request.getParameterValues("username"); for (String name : usernames) {
            System.out.println("username=" + name);*/
/*        }
        response.getWriter().write("ok");*/
    }



}

