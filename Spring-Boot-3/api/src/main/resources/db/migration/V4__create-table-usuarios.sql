CREATE TABLE usuarios(
    id BIGINT NOT NULL auto_increment,
    login VARCHAR(100) NOT NULL,
    clave VARCHAR(300) NOT NULL UNIQUE,
    PRIMARY KEY(id)
);