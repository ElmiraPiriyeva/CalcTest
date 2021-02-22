package ada.wm2.servlet;

import ada.wm2.helper.SalaryHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/NetToGrossSalaryCalculation")
public class NetToGrossSalaryCalculation  extends HttpServlet {

    public String totresult = "0.0";
    public boolean bValue;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        double net = Double.parseDouble(request.getParameter("Net"));
        String sector  = request.getParameter("Sector");
        String year = request.getParameter("Year");


        if ("Dövlət və Neft-qaz sektoru ".equals(sector)) {
            bValue = false;
        } else {
            bValue = true;
        }
        if ("2018".equals(year)) {
            totresult = Double.toString(SalaryHelper.NetToGross2018(net));

        } else if ("2019".equals(year)) {
            totresult = Double.toString(SalaryHelper.NetToGross2019(net));

        }
             response.setContentType("text/plain");
             response.getWriter().println(totresult);
    }

}
