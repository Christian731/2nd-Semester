SQL> create table Department
  2  (Dept_code CHAR(10) PRIMARY KEY,
  3  Dept_Name VARCHAR2(20),
  4  Location VARCHAR2(30),
  5  ;

*
ERROR at line 5:
ORA-00904: : invalid identifier 


SQL> ed
Wrote file afiedt.buf

  1  create table Department
  2  (Dept_code CHAR(10) PRIMARY KEY,
  3  Dept_Name VARCHAR2(20),
  4* Location VARCHAR2(30))
  5  /

Table created.

SQL> create table Employee
  2  (Employee_ID_Number CHAR(10) Primary Key,
  3  Employee_fname,
  4  Employee_lname VARCHAR2(10),
  5  Employee_email VARCHAR2(30),
  6  Home_Address VARCHAR2(30));
Employee_fname,
*
ERROR at line 3:
ORA-02263: need to specify the datatype for this column 


SQL> ed
Wrote file afiedt.buf

  1  create table Employee
  2  (Employee_ID_Number CHAR(10) Primary Key,
  3  Employee_fname VARCHAR2(15),
  4  Employee_lname VARCHAR2(15),
  5  Employee_email VARCHAR2(30),
  6* Home_Address VARCHAR2(30))
SQL> /

Table created.

SQL> Create table Division
  2  (Div_code CHAR(10) PRimary key,
  3  Div_name VARCHAR2(20));

Table created.

SQL> create table Project
  2  (project_code CHAR(10) primary key,
  3  project_name VARCHAR2(20));

Table created.

SQL> create table Assigned_Project
  2  (project_code CHAR(10) primary key);

Table created.

SQL> alter table Assigned_Project
  2  (add employee_id_number Char(10) primary key,
  3  );
(add employee_id_number Char(10) primary key,
*
ERROR at line 2:
ORA-01735: invalid ALTER TABLE option 


SQL> ed
Wrote file afiedt.buf

  1  alter table Assigned_Project
  2* add employee_id_number Char(10) primary key,
  3  /
add employee_id_number Char(10) primary key,
                                           *
ERROR at line 2:
ORA-01735: invalid ALTER TABLE option 


SQL> spool off
