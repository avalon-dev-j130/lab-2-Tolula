package ru.avalon.java.j30.labs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Properties;
import java.io.*;

import static ru.avalon.java.j30.labs.ProductCode.getSelectQuery;

/**
 * Лабораторная работа №3
 * <p>
 * Курс: "DEV-OCPJP. Подготовка к сдаче сертификационных экзаменов серии Oracle Certified Professional Java Programmer"
 * <p>
 * Тема: "JDBC - Java Database Connectivity" 
 *
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class Main {

    /**
     * Точка входа в приложение
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException {
        /*
         * TODO #01 Подключите к проекту все библиотеки, необходимые для соединения с СУБД.
         */
        try (Connection connection = getConnection()) {
            ProductCode code = new ProductCode("MO", 'N', "Movies");
            code.save(connection);
            printAllCodes(connection);
            code.setCode("MV");
            code.save(connection);
            printAllCodes(connection);
        }
        /*
         * TODO #14 Средствами отладчика проверьте корректность работы программы
         */
    }
    /**
     * Выводит в кодсоль все коды товаров
     * 
     * @param connection действительное соединение с базой данных
     * @throws SQLException 
     */    
    private static void printAllCodes(Connection connection) throws SQLException {
        Collection<ProductCode> codes = ProductCode.all(connection);
        for (ProductCode code : codes) {
            System.out.println(code);
        }
    }
    /**
     * Возвращает URL, описывающий месторасположение базы данных
     * 
     * @return URL в виде объекта класса {@link String}
     */
    private static String getUrl() throws IOException {
        /*
         * TODO #02 Реализуйте метод getUrl
         */
        Properties properties = getProperties();
        return properties.getProperty("database.driver") + "://" +
                properties.getProperty("database.host") + ":" +
                properties.getProperty("database.port") + "/" +
                properties.getProperty("database.name");
    }
    /**
     * Возвращает параметры соединения
     * 
     * @return Объект класса {@link Properties}, содержащий параметры user и 
     * password
     */
    private static Properties getProperties() throws IOException {
        /*
         * TODO #03 Реализуйте метод getProperties
         */
        Properties properties = new Properties();
        try (InputStream stream = ClassLoader.getSystemResourceAsStream("Resources/application.properties")) {
            properties.load(stream);
            return properties;
        }
        //throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Возвращает соединение с базой данных Sample
     * 
     * @return объект типа {@link Connection}
     * @throws SQLException 
     */
    private static Connection getConnection() throws SQLException, IOException {
        /*
         * TODO #04 Реализуйте метод getConnection
         */
        return DriverManager.getConnection(getUrl(), getProperties());
    }


}
