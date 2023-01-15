package servlet;

import model.User;
import service.RankService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "rank", urlPatterns = {"/rank"})
public class Rank extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> playerRank = (List<User>) req.getSession().getAttribute("playerRank");
        RankService.sortPlayer(playerRank);
        req.getSession().removeAttribute("playerRank");
        req.getSession().setAttribute("playerRank", playerRank);
        req.getRequestDispatcher("rank.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
