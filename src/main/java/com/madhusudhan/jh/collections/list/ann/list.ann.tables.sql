CREATE TABLE showroom_list_ann
(showroom_id INT(10) NOT NULL AUTO_INCREMENT,
manager VARCHAR(255) DEFAULT NULL,
location VARCHAR(255) DEFAULT NULL,
CONSTRAINT pk_showroom_id PRIMARY KEY (showroom_id));

CREATE TABLE car_list_ann
(car_id INT(11) NOT NULL AUTO_INCREMENT,
name VARCHAR(255) DEFAULT NULL,
color VARCHAR(255) DEFAULT NULL ,
showroom_id INT(10) DEFAULT NULL,
CONSTRAINT pk_car_id PRIMARY KEY (car_id),
CONSTRAINT fk_showroom_id FOREIGN KEY (showroom_id)
REFERENCES showroom_list_ann (showroom_id));