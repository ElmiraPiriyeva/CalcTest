package ada.wm2.servlet;

import ada.wm2.helper.SalaryHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/GrossToNetSalaryCalculation")
public class GrossToNetSalaryCalculation extends HttpServlet {

        public String totresult = "0.0";
        public int Guzesht = 0;
        public boolean bValue;


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            double gross = Double.parseDouble(request.getParameter("Gross"));
            double percentage = Double.parseDouble(request.getParameter("Percentage"));
            String sector  = request.getParameter("Sector");
            String year = request.getParameter("Year");
            String mycheckbox  = request.getParameter("Citizen");



            if ("Dövlət və Neft-qaz sektoru".equals(sector)) {
                bValue = false;
            } else {
                bValue = true;
            }

               if ("2".equals(mycheckbox)) {
                    Guzesht = 400;

                } else if ("3".equals(mycheckbox)) {
                    Guzesht = 200;

                } else if ("4".equals(mycheckbox)) {
                    Guzesht = 100;

                } else if ("5".equals(mycheckbox)) {
                    Guzesht = 50;

                }else{
                    Guzesht = 0;

                }


            if ("2017".equals(year)) {
                totresult = Double.toString(SalaryHelper.GrossToNet2017(Guzesht,gross, percentage));
            } else if ("2018".equals(year)) {
                totresult = Double.toString(SalaryHelper.GrossToNet2018(Guzesht,gross, percentage));
            } else if ("2019".equals(year)) {
                totresult = Double.toString(SalaryHelper.GrossToNet2019(Guzesht,bValue,gross, percentage));
            } else if ("2020".equals(year)) {
                totresult = Double.toString(SalaryHelper.GrossToNet2020(Guzesht,bValue, gross, percentage));

            }
                response.setContentType("text/plain");
                response.getWriter().println(totresult);
    }


}
