use artmanagementdb;

-- Insert sample DRAWING[cite: 8]
INSERT INTO art (
    id, art_type, price, year_created, title, description, author_name, style, technique, category
) VALUES (
    'ART0000001', 'DRAWING', 150.00, 2021, 'Charcoal Dreams', 'A dark sketch', 'John Doe', 'Abstract', 'Charcoal', 'Portrait'
);

-- Insert sample PAINTING[cite: 9]
INSERT INTO art (
    id, art_type, price, year_created, title, description, author_name, height_inches, width_inches, style, technique, category
) VALUES (
    'ART0000002', 'PAINTING', 1200.00, 2023, 'Sunset Boulevard', 'Oil on canvas', 'Jane Smith', 24.0, 36.0, 'Impressionism', 'Oil', 'Landscape'
);

-- Insert sample PRINT[cite: 10]
INSERT INTO art (
    id, art_type, price, year_created, title, description, author_name, open_edition_type, category
) VALUES (
    'ART0000003', 'PRINT', 75.00, 2022, 'City Skyline', 'Limited print', 'Bob Ross', 'Canvas', 'Landscape'
);

-- Insert sample SCULPTURE[cite: 11]
INSERT INTO art (
    id, art_type, price, year_created, title, description, author_name, material, weight_ounces
) VALUES (
    'ART0000004', 'SCULPTURE', 3000.00, 2019, 'The Thinker Replica', 'Bronze cast', 'Alice Johnson', 'Metal', 150.5
);

-- Insert sample Transaction[cite: 7, 12]
INSERT INTO transaction (
    transaction_id, first_name, last_name, mailing_address, phone_number, email, transaction_date, transaction_price
) VALUES (
    'TXN-9991', 'Michael', 'Scott', '1725 Slough Avenue', '555-0199', 'mscott@email.com', '2023-10-15', 1350.00
);

-- Associate the transaction with art pieces using the join table[cite: 12]
INSERT INTO transaction_arts (transaction_id, art_id) VALUES 
('TXN-9991', 'ART0000001'),
('TXN-9991', 'ART0000002');