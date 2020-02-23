CREATE TABLE chore_tbl (
    choreId VARCHAR(36) NOT NULL UNIQUE,
    choreName VARCHAR(50) NOT NULL,
    PRIMARY KEY (choreId)
);