DROP TABLE IF EXISTS electoral_register;
DROP TABLE IF EXISTS application;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS checked_in;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS personal_data;
DROP VIEW IF EXISTS personal_data_view;

CREATE TABLE IF NOT EXISTS address (
    id INT NOT NULL AUTO_INCREMENT,
    street VARCHAR(50) NOT NULL,
    city VARCHAR(30) NOT NULL,
    state VARCHAR(20) NOT NULL,
    postal_code VARCHAR(5) NOT NULL,
    country VARCHAR(20) NOT NULL,
    PRIMARY KEY (Id)
    );

CREATE TABLE IF NOT EXISTS personal_data (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    personal_id VARCHAR(11) NOT NULL,
    passport_id VARCHAR(9) NOT NULL,
    birth_date VARCHAR(10) NOT NULL,
    fathers_name VARCHAR(20) NOT NULL,
    mothers_name VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS checked_in (
    id INT NOT NULL AUTO_INCREMENT,
    personal_data_id INT NOT NULL,
    old_address INT,
    new_address INT NOT NULL,
    check_in_date VARCHAR(10) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (personal_data_id) REFERENCES Personal_data(id),
    FOREIGN KEY (old_address) REFERENCES address(id),
    FOREIGN KEY (new_address) REFERENCES address(id)
    );

CREATE TABLE IF NOT EXISTS electoral_register (
     id INT NOT NULL AUTO_INCREMENT,
     personal_data_id INT NOT NULL,
     date_of_receipt_of_voting_rights VARCHAR(10) NOT NULL,
    constituency VARCHAR(100) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (personal_data_id) REFERENCES personal_data(id)
    );

CREATE TABLE IF NOT EXISTS users(
    id INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(75) NOT NULL,
    password VARCHAR(256) NOT NULL,
    role ENUM('EMPLOYEE', 'USER') NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS application(
    id INT NOT NULL AUTO_INCREMENT,
    personal_data_id INT NOT NULL,
    address_id INT NOT NULL,
    date_of_application  DATE NOT NULL,
    result ENUM('POSITIVE', 'NEGATIVE'),
    justification VARCHAR(100),
    submitting_user INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (personal_data_id) REFERENCES personal_data(id),
    FOREIGN KEY  (address_id) REFERENCES address(id),
    FOREIGN KEY (submitting_user) REFERENCES users(id)
);

CREATE OR REPLACE VIEW personal_data_view
AS
SELECT p.name,
       p.last_name,
       p.birth_date,
       p.personal_id,
       p.fathers_name,
       p.mothers_name,
       a.street,
       a.city,
       a.state,
       a.country
FROM personal_data p
         INNER JOIN checked_in c
                    ON p.id = c.personal_data_id
         INNER JOIN address a
                    ON c.new_address = a.id;
