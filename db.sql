create table customer (
   accountid INT NOT NULL AUTO_INCREMENT,
   first_name VARCHAR(50) NOT NULL,
   last_name VARCHAR(50) NOT NULL,
   email VARCHAR(50) ,
   phone_number VARCHAR(50),
   PRIMARY KEY (accountid)
);

INSERT INTO customer (accountid, first_name, last_name, email, phone_number)
   VALUES (1,'Kelly','Liu','kelly.liu@gmail.com',1234567890 ),
           (2,'Kate','Yan','Kate.Yan@gmail.com',1233211231),
           (3,'Jerry','Water','Jerry.Water@gmail.com', 2342343451);
