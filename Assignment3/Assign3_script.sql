Begin
for c in (select table_name from user_tables) loop
execute immediate ('drop table '||c.table_name||' cascade constraints');
end loop;
End; 
/

create table Membership
(Mem_num char(3) Primary key,
 Mem_fname Varchar2(10) not null,
 Mem_lname Varchar2(10) not null,
 Mem_street Varchar2(25) not null,
 Mem_city Varchar2(10) not null,
 Mem_state Varchar2(3),
 Mem_zip Varchar2(5),
 Mem_balance number(10))
 
 
create table rental
(Rent_num char(4) primary key,
Rent_date date not null,
Mem_num char(3) not null,
constraint rental_Mem_num_fk foreign key (Mem_num) references Membership(Mem_num))


create table video
(Vid_num Char(5) primary key,
Vid_indate date not null,
Movie_num Char(4) not null);


create table Movie
(Movie_num Char(4) primary key,
Movie_title Varchar2(30) not null,
Movie_year Char(4) not null,
Movie_cost number(2, 2) not null,
Movie_genre Varchar2(10) not null,
Price_code char(1) not null)


create table Price
(Price_code char(1) primary key,
Price_description Varchar2(10) not null,
Price_rentfee number(1, 1) not null,
Price_dailyfee number(1) not null)


create table detailrental
(Rent_num char(4),
Vid_num char(5),
Detail_fee number(1, 1),
Detail_duedate date not null,
Detail_returndate date not null,
Detail_dailylatefee number(1) not null,
primary key(Rent_num, Vid_num),
foreign key (Rent_num) references Rental(Rent_num),
foreign key (Vid_num) references Video(Vid_num))


alter table Video
add constraint Video_Movie_num_fk foreign key (Movie_num) references Movie(Movie_num);


alter table Movie
add constraint Movie_Price_code_fk foreign key (Price_code) references Price(Price_code);


insert into MEMBERSHIP values('102', 'Tami', 'Dawson', '2632 Takli Circle', 'Norene', 'TN', '37136', '11');

insert into MEMBERSHIP values('103', 'Curt', 'Knight', '4025 Cornell Court', 'Flatgap', 'KY', '41219', '6');

insert into MEMBERSHIP values('104', 'Jamal', 'Melendez', '788 East 145th Avenue', 'Quebeck', 'TN', '38579', '0');

insert into MEMBERSHIP values('105', 'Iva', 'Mcclain', '6045 Musket Ball Circle', 'Summit', 'KY', '42783', '15');

insert into MEMBERSHIP values('106', 'Miranda', 'Parks', '4469 Maxwell Place', 'Germantown', 'TN', '38183', '0');

insert into MEMBERSHIP values('107', 'Rosario', 'Elliott', '7578 Danner Avenue', 'Columbia', 'TN', '38402', '5');

insert into MEMBERSHIP values('108', 'Mattie', 'Guy', '4390 Evergreen Street', 'Lily', 'KY', '40740', '0');

insert into PRICE values('1', 'Standard', '2', '1');

insert into PRICE values('2', 'New Release', '3.5', '3');

insert into PRICE values('3', 'Discount', '1.5', '1');

insert into PRICE values('4', 'Weekly Special', '1', '.5');

insert into MOVIE values('1234', 'The Cesar Family Christmas', '2007', '39.95', 'FAMILY', '2');

insert into MOVIE values('1235', 'Smokey Mountain Wildlife', '2004', '59.95', 'ACTION', '1');

insert into MOVIE values('1236', 'Richard Goodhope', '2008', '59.95', 'DRAMA', '2');

insert into MOVIE values('1237', 'Beatnik Fever', '2007', '29.95', 'COMEDY', '2');

insert into MOVIE values('1238', 'Constant Companion', '2008', '89.95', 'DRAMA', '2');

insert into MOVIE values('1239', 'Where Hope Dies', '1998', '25.49', 'DRAMA', '3');

insert into MOVIE values('1245', 'Time to Burn', '2005', '45.49', 'ACTION', '1');

insert into MOVIE values('1246', 'What He Doesn''t Know', '2006', '58.29', 'COMEDY', '1');

insert into VIDEO values('54321', '18-JUN-08', '1234');

insert into VIDEO values('54324', '18-JUN-08', '1234');

insert into VIDEO values('54325', '18-JUN-08', '1234');

insert into VIDEO values('34341', '22-JAN-07', '1235');


insert into VIDEO values('34342', '22-JAN-07', '1235');

insert into VIDEO values('34366', '02-MAR-09', '1236');

insert into VIDEO values('34367', '02-MAR-09', '1236');

insert into VIDEO values('34368', '02-MAR-09', '1236');

insert into VIDEO values('34369', '02-MAR-09', '1236');

insert into VIDEO values('44392', '21-OCT-08', '1237');

insert into RENTAL values('1001', '01-MAR-09', '103');

insert into RENTAL values('1002', '01-MAR-09', '105');

insert into RENTAL values('1003', '02-MAR-09', '102');

insert into RENTAL values('1004', '02-MAR-09', '107');

insert into RENTAL values('1005', '02-MAR-09', '108');

insert into DETAILRENTAL values('1001', '34342', '2', '04-MAR-09', '02-MAR-09', '1');

insert into DETAILRENTAL values('1001', '61353', '2', '04-MAR-09', '03-MAR-09', '1');

insert into DETAILRENTAL values('1002', '59237', '3.5', '04-MAR-09', '04-MAR-09', '3');

insert into DETAILRENTAL values('1003', '54325', '3.5', '06-MAR-09', '09-MAR-09', '3');

insert into DETAILRENTAL values('1003', '61369', '2', '06-MAR-09', '09-MAR-09', '1');

insert into DETAILRENTAL values('1003', '61388', '0', '06-MAR-09', '09-MAR-09', '1');

insert into DETAILRENTAL values('1004', '44392', '3.5', '05-MAR-09', '07-MAR-09', '3');

insert into DETAILRENTAL values('1004', '34367', '3.5', '05-MAR-09', '07-MAR-09', '3');

insert into DETAILRENTAL values('1004', '34341', '2', '07-MAR-09', '09-MAR-09', '1');

insert into DETAILRENTAL values('1004', '34342', '2', '07-MAR-09', '09-MAR-09', '1');

insert into DETAILRENTAL values('1005', '44397', '3.5', '05-MAR-09', '05-MAR-09', '3');
