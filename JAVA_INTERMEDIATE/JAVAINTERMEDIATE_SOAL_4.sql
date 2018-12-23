SELECT * FROM customers WHERE city = 'Irvine'

SELECT CONCAT (c.FirstName," ", c.LastName) NamaKaryawan, b.*
FROM orders a
LEFT JOIN customers b ON a.CustomerID = b.CustomerID
LEFT JOIN employees c ON a.EmployeeID = c.EmployeeID
WHERE c.FirstName = 'Adam' AND c.LastName = 'Barr'

SELECT d.CompanyName,c.*
FROM order_details a
LEFT JOIN orders b ON a.OrderID = b.OrderID
LEFT JOIN products c ON a.ProductID = c.ProductID
LEFT JOIN customers d ON b.CustomerID = d.customerID
WHERE d.CompanyName = 'Contoso, Ltd'

SELECT e.ShippingMethod, a.OrderID, c.*
FROM order_details a
LEFT JOIN orders b ON a.OrderID = b.OrderID
LEFT JOIN products c ON a.ProductID = c.ProductID
LEFT JOIN customers d ON b.CustomerID = d.customerID
LEFT JOIN shipping_methods e ON b.ShippingMethodID = e.ShippingMethodID
WHERE e.ShippingMethod = 'UPS Ground'

SELECT a.OrderID,a.OrderDate,b.TotByrBrg,(b.TotByrBrg+a.FreightCharge+a.Taxes) TotOrder
FROM orders a
LEFT JOIN (
SELECT a.OrderID,IF(a.Discount=0,(a.Quantity * a.UnitPrice),(a.Quantity * a.UnitPrice)-((a.Quantity * a.UnitPrice) * a.Discount/100)) TotByrBrg
FROM order_details a) b ON a.OrderID = b.OrderID
ORDER BY a.OrderDate
