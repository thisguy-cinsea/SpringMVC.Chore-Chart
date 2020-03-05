CREATE TABLE reg_user_tbl (
    id VARCHAR(36) NOT NULL UNIQUE,
    lastName VARCHAR(50) NOT NULL,
    password VARCHAR(60) NOT NULL,
    email VARCHAR(75) UNIQUE NOT NULL,
    role VARCHAR(15) NOT NULL,
    is_registration_deleted BIT(1),
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES user_tbl(id)
);