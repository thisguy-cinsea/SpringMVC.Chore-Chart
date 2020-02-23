CREATE TABLE user_chores_tbl (
    userChoresId VARCHAR(36) NOT NULL UNIQUE ,
    userId VARCHAR(36),
    choreId VARCHAR(50),
    creationDate DATE,
    dueDate DATE,
    completionDate DATE,
    notes VARCHAR(150),
    PRIMARY KEY (userChoresId),
    FOREIGN KEY (userId) REFERENCES user_tbl(userId),
    FOREIGN KEY (choreId) REFERENCES chore_tbl(choreId)
);