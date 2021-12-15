package com.example.servletjsp.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/local")
public class LocalTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int number= 0;
        String str= req.getParameter("msg");
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("<html><head><title>MultiThread Test</title></head>");
        out.println("<body><h2>처리 결과 (지역변수)<h2/>");
        while(number++ < 10){
            out.print(str + " : " + number + "<br>");
            out.flush();
            System.out.println(str + " : " + number);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        out.println("<h2>Done " + str + " !!</h2>");
        out.println("</body></html>");
        out.close();

    }
}
