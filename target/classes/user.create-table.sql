CREATE TABLE user_tbl (
    userId VARCHAR(36) NOT NULL UNIQUE ,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50),
    email VARCHAR(75) UNIQUE,
    password VARCHAR(60),
    PRIMARY KEY (userId)
);