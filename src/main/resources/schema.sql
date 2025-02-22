CREATE TABLE producto(
barcode VARCHAR2(255) NOT NULL PRIMARY KEY,
item VARCHAR(255),
category VARCHAR2(255),
price NUMBER,
discount NUMBER,
available NUMBER
);


INSERT INTO producto(barcode,item,category,price,discount,available) VALUES ('740011755','BALL GOWN','Full Body Outfits',3548,7,1);
INSERT INTO producto(barcode,item,category,price,discount,available) VALUES ('74002423','shawl','Accesories',758,12,1);