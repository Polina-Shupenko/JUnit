package lab6sitaris;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lab6sitaris.parser.Catalog;
import lab6sitaris.parser.Parser;

import java.io.IOException;

@WebServlet("")
public class MainServlet  extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Catalog catalog = Parser.parseCatalog("D:\\sitaris6\\src\\main\\resources\\error.xml");

        req.setAttribute("avg", catalog.average());
        req.setAttribute("courses", catalog.getCourses());
        req.setAttribute("names", catalog.getNames());
        req.setAttribute("prices", catalog.getPrices());
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp); //переадресация на страницу
    }
}