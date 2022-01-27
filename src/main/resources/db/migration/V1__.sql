CREATE SEQUENCE  IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE customer (
  id BIGINT NOT NULL,
  name VARCHAR(255),
  email VARCHAR(255),
  address VARCHAR(255),
  balance DECIMAL,
  CONSTRAINT pk_customer PRIMARY KEY (id)
);

CREATE TABLE item (
  id BIGINT NOT NULL,
  name VARCHAR(255),
  price DECIMAL,
  CONSTRAINT pk_item PRIMARY KEY (id)
);

CREATE TABLE "order" (
  id BIGINT NOT NULL,
  customer_id BIGINT,
  create_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  update_at TIMESTAMP WITHOUT TIME ZONE,
  CONSTRAINT pk_order PRIMARY KEY (id)
);

CREATE TABLE order_items (
  item_list_id BIGINT NOT NULL,
  order_list_id BIGINT NOT NULL,
  CONSTRAINT pk_order_items PRIMARY KEY (item_list_id, order_list_id)
);

ALTER TABLE "order" ADD CONSTRAINT FK_ORDER_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (id);

ALTER TABLE order_items ADD CONSTRAINT fk_ordite_on_item FOREIGN KEY (item_list_id) REFERENCES item (id);

ALTER TABLE order_items ADD CONSTRAINT fk_ordite_on_order FOREIGN KEY (order_list_id) REFERENCES "order" (id);