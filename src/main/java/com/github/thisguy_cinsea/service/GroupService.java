package com.github.thisguy_cinsea.service;

import com.github.thisguy_cinsea.dao.GroupDao;
import com.github.thisguy_cinsea.model.Group;
import com.github.thisguy_cinsea.model.GroupInterface;
import com.github.thisguy_cinsea.utils.jdbc.DBConnection;

import java.util.Map;

public class GroupService implements GroupDao {

    private final DBConnection dbc;

    public GroupService(DBConnection dbc) {
        this.dbc = dbc;
    }

    @Override
    public DBConnection getDBConnection() {
        return dbc;
    }

    public GroupService() {
        this(DBConnection.CHORE_CHART_DB);
    }
}
