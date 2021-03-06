package ru.avalon.java.j30.labs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Класс описывает представление о коде товара и отражает соответствующую 
 * таблицу базы данных Sample (таблица PRODUCT_CODE).
 * 
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class ProductCode {
    /**
     * Код товара
     */
    private String code;
    /**
     * Кода скидки
     */
    private char discountCode;
    /**
     * Описание
     */
    private String description;
    /**
     * Основной конструктор типа {@link ProductCode}
     * 
     * @param code код товара
     * @param discountCode код скидки
     * @param description описание 
     */
    public ProductCode(String code, char discountCode, String description) {
        this.code = code;
        this.discountCode = discountCode;
        this.description = description;
    }
    /**
     * Инициализирует объект значениями из переданного {@link ResultSet}
     * 
     * @param set {@link ResultSet}, полученный в результате запроса, 
     * содержащего все поля таблицы PRODUCT_CODE базы данных Sample.
     */
    private ProductCode(ResultSet set) throws SQLException {
        /*
         * TODO #05 реализуйте конструктор класса ProductCode
         */
        this(set.getString("prod_code"),
            set.getString("discount_code").charAt(0),
            set.getString("description"));
       // Еще одна реализация:
       //this.code = set.getString("prod_code");
       // this.discountCode = set.getString("discount_code").charAt(0);
       // this.description = set.getString("description");
        //throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Возвращает код товара
     * 
     * @return Объект типа {@link String}
     */
    public String getCode() {
        return code;
    }
    /**
     * Устанавливает код товара
     * 
     * @param code код товара
     */
    public void setCode(String code) {
        this.code = code;
    }
    
    /**
     * Возвращает код скидки
     * 
     * @return Объект типа {@link String}
     */
    public char getDiscountCode() {
        return discountCode;
    }
    /**
     * Устанавливает код скидки
     * 
     * @param discountCode код скидки
     */
    public void setDiscountCode(char discountCode) {
        this.discountCode = discountCode;
    }
    /**
     * Возвращает описание
     * 
     * @return Объект типа {@link String}
     */
    public String getDescription() {
        return description;
    }
    /**
     * Устанавливает описание
     * 
     * @param description описание
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Хеш-функция типа {@link ProductCode}.
     *
     * @return Значение хеш-кода объекта типа {@link ProductCode}
     */
        /*
         * TODO #06 Реализуйте метод hashCode
         */
    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getDiscountCode(), getDescription());
    }
        //throw new UnsupportedOperationException("Not implemented yet!");
    /**
     * Сравнивает некоторый произвольный объект с текущим объектом типа
     * {@link ProductCode}
     *
     * @param obj Объект, скоторым сравнивается текущий объект.
     * @return true, если объект obj тождественен текущему объекту. В обратном
     * случае - false.
     */
    /*
     * TODO #07 Реализуйте метод equals
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ProductCode)) return false;
        ProductCode that = (ProductCode) obj;
        return getDiscountCode() == that.getDiscountCode() &&
                getCode().equals(that.getCode()) &&
                getDescription().equals(that.getDescription());
    }
    //        throw new UnsupportedOperationException("Not implemented yet!");

    /**
     * Возвращает строковое представление кода товара.
     * 
     * @return Объект типа {@link String}
     */
    @Override
    public String toString() {
        /*
         * TODO #08 Реализуйте метод toString
         */
        return "ProductCode{" +
                "code='" + code + '\'' +
                '}';
    }
    //throw new UnsupportedOperationException("Not implemented yet!");
    /**
     * Возвращает запрос на выбор всех записей из таблицы PRODUCT_CODE 
     * базы данных Sample
     * 
     * @param connection действительное соединение с базой данных
     * @return Запрос в виде объекта класса {@link PreparedStatement}
     */
    public static PreparedStatement getSelectQuery(Connection connection) throws SQLException {
        /*
         * TODO #09 Реализуйте метод getSelectQuery
         */
        String querySelect = "SELECT * FROM PRODUCT_CODE";
        return connection.prepareStatement(querySelect);
        //throw new UnsupportedOperationException("Not implemented yet!");
//        PreparedStatement ps = null;
//        ps = getSelectQuery(connection);
    }
    /**
     * Возвращает запрос на добавление записи в таблицу PRODUCT_CODE 
     * базы данных Sample
     * 
     * @param connection действительное соединение с базой данных
     * @return Запрос в виде объекта класса {@link PreparedStatement}
     */
    public static PreparedStatement getInsertQuery(Connection connection) throws SQLException {
        /*
         * TODO #10 Реализуйте метод getInsertQuery
         */
        String queryInsert = "INSERT INTO PRODUCT_CODE (PROD_CODE, DISCOUNT_CODE, DESCRIPTION) VALUES (?,?,?)";
        return connection.prepareStatement(queryInsert);
        //throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Возвращает запрос на обновление значений записи в таблице PRODUCT_CODE 
     * базы данных Sample
     * 
     * @param connection действительное соединение с базой данных
     * @return Запрос в виде объекта класса {@link PreparedStatement}
     */
    public static PreparedStatement getUpdateQuery(Connection connection) throws SQLException {
        /*
         * TODO #11 Реализуйте метод getUpdateQuery
         */
        String queryUpdate = "UPDATE PRODUCT_CODE SET DISCOUNT_CODE = ?, DESCRIPTION = ? " +
                "WHERE PROD_CODE = ? ";
        return connection.prepareStatement(queryUpdate);
        //throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Преобразует {@link ResultSet} в коллекцию объектов типа {@link ProductCode}
     * 
     * @param set {@link ResultSet}, полученный в результате запроса, содержащего
     * все поля таблицы PRODUCT_CODE базы данных Sample
     * @return Коллекция объектов типа {@link ProductCode}
     * @throws SQLException 
     */
    public static Collection<ProductCode> convert(ResultSet set) throws SQLException {
        /*
         * TODO #12 Реализуйте метод convert
         */
        Collection<ProductCode> productCodes = new LinkedList<>();
        while (set.next()) {
            ProductCode obj = new ProductCode(set);
            productCodes.add(obj);
        }
        return productCodes;
        //throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Сохраняет текущий объект в базе данных. 
     * <p>
     * Если запись ещё не существует, то выполняется запрос типа INSERT.
     * <p>
     * Если запись уже существует в базе данных, то выполняется запрос типа UPDATE.
     * 
     * @param connection действительное соединение с базой данных
     */
    public void save(Connection connection) throws SQLException {
        /*
         * TODO #13 Реализуйте метод save
         */
        String queryInsert = "INSERT INTO PRODUCT_CODE (PROD_CODE, DISCOUNT_CODE, DESCRIPTION) VALUES (?,?,?)";
        String queryUpdate = "UPDATE PRODUCT_CODE SET DISCOUNT_CODE = ?, DESCRIPTION = ? " +
                "WHERE PROD_CODE = ? ";

        PreparedStatement psInsert = null;
        PreparedStatement psUpdate = null;
        try {
            psInsert = connection.prepareStatement(queryInsert);
            psInsert.setString(1, code);
            psInsert.setString(2, String.valueOf(discountCode));
            psInsert.setString(3, description);
            psInsert.executeUpdate();


        } catch (SQLException e) {
            //e.printStackTrace();
            if (connection != null) {
                //System.err.print("Transaction is being rolled back");
                connection.rollback();
            }
            psUpdate = connection.prepareStatement(queryUpdate);
            psUpdate.setString(1, String.valueOf(discountCode));
            psUpdate.setString(2, description);
            psUpdate.setString(3, code);
            psUpdate.executeUpdate();
        } finally {
            if (psInsert != null) {
                psInsert.close();
            }
            if (psUpdate != null) {
                psUpdate.close();
            }
        }
        //throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Возвращает все записи таблицы PRODUCT_CODE в виде коллекции объектов
     * типа {@link ProductCode}
     * 
     * @param connection действительное соединение с базой данных
     * @return коллекция объектов типа {@link ProductCode}
     * @throws SQLException 
     */
    public static Collection<ProductCode> all(Connection connection) throws SQLException {
        try (PreparedStatement statement = getSelectQuery(connection)) {
            try (ResultSet result = statement.executeQuery()) {
                return convert(result);
            }
        }
    }
}
