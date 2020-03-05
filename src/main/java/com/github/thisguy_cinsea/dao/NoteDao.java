package com.github.thisguy_cinsea.dao;

import com.github.thisguy_cinsea.model.Note;
import com.github.thisguy_cinsea.model.NoteInterface;
import com.github.thisguy_cinsea.utils.IOConsole;
import com.github.thisguy_cinsea.utils.jdbc.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public interface NoteDao {
    DBConnection getDatabaseConnection();

    default Map<String, NoteInterface> getNoteByStatement(String sqlQuery) {
        sqlQuery = sqlQuery + " AND `is_deleted` <> 1 OR `is_deleted` IS NULL;";
        ResultSet results = getDatabaseConnection().executeQuery(sqlQuery);
        Map<String, NoteInterface> noteMap = new HashMap<>();
        try{
            while (results.next()){
                String noteId = results.getString("noteId");
                System.out.println(noteId);
                Note note = new Note(
                        noteId,
                        results.getString("message"),
                        results.getInt("is_Deleted"));
                note.setNoteId(noteId);
                noteMap.put(noteId, note);
            }
        } catch (SQLException e) {
            new IOConsole(IOConsole.AnsiColor.BLUE).println("No record found");
//            throw new Error(e);
        }
        return noteMap;
    }

    default Map<String, NoteInterface> getAllNotes() {
        return getNoteByStatement("SELECT * FROM `note_tbl` WHERE 1 = 1");
    }

    
    default NoteInterface getNoteById(String noteId) {
        Map<String, NoteInterface> noteMap = getNoteByStatement("SELECT * FROM `note_tbl`" +
                "WHERE `noteId` = '" + noteId + "'");
        if (noteMap.isEmpty())
            return null;
        return noteMap.values().iterator().next();
    }

    default NoteInterface createNote(Note note) {
        NoteInterface noteToCreate = new Note(note.getMessage());
        String sqlStatement = "INSERT INTO `note_tbl` ( `noteId`, `message`) VALUES ('"+
                noteToCreate.getNoteId() +"', '"+ noteToCreate.getMessage() +"');";
        getDatabaseConnection().executeStatement(sqlStatement);
        return note;
    }

    
    default NoteInterface updateNote(String noteId, NoteInterface note) {
        NoteInterface noteToUpdate = getNoteById(noteId);
        noteToUpdate.setNoteId(noteId);
        noteToUpdate.setMessage(note.getMessage());
        String sqlStatement = "UPDATE `note_tbl` SET `message` = '"+ noteToUpdate.getMessage()
                +"' WHERE `noteId` = '"+ noteToUpdate.getNoteId() +"';";
        getDatabaseConnection().executeStatement(sqlStatement);
        return noteToUpdate;
    }

    
    default NoteInterface deleteNote(String noteId) {
        NoteInterface noteToUpdate = getNoteById(noteId);
        noteToUpdate.setNoteId(noteId);
        noteToUpdate.setDeleted(true);
        String sqlStatement = "UPDATE `note_tbl` SET `is_deleted` = 1 WHERE `noteId` = '"
                + noteToUpdate.getNoteId() +"';";
        getDatabaseConnection().executeStatement(sqlStatement);
        return noteToUpdate;
    }
}
