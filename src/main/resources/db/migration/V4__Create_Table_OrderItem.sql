CREATE TABLE IF NOT EXISTS order_item (
    quantity integer NOT NULL,
    product_id UUID NOT NULL,
    order_id UUID NOT NULL,
    FOREIGN KEY(product_id) REFERENCES products(id),
    FOREIGN KEY(order_id) REFERENCES orders(id)
);