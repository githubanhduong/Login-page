package servlet;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "game", urlPatterns = {"/game"})
public class GameDoanSo extends HttpServlet {
    static List<User> userList = new ArrayList<User>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //
        User user = new User();
        String namePlayer = req.getParameter("nameUser");
        user.setName(namePlayer);
        user.setCountTurn(0);
        if (user.getName() == null) req.getRequestDispatcher("createUser.jsp").forward(req, resp); // player chua dc tao thi vao file jsp createUser de tao
        req.getSession().setAttribute("user", user);
        //18 - 22 : set cac thuoc tinh cho player va tao attribute-player(user) cho servlet
        if(user.getName() != null) userList.add(user);
        req.setAttribute("playerRank", userList);
        //
        req.getRequestDispatcher("gameDoanSo.jsp").forward(req, resp); // player da dc tao thi vo file gameDoanSo.jsp

        req.getSession().setAttribute("playerRank", userList);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user"); // nhan attribute-player tu doGet
        //
        int updateTurn = user.getCountTurn() + 1;
        user.setCountTurn(updateTurn);
        // 32-33 : update so luot choi cua player
        req.getSession().setAttribute("user", user); // reset lai attribute-player

        int numberOfGame = (int) (Math.random()*100); // tao so de doan trong game
        resp.getWriter().println("ban dung nhap tao lao"); // thong bao khi player nhap sai

        int numberPredicted = Integer.parseInt(req.getParameter("soDuDoan")); // nhap param so duoc du doan tu player
        //
        if (numberPredicted < numberOfGame) {
            req.setAttribute("result", -1);
        } else if (numberPredicted > numberOfGame) {
            req.setAttribute("result", 1);
        } else {
            req.setAttribute("result", 0);
            int achievement = ((User) req.getSession().getAttribute("user")).getCountTurn();
            user.setAchievement(achievement);
        }
        req.setAttribute("number", numberPredicted);
        //42-49 : set attribute ket qua de gameDoanSo.jsp nhan
        req.getRequestDispatcher("gameDoanSo.jsp").forward(req, resp);

    }
}
