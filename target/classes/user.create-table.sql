CREATE TABLE user_tbl (
    id VARCHAR(36) NOT NULL UNIQUE,
    firstName VARCHAR(50) NOT NULL,
    groupId VARCHAR(36) NOT NULL,
    is_deleted BIT(1),
    PRIMARY KEY (id),
    FOREIGN KEY (groupId) REFERENCES group_tbl(id)
);