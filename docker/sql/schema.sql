CREATE TABLE IF NOT EXISTS contents(
    id INT AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO contents(title, created_at) VALUES ('Mega content', CURRENT_TIMESTAMP);
INSERT INTO contents(title, created_at) VALUES ('Mega content 2', CURRENT_TIMESTAMP);
INSERT INTO contents(title, created_at) VALUES ('Mega content 3', CURRENT_TIMESTAMP);