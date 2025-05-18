package in.hello.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@WebServlet("/check")
public class UtilServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Declare HikariDataSource as a class-level variable
    private static HikariDataSource dataSource;

    // Initialize the data source in a static block or in a servlet init() method
    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/jdbcpgms");
        config.setUsername("root");
        config.setPassword("HussainCS 211210");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver"); // Specify the driver class
        config.setMaximumPoolSize(10); // You can adjust the pool size as needed
        config.setConnectionTimeout(30000); // 30 seconds timeout

        // Optional configuration settings
        config.setIdleTimeout(60000); // 1 minute idle timeout
        config.setMaxLifetime(1800000); // 30 minutes max lifetime of a connection

        dataSource = new HikariDataSource(config);
    }

    // Properly close the data source when the servlet is destroyed
    @Override
    public void destroy() {
        if (dataSource != null) {
            dataSource.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try (Connection connection = dataSource.getConnection()) {
            out.println("Connection object got created using HikariCP");
        } catch (SQLException e) {
            e.printStackTrace(out);
            out.println("Connection failed: " + e.getMessage());
        }
    }
}
