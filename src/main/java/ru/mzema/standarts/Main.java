package ru.mzema.standarts;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        SQLiteJDBC oracleJDBC = new SQLiteJDBC(new File(SQLiteJDBC.path));

    }

}
