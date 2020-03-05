package com.github.thisguy_cinsea.dao;

import com.github.thisguy_cinsea.model.Note;
import com.github.thisguy_cinsea.model.NoteInterface;
import java.util.Map;

public interface NoteDao extends DaoInterface<NoteInterface>{

    default Map<String, NoteInterface> getByStatement(String sqlQuery) {
        return getByStatement((results) -> {
            try {
                String noteId = results.getString("id");
                Note note = new Note(
                        noteId,
                        results.getString("message"),
                        results.getInt("is_Deleted"));
                note.setId(noteId);
                return note;
            } catch(Exception e) {
                throw new Error(e);
            }
        }, sqlQuery);
    }

    default NoteInterface create(NoteInterface note) {
        NoteInterface noteToCreate = new Note(note.getMessage());
        String sqlStatement = "INSERT INTO `"+ getTableName() +"` ( `id`, `message`) VALUES ('"+
                noteToCreate.getId() +"', '"+ noteToCreate.getMessage() +"');";
        getDBConnection().executeStatement(sqlStatement);
        return noteToCreate;
    }

    default NoteInterface update(String noteId, NoteInterface note) {
        NoteInterface noteToUpdate = getById(noteId);
        noteToUpdate.setId(noteId);
        noteToUpdate.setMessage(note.getMessage());
        String sqlStatement = "UPDATE `" + getTableName() + "` SET `message` = '"+ noteToUpdate.getMessage()
                +"' WHERE `id` = '"+ noteToUpdate.getId() +"';";
        getDBConnection().executeStatement(sqlStatement);
        return noteToUpdate;
    }
}