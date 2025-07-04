
CREATE TABLE IF NOT EXISTS CUSTOMERS (
                                         id SERIAL PRIMARY KEY,
                                         name VARCHAR(255),
    surname VARCHAR(255),
    age INT,
    phone_number VARCHAR(20)
    );

CREATE TABLE IF NOT EXISTS ORDERS (
                        id SERIAL PRIMARY KEY,
                        date DATE,
                        customer_id INT,
                        product_name VARCHAR(255),
                        amount INT,
                        FOREIGN KEY (customer_id) REFERENCES CUSTOMERS(id)
);