CREATE TABLE tb_users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,

    CONSTRAINT uk_users_username UNIQUE (username),
    CONSTRAINT uk_users_email UNIQUE (email)
);

INSERT INTO tb_users (username, email) VALUES
('admin', 'admin@email.com'),
('joao', 'joao@email.com'),
('maria', 'maria@email.com');

