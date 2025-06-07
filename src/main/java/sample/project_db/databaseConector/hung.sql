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

-- signup
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
-- admin login
CREATE OR REPLACE FUNCTION admin_login(eusername TEXT, epassword TEXT)
RETURNS BOOLEAN AS $$
DECLARE
    count_admin INT;
BEGIN
    SELECT COUNT(*) INTO count_admin FROM admin 
    WHERE adminusername = eusername AND adminpassword = epassword;
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


-- tự động tính amount, purchaseprice cho order, orderlines

--tự động cập nhật số lượng sản phẩm sau khi thêm orderline

-- cam mua khi quantityMuonMua< product.quantity