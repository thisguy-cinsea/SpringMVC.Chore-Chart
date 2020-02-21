package com.github.thisguy_cinsea.utils.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;

public interface DBConnectionInterface {
    String getDatabaseName();
    Connection getDatabaseConnection();
    Connection getDatabaseEngineConnection();
    void drop();
    void create();
    void use();
    void executeStatement(String sqlStatement);
    ResultSet executeQuery(String sqlQuery);
}
