INSERT INTO INVOICE 
    (ISSUE_DATE, RECEIVER_NUMBER, RECEIVER_NAME, RECEIVER_ADDRESS, 
     PAYMENT_METHOD, DELIVERY_METHOD, ORDER_STATUS, TOTAL, CUSTOMER_ID)
VALUES
    ('2024-11-01', '0987654321', 'Nguyen Van A', '123 Le Loi, HCM', 
     'Cash', 'Delivery', 'Processing', 1200000.00, 1),
    ('2024-11-15', '0912345678', 'Tran Thi B', '456 Tran Hung Dao, HN', 
     'Online Payment', 'At Store', 'Delivered', 850000.00, 2),
    ('2024-11-20', '0934567890', 'Le Van C', '789 Nguyen Hue, HCM', 
     'Cash', 'Delivery', 'Canceled', 500000.00, NULL);
