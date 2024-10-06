package edu.sunmoon.frame;

public class SQL {
    // address
    public static final String INSERT_ADDRESS = "INSERT INTO address (customer_id, type, name, phone, address1, address2, zip_code, is_default) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SELECT_ADDRESS = "SELECT * FROM address";
    public static final String SELECT_ADDRESS_BY_ID = "SELECT * FROM address WHERE address_id = ?";
    public static final String SELECT_ADDRESS_BY_CUSTOMER_ID = "SELECT * FROM address WHERE customer_id = ?";
    public static final String UPDATE_ADDRESS = "UPDATE address SET type = ?, name = ?, phone = ?, address1 = ?, address2 = ?, zip_code = ?, is_default = ? WHERE address_id = ?";
    public static final String DELETE_ADDRESS = "DELETE FROM address WHERE address_id = ?";

    // cart
    public static final String INSERT_CART = "INSERT INTO cart (customer_id, product_id, quantity, total_price, created_at) SELECT ?, ?, ?, (product.price * ?), NOW() FROM product WHERE product.product_id = ?";
    public static final String SELECT_CART = "SELECT * FROM cart";
    public static final String SELECT_CART_BY_ID = "SELECT * FROM cart WHERE cart_id = ?";
    public static final String SELECT_CART_BY_CUSTOMER_ID = "SELECT * FROM cart WHERE customer_id = ?";
    public static final String SELECT_CART_BY_PRODUCT_ID = "SELECT * FROM cart WHERE product_id = ?";
    public static final String UPDATE_CART = "UPDATE cart JOIN product ON cart.product_id = product.product_id SET cart.quantity = ?, cart.total_price = (product.price * ?) WHERE cart.cart_id = ?";
    public static final String DELETE_CART = "DELETE FROM cart WHERE cart_id = ?";

    // category
    public static final String INSERT_CATEGORY = "INSERT INTO category (category_id, parents_id, name) VALUES (?, ?, ?)";
    public static final String SELECT_CATEGORY = "SELECT * FROM category";
    public static final String SELECT_CATEGORY_BY_ID = "SELECT * FROM category WHERE category_id = ?";
    public static final String SELECT_CATEGORY_BY_PARENTS_ID = "SELECT * FROM category WHERE parents_id = ?";
    public static final String SELECT_CATEGORY_BY_NAME = "SELECT * FROM category WHERE name = ?";
    public static final String UPDATE_CATEGORY = "UPDATE category SET parents_id = ?, name = ? WHERE category_id = ?";
    public static final String DELETE_CATEGORY = "DELETE FROM category WHERE category_id = ?";

    // coupon
    public static final String INSERT_COUPON = "INSERT INTO coupon (name, code, type, discount, min_order_price, max_discount_price, start_date, end_date, is_active, created_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";
    public static final String SELECT_COUPON = "SELECT * FROM coupon";
    public static final String SELECT_COUPON_BY_CODE = "SELECT * FROM coupon WHERE code = ?";
    public static final String SELECT_COUPON_BY_NAME = "SELECT * FROM coupon WHERE name = ?";
    public static final String UPDATE_COUPON = "UPDATE coupon SET name = ?, code = ?, type = ?, discount = ?, min_order_price = ?, max_discount_price = ?, start_date = ?, end_date = ? WHERE code = ?";
    public static final String DELETE_COUPON = "UPDATE coupon SET is_active = false WHERE code = ?";

    // coupon_box
    public static final String INSERT_COUPON_BOX = "INSERT INTO coupon_box (customer_id, coupon_id, is_used) VALUES (?, ?, ?)";
    public static final String SELECT_COUPON_BOX = "SELECT * FROM coupon_box";
    public static final String SELECT_COUPON_BOX_BY_ID = "SELECT * FROM coupon_box WHERE coupon_box_id = ?";
    public static final String SELECT_COUPON_BOX_BY_CUSTOMER_ID = "SELECT * FROM coupon_box WHERE customer_id = ?";
    public static final String SELECT_COUPON_BOX_BY_COUPON_ID = "SELECT * FROM coupon_box WHERE coupon_id = ?";
    public static final String UPDATE_COUPON_BOX = "UPDATE coupon_box SET is_used = ? WHERE coupon_box_id = ?";
    public static final String DELETE_COUPON_BOX = "DELETE FROM coupon_box WHERE coupon_box_id = ?";

    // customer
    public static final String INSERT_CUSTOMER = "INSERT INTO customer (customer_id, name, email, password, phone, level, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, NOW(), NOW())";
    public static final String SELECT_CUSTOMER = "SELECT * FROM customer";
    public static final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM customer WHERE customer_id = ?";
    public static final String SELECT_CUSTOMER_BY_NAME = "SELECT * FROM customer WHERE name = ?";
    public static final String UPDATE_CUSTOMER = "UPDATE customer SET email = ?, password = ?, phone = ?, level = ?, updated_at = NOW() WHERE customer_id = ?";
    public static final String DELETE_CUSTOMER = "UPDATE customer SET status = 0, updated_at = NOW() WHERE customer_id = ?";

    // orders
    public static final String INSERT_ORDER = "INSERT INTO orders (customer_id, name, phone, address1, address2, zip_code, total_price, status, created_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, NOW())";
    public static final String SELECT_ORDER = "SELECT * FROM orders";
    public static final String SELECT_ORDER_BY_ID = "SELECT * FROM orders WHERE order_id = ?";
    public static final String SELECT_ORDER_BY_CUSTOMER_ID = "SELECT * FROM orders WHERE customer_id = ?";
    public static final String UPDATE_ORDER = "UPDATE orders SET name = ?, phone = ?, address1 = ?, address2 = ?, zip_code = ?, status = ? WHERE order_id = ?";
    public static final String DELETE_ORDER = "UPDATE orders SET status = '삭제' WHERE order_id = ?";

    // order_detail
    public static final String INSERT_ORDER_DETAIL = "INSERT INTO order_detail (order_id, product_id, product_price, total_discount_price, quantity) VALUES (?, ?, ?, ?, ?)";
    public static final String SELECT_ORDER_DETAIL = "SELECT * FROM order_detail";
    public static final String SELECT_ORDER_DETAIL_BY_ID = "SELECT * FROM order_detail WHERE order_detail_id = ?";
    public static final String SELECT_ORDER_DETAIL_BY_ORDER_ID = "SELECT * FROM order_detail WHERE order_id = ?";
    public static final String UPDATE_ORDER_DETAIL = "UPDATE order_detail SET product_price = ?, total_discount_price = ?, quantity = ? WHERE order_detail_id = ?";
    public static final String DELETE_ORDER_DETAIL = "DELETE FROM order_detail WHERE order_detail_id = ?";

    // payment
    public static final String INSERT_PAYMENT = "INSERT INTO payment (order_id, payment_method, price, status, created_at) SELECT ?, ?, orders.total_price, ?, NOW() FROM orders WHERE orders.order_id = ?";
    public static final String SELECT_PAYMENT = "SELECT * FROM payment";
    public static final String SELECT_PAYMENT_BY_ID = "SELECT * FROM payment WHERE payment_id = ?";
    public static final String SELECT_PAYMENT_BY_ORDER_ID = "SELECT * FROM payment WHERE order_id = ?";
    public static final String SELECT_PAYMENT_BY_PAYMENT_METHOD = "SELECT * FROM payment WHERE payment_method = ?";
    public static final String UPDATE_PAYMENT = "UPDATE payment SET status = ? WHERE payment_id = ?";
    public static final String DELETE_PAYMENT = "DELETE FROM payment WHERE payment_id = ?";

    // product
    public static final String INSERT_PRODUCT = "INSERT INTO product (category_id, name, description, price, stock_quantity, is_selling, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, NOW(), NOW())";
    public static final String SELECT_PRODUCT = "SELECT * FROM product";
    public static final String SELECT_PRODUCT_BY_ID = "SELECT * FROM product WHERE product_id = ?";
    public static final String SELECT_PRODUCT_BY_NAME = "SELECT * FROM product WHERE name LIKE CONCAT('%', ?, '%')";
    public static final String SELECT_PRODUCT_BY_CATEGORY_ID = "SELECT * FROM product WHERE category_id = ?";
    public static final String UPDATE_PRODUCT = "UPDATE product SET category_id = ?, name = ?, description = ?, price = ?, stock_quantity = ?, is_selling = ?, updated_at = NOW() WHERE product_id = ?";
    public static final String DELETE_PRODUCT = "UPDATE product SET is_selling = false, updated_at = NOW() WHERE product_id = ?";

    // review
    public static final String INSERT_REVIEW = "INSERT INTO review (product_id, customer_id, rating, content, created_at) VALUES (?, ?, ?, ?, NOW())";
    public static final String SELECT_REVIEW = "SELECT * FROM review";
    public static final String SELECT_REVIEW_BY_ID = "SELECT * FROM review WHERE review_id = ?";
    public static final String SELECT_REVIEW_BY_PRODUCT_ID = "SELECT * FROM review WHERE product_id = ?";
    public static final String SELECT_REVIEW_BY_CUSTOMER_ID = "SELECT * FROM review WHERE customer_id = ?";
    public static final String UPDATE_REVIEW = "UPDATE review SET rating = ?, content = ? WHERE review_id = ?";
    public static final String DELETE_REVIEW = "DELETE FROM review WHERE review_id = ?";

    // used_coupon
    public static final String INSERT_USED_COUPON = "INSERT INTO used_coupons (order_detail_id, coupon_id, coupon_discount_price, created_at) VALUES (?, ?, ?, NOW())";
    public static final String SELECT_USED_COUPON = "SELECT * FROM used_coupons";
    public static final String SELECT_USED_COUPON_BY_ID = "SELECT * FROM used_coupons WHERE used_coupon_id = ?";
    public static final String SELECT_USED_COUPON_BY_ORDER_DETAIL_ID = "SELECT * FROM used_coupons WHERE order_detail_id = ?";
    public static final String SELECT_USED_COUPON_BY_COUPON_ID = "SELECT * FROM used_coupons WHERE coupon_id = ?";
    public static final String UPDATE_USED_COUPON = "UPDATE used_coupons SET coupon_id = ?, coupon_discount_price = ? WHERE used_coupon_id = ?";
    public static final String DELETE_USED_COUPON = "DELETE FROM used_coupons WHERE used_coupon_id = ?";
}
