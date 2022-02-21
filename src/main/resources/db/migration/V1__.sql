CREATE SEQUENCE  IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS customer (
  id BIGINT NOT NULL,
  username VARCHAR(200) NOT NULL,
  password VARCHAR(100) NOT NULL,
  CONSTRAINT pk_customer PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS customer_detil (
  id BIGINT NOT NULL,
  name VARCHAR(50),
  email VARCHAR(50) NOT NULL,
  address VARCHAR(100),
  balance DECIMAL,
  CONSTRAINT pk_customer_detil PRIMARY KEY (id),
  CONSTRAINT fk_customer_detil FOREIGN KEY (id) REFERENCES customer(id)
);

CREATE TABLE IF NOT EXISTS item (
  id BIGINT NOT NULL,
  code VARCHAR(5) NOT NULL,
  name VARCHAR(255),
  price DECIMAL,
  stock int,
  CONSTRAINT pk_item PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS orders (
  transaction_code VARCHAR(20) NOT NULL,
  customer_id BIGINT NOT NULL,
  quantity int NOT NULL,
  created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  modified_at TIMESTAMP WITHOUT TIME ZONE,
  CONSTRAINT pk_order PRIMARY KEY (transaction_code),
  CONSTRAINT fk_customer_order FOREIGN KEY (customer_id) REFERENCES customer_detil(id)
);

CREATE TABLE IF NOT EXISTS orders_detil (
  transaction_code VARCHAR(20) NOT NULL,
  item_id BIGINT NOT NULL,
  qty int NOT NULL,
  created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  modified_at TIMESTAMP WITHOUT TIME ZONE,
  CONSTRAINT pk_order_detil PRIMARY KEY (transaction_code, item_id),
  CONSTRAINT fk_order_code FOREIGN KEY (transaction_code) REFERENCES orders(transaction_code),
  CONSTRAINT fk_item_order_detil FOREIGN KEY (item_id) REFERENCES item(id)
);
