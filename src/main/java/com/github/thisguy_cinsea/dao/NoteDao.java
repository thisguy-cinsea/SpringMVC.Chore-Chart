package com.github.thisguy_cinsea.dao;

import com.github.thisguy_cinsea.model.Note;
import com.github.thisguy_cinsea.model.NoteInterface;
import com.github.thisguy_cinsea.utils.IOConsole;
import com.github.thisguy_cinsea.utils.jdbc.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public interface NoteDao extends CrudInterface<NoteInterface> {
    DBConnection getDBConnection();

    @Override
    default Map<String, NoteInterface> getByStatement(String sqlQuery) {
        ResultSet results = getDBConnection().executeQuery(sqlQuery);
        Map<String, NoteInterface> noteMap = new HashMap<>();
        try {
            while (results.next()) {
                String noteId = results.getString("noteId");
                System.out.println(noteId);
                Note note = new Note(
                        noteId,
                        results.getString("message"),
                        results.getInt("is_Deleted"));
                note.setId(noteId);
                noteMap.put(noteId, note);
            }
        } catch (SQLException e) {
            new IOConsole(IOConsole.AnsiColor.BLUE).println("No record found");
//            throw new Error(e);
        }
        return noteMap;
    }

    default NoteInterface getById(String noteId) {
        return getAllWhere("`note_id` = " + noteId)
                .values()
                .iterator()
                .next();

    }

    @Override
    default String getTableName() {
        return "note_tbl";
    }

    @Override
    default NoteInterface create(NoteInterface o) {
        NoteInterface noteToCreate = new Note(o.getMessage());
        String sqlStatement = "INSERT INTO `note_tbl` ( `noteId`, `message`) VALUES ('" +
                noteToCreate.getId() + "', '" + noteToCreate.getMessage() + "');";
        getDBConnection().executeStatement(sqlStatement);
        return noteToCreate;
    }

    @Override
    default NoteInterface update(String noteId, NoteInterface note) {
        NoteInterface noteToUpdate = getById(noteId);
        noteToUpdate.setId(noteId);
        noteToUpdate.setMessage(note.getMessage());
        String sqlStatement = "UPDATE `note_tbl` SET `message` = '" + noteToUpdate.getMessage()
                + "' WHERE `noteId` = '" + noteToUpdate.getNoteId() + "';";
        getDBConnection().executeStatement(sqlStatement);
        return noteToUpdate;
    }

    @Override
    default NoteInterface delete(String noteId) {
        NoteInterface noteToDelete = getById(noteId);
        noteToDelete.setId(noteId);
        noteToDelete.setDeleted(true);
        String sqlStatement = "UPDATE `note_tbl` SET `is_deleted` = 1 WHERE `noteId` = '"
                + noteToDelete.getNoteId() + "';";
        getDBConnection().executeStatement(sqlStatement);
        return noteToDelete;
    }
}