CREATE TABLE IF NOT EXISTS content(
    id SERIAL PRIMARY KEY INT,
    title VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL
);