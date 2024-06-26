package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Db {

    // Singleton Design Pattern

    private static Db instance = null;

    private Connection connection = null;

    private final String DB_URL = "jdbc:postgresql://localhost:5432/tourism_agency";

    private final String DB_USERNAME = "postgres";

    private final String DB_PASS = "728770";

    private Db() {

        try {

            this.connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASS);

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    public Connection getConnection() {
        return connection;
    }

    public static Connection getInstance() {

        try {

            if (instance == null || instance.getConnection().isClosed()){

                instance = new Db();

                return instance.getConnection();

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return instance.getConnection();

    }

}