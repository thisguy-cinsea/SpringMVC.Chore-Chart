CREATE TABLE group_tbl (
    groupId VARCHAR(36) NOT NULL UNIQUE,
    groupName VARCHAR(50) NOT NULL,
    is_deleted BIT(1),
    PRIMARY KEY (groupId)
);