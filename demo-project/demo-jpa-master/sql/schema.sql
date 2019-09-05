CREATE OR REPLACE TABLE customer (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    created_date DATETIME NOT NULL DEFAULT NOW()
);

CREATE OR REPLACE TABLE profile (
    customer_id BIGINT NOT NULL,
    street_number VARCHAR(255) NOT NULL,
    street_name VARCHAR(255) NOT NULL,
    district VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL
);
ALTER TABLE profile ADD CONSTRAINT profile_fk_customer_id
    FOREIGN KEY (customer_id) REFERENCES customer(id);

CREATE OR REPLACE TABLE product (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL DEFAULT '',
    price DECIMAL NOT NULL DEFAULT 0.0
);

CREATE OR REPLACE TABLE tag (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE OR REPLACE TABLE product_tag (
    tag_id BIGINT,
    product_id BIGINT,
    PRIMARY KEY (tag_id, product_id)
);
ALTER TABLE product_tag ADD CONSTRAINT product_tag_fk_tag_id
    FOREIGN KEY (tag_id) REFERENCES tag(id);
ALTER TABLE product_tag ADD CONSTRAINT product_tag_fk_product_id
    FOREIGN KEY (product_id) REFERENCES product(id);

CREATE OR REPLACE TABLE customer_order (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    customer_id BIGINT NOT NULL,
    discount DECIMAL NOT NULL DEFAULT 0,
    created_date DATETIME NOT NULL DEFAULT NOW(),
    last_modified DATETIME NOT NULL DEFAULT NOW(),
    status INT NOT NULL DEFAULT 0
);
ALTER TABLE customer_order ADD CONSTRAINT customer_order_fk_customer_id 
    FOREIGN KEY (customer_id) REFERENCES customer(id);

CREATE OR REPLACE TABLE line_item (
    product_id BIGINT,
    order_id BIGINT,
    quantity INT NOT NULL DEFAULT 1,
    item_price DECIMAL NOT NULL,
    sub_total DECIMAL AS (quantity * item_price),
    PRIMARY KEY (product_id, order_id)
);
ALTER TABLE line_item ADD CONSTRAINT line_item_fk_product_id
    FOREIGN KEY (product_id) REFERENCES product(id);
ALTER TABLE line_item ADD CONSTRAINT line_item_fk_order_id
    FOREIGN KEY (order_id) REFERENCES customer_order(id);