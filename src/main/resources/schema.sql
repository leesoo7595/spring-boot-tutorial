DROP TABLE Customers IF EXISTS;

CREATE TABLE Customers (
    ID INTEGER IDENTITY PRIMARY KEY ,
    CustomerName varchar(255),
    PostalCode varchar(255),
    Address varchar(255),
    City varchar(255)
);