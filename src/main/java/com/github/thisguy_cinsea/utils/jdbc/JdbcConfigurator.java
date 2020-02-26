package com.github.thisguy_cinsea.utils.jdbc;

import com.github.thisguy_cinsea.utils.DirectoryReference;
import com.github.thisguy_cinsea.utils.FileReader;

import java.io.File;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;

public class JdbcConfigurator {
    static {
        try {
            DriverManager.registerDriver(Driver.class.getConstructor().newInstance());
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    private static final DBConnection dbc = DBConnection.CHORE_CHART_DB;

    public static void initialize() {
        dbc.drop();
        dbc.create();
        dbc.use();
        executeSqlFile("group.create-table.sql");
        executeSqlFile("group.populate-table.sql");
        executeSqlFile("note.create-table.sql");
        executeSqlFile("note.populate-table.sql");
        executeSqlFile("user.create-table.sql");
        executeSqlFile("user.populate-table.sql");
        executeSqlFile("reg-user.create-table.sql");
        executeSqlFile("reg-user.populate-table.sql");
        executeSqlFile("responsibility.create-table.sql");
        executeSqlFile("responsibility.populate-table.sql");
        executeSqlFile("userResponsibility.create-table.sql");
//        executeSqlFile("userResponsibility.populate-table.sql");
//        executeSqlFile("registration.populate-table.sql");

    }

    private static void executeSqlFile(String fileName) {
        File creationStatementFile = DirectoryReference.RESOURCE_DIRECTORY.getFileFromDirectory(fileName);
        FileReader fileReader = new FileReader(creationStatementFile.getAbsolutePath());
        String[] statements = fileReader.toString().split(";");
        for (int i = 0; i < statements.length; i++) {
            String statement = statements[i];
            dbc.executeStatement(statement);
        }
    }
}