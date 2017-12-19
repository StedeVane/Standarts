package ru.mzema.standards;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

//    private static Connection connection;

//    public DataBase(Connection connection) {
//        this.connection = connection;
//    }

    public static InputStream getFile(int id) {

        Connection connection = SQLiteJDBC.getConnection();
        System.out.println("Creating statement...");

        Statement stmt;

        PreparedStatement preparedStatement;

        try {
//            String sql = ""
            String sql = "SELECT file FROM main.documents where id = " + id;
           // preparedStatement =  connection.prepareStatement(sql);
            stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(sql);


            while(rs.next()){
                //Retrieve by column name
                InputStream file = rs.getBinaryStream("file");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", file: " + file);

                return file;
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Document> getDocumentList() {

        Connection connection = SQLiteJDBC.getConnection();
        List<Document> result = new ArrayList<Document>();

//        PreparedStatement preparedStatement;
        Statement stmt;
        String sql = "select id, name from main.documents";
//        String sql = "SELECT d.id, d.name FROM documents d";

        try {
            stmt = connection.createStatement();
//            preparedStatement =  connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                result.add(new Document(rs.getInt("id"),rs.getString("name")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
