package filter;

import model.Account;
import service.LoginService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebFilter(urlPatterns = {"/*"})
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String url = request.getServletPath();


        if( "/index.jsp".equals(url) || "/login".equals(url) ){
            if (request.getMethod().equals("GET") && url.startsWith("/login") && (session.getAttribute("admin") != null || session.getAttribute("user") != null)){
                response.sendRedirect("http://localhost:8080/LoginPage");
            } else {
                session.removeAttribute("login");
                filterChain.doFilter(request, response);
            }
        }

        else {
            session.setAttribute("urlCurrent", url);
            //
            String remember = request.getParameter("remember"); //remember se nhan null khi bo checkbox va khi (page khac login) vao filter
            String mail = request.getParameter("mail");
            String password = request.getParameter("password");
            //
            String updateRemember = "remember tu page khac login";
            if (session.getAttribute("login") != null){
                updateRemember = (String) session.getAttribute("login");
            }
            if ( remember != null){
                session.setAttribute("mail", mail);
                session.setAttribute("password", password);
            }
            if ( remember == null && updateRemember.equals("login")){
                session.removeAttribute("mail");
                session.removeAttribute("password");
            }
            session.removeAttribute("login");
            //
            LoginService loginService = new LoginService();
            Account account = new Account();
            try{
                account = loginService.getRoleAcc(mail, password);
            } catch (Exception e){
                System.out.println("Loi o auth filter" + e);
            }
            //
            String adminRoleSession = (String) session.getAttribute("admin");
            String userRoleSession = (String) session.getAttribute("user");
            //
            switch (url) {
                case "/demo":
                case "/servlet":
                    if ("user".equals(account.getRole()) || "admin".equals(account.getRole()) || adminRoleSession != null || userRoleSession != null) {
                        filterChain.doFilter(request, response);
                    } else {
                        response.sendRedirect("http://localhost:8080/LoginPage/login");
                    }
                    break;
                case "/user":
                case "/role":
                    if ("admin".equals(account.getRole()) || adminRoleSession != null) {
                        filterChain.doFilter(request, response);
                    } else if (session.getAttribute("user") != null){
                        PrintWriter out = response.getWriter();
                        out.println("Page danh rieng cho admin , back roi login voi tk admin");
                    } else {
                        response.sendRedirect("http://localhost:8080/LoginPage/login");
                    }
                    break;
                default:
                    response.getWriter().println("KO THAY PAGE");
                    response.getWriter().println("Paste link nay de vao lai: http://localhost:8080/LoginPage");
                    session.removeAttribute("urlCurrent");
            }
        }
    }
}




