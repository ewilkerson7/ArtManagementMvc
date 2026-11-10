use artmanagementdb;

-- Create the Art table based on Art.java and its subclasses
-- Uses SINGLE_TABLE inheritance with an art_type discriminator column[cite: 6]
CREATE TABLE art (
    id VARCHAR(10) NOT NULL PRIMARY KEY, -- Length 10, unique, not null[cite: 6]
    art_type VARCHAR(31) NOT NULL, -- Discriminator column (DRAWING, PAINTING, PRINT, SCULPTURE)[cite: 6, 8, 9, 10, 11]
    price DOUBLE,
    year_created INT,
    title VARCHAR(255),
    description VARCHAR(500), -- Explicitly set to length 500[cite: 6]
    author_name VARCHAR(255),
    
    -- Drawing & Painting shared fields[cite: 8, 9]
    style VARCHAR(255), 
    technique VARCHAR(255), 
    
    -- Drawing, Painting, & Print shared fields[cite: 8, 9, 10]
    category VARCHAR(255), 
    
    -- Painting specific fields[cite: 9]
    height_inches DOUBLE, 
    width_inches DOUBLE, 
    
    -- Print specific fields[cite: 10]
    open_edition_type VARCHAR(255), 
    
    -- Sculpture specific fields[cite: 11]
    material VARCHAR(255), 
    weight_ounces DOUBLE 
);

-- Create the Transaction table based on Transaction.java and Customer.java
-- Customer fields are embedded directly into this table[cite: 7, 12]
CREATE TABLE transaction (
    transaction_id VARCHAR(255) NOT NULL PRIMARY KEY,
    
    -- Embedded Customer fields[cite: 7]
    first_name VARCHAR(255), 
    last_name VARCHAR(255), 
    mailing_address VARCHAR(255), 
    phone_number VARCHAR(255), 
    email VARCHAR(255), 
    
    -- Transaction fields[cite: 12]
    transaction_date DATE, -- Null means incomplete[cite: 12]
    transaction_price DOUBLE
);

-- Create the Many-to-Many join table for Transaction and Art[cite: 12]
CREATE TABLE transaction_arts (
    transaction_id VARCHAR(255) NOT NULL,
    art_id VARCHAR(10) NOT NULL,
    PRIMARY KEY (transaction_id, art_id),
    FOREIGN KEY (transaction_id) REFERENCES transaction(transaction_id) ON DELETE CASCADE,
    FOREIGN KEY (art_id) REFERENCES art(id) ON DELETE CASCADE
);