/*
MySQL Data Transfer
Source Host: localhost
Source Database: testjava
Target Host: localhost
Target Database: testjava
Date: 12/21/2018 3:10:47 PM
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for customers
-- ----------------------------
DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `CustomerID` decimal(10,0) NOT NULL,
  `CompanyName` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `FirstName` varchar(30) COLLATE latin1_general_ci DEFAULT NULL,
  `LastName` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `BillingAddress` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `City` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `StateOrProvince` varchar(20) COLLATE latin1_general_ci DEFAULT NULL,
  `ZIPCode` varchar(20) COLLATE latin1_general_ci DEFAULT NULL,
  `Email` varchar(75) COLLATE latin1_general_ci DEFAULT NULL,
  `CompanyWebsite` varchar(200) COLLATE latin1_general_ci DEFAULT NULL,
  `PhoneNumber` varchar(30) COLLATE latin1_general_ci DEFAULT '',
  `FaxNumber` varchar(30) COLLATE latin1_general_ci DEFAULT NULL,
  `ShipAddress` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `ShipCity` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `ShipStateOrProvince` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `ShipZIPCode` varchar(20) COLLATE latin1_general_ci DEFAULT NULL,
  `ShipPhoneNumber` varchar(30) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`CustomerID`),
  UNIQUE KEY `CUSTID` (`CustomerID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- ----------------------------
-- Table structure for employees
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `EmployeeID` decimal(10,0) NOT NULL,
  `FirstName` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `LastName` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `Title` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `WorkPhone` varchar(30) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`EmployeeID`),
  UNIQUE KEY `EMPID` (`EmployeeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- ----------------------------
-- Table structure for order_details
-- ----------------------------
DROP TABLE IF EXISTS `order_details`;
CREATE TABLE `order_details` (
  `OrderDetailID` decimal(10,0) NOT NULL,
  `OrderID` decimal(10,0) NOT NULL,
  `ProductID` decimal(10,0) NOT NULL,
  `Quantity` decimal(10,0) DEFAULT NULL,
  `UnitPrice` decimal(10,2) DEFAULT NULL,
  `Discount` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`OrderDetailID`,`OrderID`,`ProductID`),
  UNIQUE KEY `ORDRDETAILID` (`OrderDetailID`),
  KEY `FK_ORDID` (`OrderID`),
  KEY `FK_PRODID` (`ProductID`),
  CONSTRAINT `FK_ORDID` FOREIGN KEY (`OrderID`) REFERENCES `orders` (`OrderID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_PRODID` FOREIGN KEY (`ProductID`) REFERENCES `products` (`ProductID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `OrderID` decimal(10,0) NOT NULL,
  `CustomerID` decimal(10,0) NOT NULL,
  `EmployeeID` decimal(10,0) NOT NULL,
  `OrderDate` date NOT NULL,
  `PurchaseOrderNumber` varchar(30) COLLATE latin1_general_ci NOT NULL,
  `ShipDate` date DEFAULT NULL,
  `ShippingMethodID` decimal(10,0) NOT NULL,
  `FreightCharge` decimal(10,2) DEFAULT NULL,
  `Taxes` decimal(10,2) DEFAULT NULL,
  `PaymentReceived` char(1) COLLATE latin1_general_ci DEFAULT NULL,
  `Comment` varchar(150) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`OrderID`),
  KEY `FK_CUSTID` (`CustomerID`),
  KEY `FK_EMPID` (`EmployeeID`),
  KEY `FK_SHIPID` (`ShippingMethodID`),
  CONSTRAINT `FK_CUSTID` FOREIGN KEY (`CustomerID`) REFERENCES `customers` (`CustomerID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_EMPID` FOREIGN KEY (`EmployeeID`) REFERENCES `employees` (`EmployeeID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_SHIPID` FOREIGN KEY (`ShippingMethodID`) REFERENCES `shipping_methods` (`ShippingMethodID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `ProductID` decimal(10,0) NOT NULL,
  `ProductName` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `UnitPrice` decimal(10,2) DEFAULT NULL,
  `InStock` char(1) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`ProductID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- ----------------------------
-- Table structure for shipping_methods
-- ----------------------------
DROP TABLE IF EXISTS `shipping_methods`;
CREATE TABLE `shipping_methods` (
  `ShippingMethodID` decimal(10,0) NOT NULL,
  `ShippingMethod` varchar(20) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`ShippingMethodID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- ----------------------------
-- Records 
-- ----------------------------
