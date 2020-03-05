CREATE TABLE note_tbl (
    id VARCHAR(36) NOT NULL UNIQUE,
    message VARCHAR(150) NOT NULL,
    is_deleted BIT(1),
    PRIMARY KEY (id)
);