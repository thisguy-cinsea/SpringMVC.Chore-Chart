CREATE TABLE reg_user_tbl (
    userId VARCHAR(36) NOT NULL UNIQUE,
    lastName VARCHAR(50) NOT NULL,
    password VARCHAR(60) NOT NULL,
    email VARCHAR(75) UNIQUE NOT NULL,
    role VARCHAR(15) NOT NULL,
    is_deleted BIT(1),
    PRIMARY KEY (userId),
    FOREIGN KEY (userId) REFERENCES user_tbl(userId)
);