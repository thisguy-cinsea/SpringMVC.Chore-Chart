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
        executeSqlFile("user.create-table.sql");
        executeSqlFile("user.populate-table.sql");
        executeSqlFile("chore.create-table.sql");
        executeSqlFile("chore.populate-table.sql");
        executeSqlFile("userChore.create-table.sql");
        executeSqlFile("userChore.populate-table.sql");

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