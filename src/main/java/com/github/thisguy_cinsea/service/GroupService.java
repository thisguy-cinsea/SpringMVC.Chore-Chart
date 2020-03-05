package com.github.thisguy_cinsea.service;

import com.github.thisguy_cinsea.dao.GroupDao;
import com.github.thisguy_cinsea.utils.jdbc.DBConnection;

public class GroupService implements GroupDao {

    private final DBConnection dbc;

    public GroupService() {
        this(DBConnection.CHORE_CHART_DB);
    }

    public GroupService(DBConnection dbc) {
        this.dbc = dbc;
    }

    @Override
    public DBConnection getDBConnection() {
        return dbc;
    }

    @Override
    public String getTableName() {
        return "group_tbl";
    }
}
