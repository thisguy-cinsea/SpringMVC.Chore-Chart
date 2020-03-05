CREATE TABLE user_responsibility_tbl (
    id VARCHAR(36) NOT NULL UNIQUE ,
    userId VARCHAR(36),
    responsibilityId VARCHAR(36),
    creationDate DATE,
    dueDate DATE,
    completionDate DATE,
    creationId VARCHAR(36),
    completedId VARCHAR(36),
    noteId VARCHAR(136),
    is_deleted BIT(1),
    PRIMARY KEY (id),
    FOREIGN KEY (userId) REFERENCES user_tbl(id),
    FOREIGN KEY (responsibilityId) REFERENCES responsibility_tbl(id),
    FOREIGN KEY (creationId) REFERENCES reg_user_tbl(id),
    FOREIGN KEY (completedId) REFERENCES reg_user_tbl(id),
    FOREIGN KEY (noteId) REFERENCES note_tbl(id)
);