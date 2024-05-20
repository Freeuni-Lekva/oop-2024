package studentsTable;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentServlet extends HttpServlet {
    private static final String WHOAMI = "whoami";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String me = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(WHOAMI)) {
                    me = cookie.getValue();
                }
            }
        }
        if (me != null){
            request.setAttribute(WHOAMI, me);
        }
        List<Student> students = ((Db)request.getServletContext().getAttribute("my-db")).getAll();
        request.setAttribute("students", students);
        request.getRequestDispatcher("students.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student newStudent = new Student(request.getParameter("first-name"),
                request.getParameter("last-name"),
                Integer.parseInt(request.getParameter("year")));

        ((Db)request.getServletContext().getAttribute("my-db")).add(newStudent);
        response.addCookie(new Cookie(WHOAMI, request.getParameter("first-name")));

        response.sendRedirect("/students");
    }
}
