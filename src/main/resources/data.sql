INSERT INTO user (id, username, password, full_name, email, phone, role) VALUES
 (UUID_TO_BIN(UUID()), 'admin', '$2a$10$7QKItFbMkKoQvC.1eCqGduvTURHFwhZi6GRRJ3MFRYzZo1lEBePCa', 'Admin User', 'admin@example.com', '1234567890', 'ROLE_ADMIN'),
 (UUID_TO_BIN(UUID()), 'user1', '$2a$10$y8Eog5QaFKpEtAj3bhCGAOLrTGL4mIGuBpIfN3WKh9NBuvKD8X/UW', 'John Doe', 'john.doe@example.com', '1112223333', 'ROLE_USER'),
 (UUID_TO_BIN(UUID()), 'user2', '$2a$10$y8Eog5QaFKpEtAj3bhCGAOLrTGL4mIGuBpIfN3WKh9NBuvKD8X/UW', 'Jane Smith', 'jane.smith@example.com', '4445556666', 'ROLE_USER');

-- Password for admin: admin123
-- Password for user1 and user2: user123

INSERT INTO tire (id, brand, model, size, price, stock, width, aspect_ratio, diameter) VALUES
    (UUID_TO_BIN(UUID()), 'MICHELIN', 'Primacy 4', '205/55R16', 95.0, 100, 205, 55, 16);