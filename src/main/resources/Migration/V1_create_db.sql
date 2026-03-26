create table Client(
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(1000) NOT NULL
                           CHECK ( CHAR_LENGTH(name) >= 3 AND CHAR_LENGTH(name) <= 200 )
);

create table Planet(
                       id VARCHAR,
                       CHECK (id ~ '^[A-Z0-9]+$'),
    name VARCHAR(1000) NOT NULL
    CHECK ( CHAR_LENGTH(name) >= 1 AND CHAR_LENGTH(name) <= 500 )
);
create table Ticket(
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       client_id INT NOT NULL,
                       from_planet_id VARCHAR(100) NOT NULL,
                       to_planet_id VARCHAR(100) NOT NULL,

                       FOREIGN KEY(client_id) REFERENCES Client(id),
                       FOREIGN KEY(from_planet_id) REFERENCES Planet(id),
                       FOREIGN KEY(to_planet_id) REFERENCES Planet(id),
);