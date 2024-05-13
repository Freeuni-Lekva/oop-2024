package studentsTable;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StudentsContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ArrayListDb db = new ArrayListDb();
        servletContextEvent.getServletContext().setAttribute("my-db", db);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
