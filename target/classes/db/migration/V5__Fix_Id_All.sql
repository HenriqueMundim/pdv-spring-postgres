ALTER TABLE orders DROP CONSTRAINT orders_user_id_fkey;
ALTER TABLE order_item DROP CONSTRAINT order_item_order_id_fkey;
ALTER TABLE order_item DROP CONSTRAINT order_item_product_id_fkey;

ALTER TABLE orders DROP COLUMN user_id;
ALTER TABLE order_item DROP COLUMN order_id;
ALTER TABLE order_item DROP COLUMN product_id;

ALTER TABLE users DROP COLUMN id;
ALTER TABLE users ADD COLUMN id UUID PRIMARY KEY DEFAULT gen_random_uuid();

ALTER TABLE products DROP COLUMN id;
ALTER TABLE products ADD COLUMN id UUID PRIMARY KEY DEFAULT gen_random_uuid();

ALTER TABLE orders DROP COLUMN id;
ALTER TABLE orders ADD COLUMN id UUID PRIMARY KEY DEFAULT gen_random_uuid();

ALTER TABLE orders ADD COLUMN user_id UUID;
ALTER TABLE orders ADD CONSTRAINT fk_user_1 FOREIGN KEY (user_id) REFERENCES users(id);

ALTER TABLE order_item ADD COLUMN order_id UUID;
ALTER TABLE order_item ADD CONSTRAINT fk_order_1 FOREIGN KEY (order_id) REFERENCES orders(id);

ALTER TABLE order_item ADD COLUMN product_id UUID;
ALTER TABLE order_item ADD CONSTRAINT fk_product_1 FOREIGN KEY (product_id) REFERENCES products(id);


