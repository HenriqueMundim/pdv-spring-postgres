CREATE TABLE IF NOT EXISTS order_item (
    quantity integer NOT NULL,
    product_id character varying(255) NOT NULL,
    order_id character varying(255) NOT NULL,
    FOREIGN KEY(product_id) REFERENCES products(id),
    FOREIGN KEY(order_id) REFERENCES orders(id)
);