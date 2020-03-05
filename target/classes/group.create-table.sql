CREATE TABLE group_tbl (
    id VARCHAR(36) NOT NULL UNIQUE,
    groupName VARCHAR(50) NOT NULL,
    is_deleted BIT(1),
    PRIMARY KEY (id)
);