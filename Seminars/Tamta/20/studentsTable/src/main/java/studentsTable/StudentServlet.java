package studentsTable;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.getRequestDispatcher("students.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student newStudent = new Student(request.getParameter("first-name"),
                request.getParameter("last-name"),
                Integer.parseInt(request.getParameter("year")));

        ((ArrayListDb)request.getServletContext().getAttribute("my-db")).add(newStudent);

        doGet(request, response);
//        response.sendRedirect("/students");
    }
}
