-- monthly revenue:
CREATE OR REPLACE FUNCTION get_monthly_revenue()
RETURNS TABLE(month text, revenue numeric) AS $$
BEGIN
    RETURN QUERY
    SELECT
        TO_CHAR(purchasedate, 'YYYY-MM') AS month,
        SUM(totalprice) AS revenue
    FROM
        orders
    GROUP BY
        TO_CHAR(purchasedate, 'YYYY-MM')
    ORDER BY
        month;
END;
$$ LANGUAGE plpgsql;


-- customer signup

CREATE OR REPLACE FUNCTION customer_signup(eusername TEXT, epassword TEXT, equestion TEXT, eanswer TEXT, ename TEXT, eemail TEXT, eaddress TEXT)
RETURNS BOOLEAN AS $$
DECLARE
    count_customerusername INT;
BEGIN
    SELECT COUNT(*) INTO count_customerusername FROM customer WHERE customerusername = eusername;
    IF count_customerusername > 0 THEN
        RETURN FALSE;
    END IF;

    INSERT INTO customer(customerusername, customerpassword, question, answer, customername, phonenumber, email, address) VALUES (eusername, epassword, equestion, eanswer , ename , eemail , eaddress );
    RETURN TRUE;
END;
$$ LANGUAGE plpgsql;

-- admin signup
CREATE OR REPLACE FUNCTION admin_signup(eusername TEXT, epassword TEXT, equestion TEXT, eanswer TEXT)
RETURNS BOOLEAN AS $$
DECLARE
    count_adminusername INT;
BEGIN
    SELECT COUNT(*) INTO count_adminusername FROM admin WHERE adminusername = eusername;
    IF count_adminusername > 0 THEN
        RETURN FALSE;
    END IF;

    INSERT INTO admin(adminusername, adminpassword, question, answer) VALUES (eusername, epassword, equestion, eanswer);
    RETURN TRUE;
END;
$$ LANGUAGE plpgsql;


-- customer login
CREATE OR REPLACE FUNCTION admin_login(eusername TEXT, epassword TEXT)
RETURNS BOOLEAN AS $$
DECLARE
    count_admin INT;
BEGIN
    SELECT COUNT(*) INTO count_admin FROM admin 
    WHERE adminusername = eusername AND adminpassword = epassword ;
    IF count_admin > 0 THEN
        RETURN TRUE;
    END IF;
    RETURN FALSE;
END;
$$ LANGUAGE plpgsql;

-- admin login
CREATE OR REPLACE FUNCTION admin_login(eusername TEXT, epassword TEXT)
RETURNS BOOLEAN AS $$
DECLARE
    count_admin INT;
BEGIN
    SELECT COUNT(*) INTO count_admin FROM admin 
    WHERE adminusername = eusername AND adminpassword = epassword ;
    IF count_admin > 0 THEN
        RETURN TRUE;
    END IF;
    RETURN FALSE;
END;
$$ LANGUAGE plpgsql;



-- findByCategory
CREATE OR REPLACE FUNCTION find_by_category(ecategory TEXT)
RETURNS TABLE( 
productid  INT,
type VARCHAR(20), 
name VARCHAR(255), 
image VARCHAR(500), 
distributor VARCHAR(255), 
description TEXT, 
addeddate DATE, 
quantity INT, 
importprice NUMERIC, 
sellprice NUMERIC, 
age INT,  
isbn VARCHAR(255), 
author VARCHAR(255), 
genre VARCHAR(255), 
publishdate DATE, 
categoryid INT
) AS $$
BEGIN
    RETURN QUERY
    SELECT p.* FROM product p
    JOIN category c ON p.categoryid = c.categoryid
    WHERE c.categoryname = ecategory;
END;
$$ LANGUAGE plpgsql;




-- tự động tính amount, purchaseprice cho orders, orderlines

--on update orders: find all orderlines, calculate total_price
--on update orderlines: 

--tự động cập nhật số lượng sản phẩm sau khi thêm orderline

-- cam mua khi quantityMuonMua< product.quantity

-- create orderline



-- create orders:
CREATE OR REPLACE FUNCTION create_order(ecustomerid BIGINT)
RETURNS BIGINT AS $$
DECLARE
    eorderid BIGINT;
BEGIN
    INSERT INTO orders(customerid) 
    VALUES(ecustomerid)
    RETURNING orderid INTO eorderid;
    RETURN eorderid;
END;
$$ LANGUAGE plpgsql;



-- create orderline;
CREATE OR REPLACE FUNCTION create_orderline(eorderid BIGINT, eproductid BIGINT, equantity INT)
RETURNS VOID AS $$
DECLARE esellprice NUMERIC(15,2);
BEGIN
    SELECT sellprice INTO esellprice
    FROM product 
    WHERE productid = eproductid;

    INSERT INTO orderline(orderid, productid, quantity, pricepurchase)
    VALUES (eorderid, eproductid, equantity, ROUND(equantity*esellprice::NUMERIC, 2));
END;
$$ LANGUAGE plpgsql;




-- them phan tru di voucher, tìm kiếm voucher trong voucherorder sau đó thì trừ đi discount tương ứng
--trigger function calculate totalprice
CREATE OR REPLACE FUNCTION calculate_order_total()
RETURNS TRIGGER AS $$
DECLARE
    ctotalprice NUMERIC(15, 2);
BEGIN
    SELECT SUM(ol.pricepurchase*ol.quantity)
    INTO ctotalprice
    FROM orderline ol
    WHERE ol.orderid = NEW.orderid;

    UPDATE orders o
    SET totalprice = ctotalprice
    WHERE o.orderid = NEW.orderid;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;





--trigger
CREATE OR REPLACE TRIGGER trigger_calculate_order_total
AFTER INSERT OR UPDATE OR DELETE ON orderline
FOR EACH ROW
EXECUTE FUNCTION calculate_order_total();

