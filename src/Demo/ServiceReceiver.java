package Demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServiceReceiver extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int numberOfSims = Integer.parseInt(request.getParameter("sims"));

        Driver driver = new Driver();

        String ret = driver.runner(numberOfSims);
        response.getWriter().write(ret);
    }
}
