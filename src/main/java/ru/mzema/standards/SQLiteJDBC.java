package ru.mzema.standards;

import java.io.File;
import java.sql.*;

public class SQLiteJDBC {
    public final static String path = "E:\\Git\\Standards\\standards.db";

    private Connection connection = null;

    private static SQLiteJDBC jdbc = null;

    private SQLiteJDBC(File file) {

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:"+file.getPath());
        } catch (
                Exception e
                )

        {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        System.out.println("Opened database successfully");
    }


    public static Connection getConnection() {
        if (jdbc==null) jdbc = new SQLiteJDBC(new File(path));
        return jdbc.connection;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}