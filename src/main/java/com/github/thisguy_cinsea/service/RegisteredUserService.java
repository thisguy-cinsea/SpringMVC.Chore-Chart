package com.github.thisguy_cinsea.service;

import com.github.thisguy_cinsea.dao.RegisteredUserDao;
import com.github.thisguy_cinsea.utils.jdbc.DBConnection;

public class RegisteredUserService implements RegisteredUserDao {
    private DBConnection dbc;

    public RegisteredUserService(DBConnection dbc) {
        this.dbc = dbc;
    }

    public RegisteredUserService() {
        this(DBConnection.CHORE_CHART_DB);
    }

    public DBConnection getDBConnection() {
        return dbc;
    }
}
