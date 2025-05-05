CREATE TABLE IF NOT EXISTS tire (
    id BINARY(16) PRIMARY KEY,
    brand VARCHAR(50),
    model VARCHAR(100),
    size VARCHAR(50),
    price DOUBLE,
    stock INT,
    width INT,
    aspect_ratio INT,
    diameter INT
);

CREATE TABLE IF NOT EXISTS user (
    id BINARY(16) PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255),
    full_name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(20),
    role VARCHAR(20)
);
