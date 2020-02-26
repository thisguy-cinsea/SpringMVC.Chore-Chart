CREATE TABLE responsibility_tbl (
    responsibilityId VARCHAR(36) NOT NULL UNIQUE,
    responsibilityName VARCHAR(50) NOT NULL,
    groupId VARCHAR(36) NOT NULL,
    is_deleted BIT(1),
    PRIMARY KEY (responsibilityId),
    FOREIGN KEY (groupId) REFERENCES group_tbl(groupId)
);