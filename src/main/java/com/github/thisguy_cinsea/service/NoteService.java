package com.github.thisguy_cinsea.service;

import com.github.thisguy_cinsea.dao.NoteDao;
import com.github.thisguy_cinsea.utils.jdbc.DBConnection;

public class NoteService implements NoteDao {

    private final DBConnection dbc;

    public NoteService() {
        this(DBConnection.CHORE_CHART_DB);
    }

    public NoteService(DBConnection dbc) {
        this.dbc = dbc;
    }

    @Override
    public DBConnection getDBConnection() {
        return dbc;
    }

    @Override
    public String getTableName() {
        return "note_tbl";
    }
}