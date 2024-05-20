package studentsTable;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StudentsContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/test_db");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("rootroot");
        SqlDb sqlDb = new SqlDb(basicDataSource);

        servletContextEvent.getServletContext().setAttribute("my-db", sqlDb);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
