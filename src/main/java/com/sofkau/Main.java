package com.sofkau;

import com.github.javafaker.Faker;
import com.sofkau.integration.database.mysql.MySqlOperation;

import java.security.spec.RSAOtherPrimeInfo;
import java.sql.SQLException;

public class Main {

    private static final String SERVER = "localhost";
    private static final String DATA_BASE_NAME = "libreriabuscalibre";
    private static final String USER = "root";
    private static final String PASSWORD = "Admin.1234";

    private static final String SELECT_ALL_FROM_LIBROS = String.format("select * from %s.libro", DATA_BASE_NAME);
    private static final String INSERT_LIBRO = "insert into libreriabuscalibre.libro values ('ABC5000', 'Jessica', '100', 'alfa');";
    private static final MySqlOperation mySqlOperation = new MySqlOperation();

    public static void main(String[] args) throws SQLException {
  /*      openConnection();
        insertIntoLibro();
        selectAllFromLibro();
        closeConnection();*/

        Faker faker = new Faker();
        System.out.println(faker.numerify("###"));

    }

    public static void openConnection() {
        mySqlOperation.setServer(SERVER);
        mySqlOperation.setDataBaseName(DATA_BASE_NAME);
        mySqlOperation.setUser(USER);
        mySqlOperation.setPassword(PASSWORD);
    }

    public static void selectAllFromLibro() throws SQLException {
        mySqlOperation.setSqlStatement(SELECT_ALL_FROM_LIBROS);
        mySqlOperation.executeSqlStatement();
        mySqlOperation.printResulset();
    }

    public static void insertIntoLibro()  {
        mySqlOperation.setSqlStatement(INSERT_LIBRO);
        mySqlOperation.executeSqlStatementVoid();

    }

    public static void closeConnection() {
        mySqlOperation.close();
    }
}