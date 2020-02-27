package com.github.thisguy_cinsea.service;

import com.github.thisguy_cinsea.dao.ResponsibilityDao;
import com.github.thisguy_cinsea.utils.jdbc.DBConnection;

public class ResponsibilityService implements ResponsibilityDao {
    private DBConnection dbc;

    public ResponsibilityService(DBConnection dbc) {
        this.dbc = dbc;
    }

    @Override
    public DBConnection getDBConnection() {
        return dbc;
    }

    public ResponsibilityService() {
        this(DBConnection.CHORE_CHART_DB);
    }
}
