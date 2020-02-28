SQL> create table Department
  2  (Dept_code char(10) PRimary key,
  3  dept_name varchar2(20) not null,
  4  location varchar2(20) not null);

Table created.

SQL> create table Employee
  2  (employee_ID_num char(10) Primary key,
  3  employee_fname varchar2(15) not null,
  4  employee_lname varchar2(15) not null,
  5  employee_email varchar2(30),
  6  home_address varchar2(30) not null);

Table created.

SQL> create table project
  2  (project_code char(10) primary key,
  3  project_name varchar2(20) not null);

Table created.

SQL> create table division
  2  (div_code char(10) primary key,
  3  div_name varchar2(20) not null);

Table created.

SQL> create table assigned_project
  2  (project_code char(10),
  3  employee_ID_num char(10),
  4  due_date date,
  5  num_hours char(8),
  6  primary key (project_code, employee_ID_number),
  7  foreign key (project_code) references project(project_code),
  8  foreign key (employee_ID_number) references employee(employee_ID_num));
primary key (project_code, employee_ID_number),
                           *
ERROR at line 6:
ORA-00904: "EMPLOYEE_ID_NUMBER": invalid identifier 


SQL> ed
Wrote file afiedt.buf

  1  create table assigned_project
  2  (project_code char(10),
  3  employee_ID_num char(10),
  4  due_date date,
  5  num_hours char(8),
  6  primary key (project_code, employee_ID_num),
  7  foreign key (project_code) references project(project_code),
  8* foreign key (employee_ID_number) references employee(employee_ID_num))
SQL> /
foreign key (employee_ID_number) references employee(employee_ID_num))
             *
ERROR at line 8:
ORA-00904: "EMPLOYEE_ID_NUMBER": invalid identifier 


SQL> ed
Wrote file afiedt.buf

  1  create table assigned_project
  2  (project_code char(10),
  3  employee_ID_num char(10),
  4  due_date date,
  5  num_hours char(8),
  6  primary key (project_code, employee_ID_num),
  7  foreign key (project_code) references project(project_code),
  8* foreign key (employee_ID_num) references employee(employee_ID_num))
SQL> /

Table created.

SQL> alter table employee
  2  add constraint employee_dept_code_fk foreign key (dept_code) references department(dept_code);
add constraint employee_dept_code_fk foreign key (dept_code) references department(dept_code)
                                                  *
ERROR at line 2:
ORA-00904: "DEPT_CODE": invalid identifier 


SQL> ed
Wrote file afiedt.buf

  1  alter table employee
  2* add constraint employee_Dept_code_fk foreign key (Dept_code) references Department(Dept_code)
SQL> /
add constraint employee_Dept_code_fk foreign key (Dept_code) references Department(Dept_code)
                                                  *
ERROR at line 2:
ORA-00904: "DEPT_CODE": invalid identifier 


SQL> ed
Wrote file afiedt.buf

  1  alter table employee
  2* add constraint employee_Dept_code_fk foreign key (Dept_code) references Department(Dept_code)
SQL> /
add constraint employee_Dept_code_fk foreign key (Dept_code) references Department(Dept_code)
                                                  *
ERROR at line 2:
ORA-00904: "DEPT_CODE": invalid identifier 


SQL> alter table employee
  2  add Dept_Code char(10) constraint employee_Dept_Code_FK foreign key (Dept_Code) references Department(Dept_code);
add Dept_Code char(10) constraint employee_Dept_Code_FK foreign key (Dept_Code) references Department(Dept_code)
                       *
ERROR at line 2:
ORA-02253: constraint specification not allowed here 


SQL> alter table employee
  2  add Dept_Code char(10);

Table altered.

SQL> alter table employee
  2  add constraint employee_dept_code_fk foreign key (dept_code) references department(dept_code);

Table altered.

SQL> alter table department
  2  add Manager_ID char(10);

Table altered.

SQL> alter table department
  2  add constraint department_Manager_ID_fck ;
add constraint department_Manager_ID_fck 
                                        *
ERROR at line 2:
ORA-00904: : invalid identifier 


SQL> alter table department
  2  add constraint department_Manager_ID_fk foreign key (Manager_ID) references employee(Manager_ID);
add constraint department_Manager_ID_fk foreign key (Manager_ID) references employee(Manager_ID)
                                                                                     *
ERROR at line 2:
ORA-00904: "MANAGER_ID": invalid identifier 


SQL> alter table department
  2  add constraint department_Manager_ID_fk foreign key (Manager_ID) references employee(Employee_ID);
add constraint department_Manager_ID_fk foreign key (Manager_ID) references employee(Employee_ID)
                                                                                     *
ERROR at line 2:
ORA-00904: "EMPLOYEE_ID": invalid identifier 


SQL> alter table department
  2  add constraint department_Manager_ID_fk foreign key (Employee_ID) references employee(Employee_ID);
add constraint department_Manager_ID_fk foreign key (Employee_ID) references employee(Employee_ID)
                                                     *
ERROR at line 2:
ORA-00904: "EMPLOYEE_ID": invalid identifier 


SQL> ed
Wrote file afiedt.buf

  1  alter table department
  2* add constraint department_Manager_ID_fk foreign key (Manager_ID) references employee(employee_ID)
SQL> /
add constraint department_Manager_ID_fk foreign key (Manager_ID) references employee(employee_ID)
                                                                                     *
ERROR at line 2:
ORA-00904: "EMPLOYEE_ID": invalid identifier 


SQL> ed
Wrote file afiedt.buf

  1  alter table department
  2* add constraint department_Manager_ID_fk foreign key (Manager_ID) references employee(employee_ID_Number)
SQL> /
add constraint department_Manager_ID_fk foreign key (Manager_ID) references employee(employee_ID_Number)
                                                                                     *
ERROR at line 2:
ORA-00904: "EMPLOYEE_ID_NUMBER": invalid identifier 


SQL> ed
Wrote file afiedt.buf

  1  alter table department
  2* add constraint department_Manager_ID_fk foreign key (Manager_ID) references employee(employee_ID_Num)
SQL> /

Table altered.

SQL> alter table department
  2  add div_code char(10);

Table altered.

SQL> alter table department
  2  add constraint department_div_code_fk foreign key (div_code) references division(div_code);

Table altered.

SQL> alter table division
  2  add employee_ID_num char(10);

Table altered.

SQL> alter table division
  2  add constraint division_employee_ID_num_fk foreign key (employee_ID_num) references(employee_ID_num);
add constraint division_employee_ID_num_fk foreign key (employee_ID_num) references(employee_ID_num)
                                                                                   *
ERROR at line 2:
ORA-00903: invalid table name 


SQL> ed
Wrote file afiedt.buf

  1  alter table division
  2* add constraint division_employee_ID_num_fk foreign key (employee_ID_num) references division(employee_ID_num)
SQL> /
add constraint division_employee_ID_num_fk foreign key (employee_ID_num) references division(employee_ID_num)
                                                                                             *
ERROR at line 2:
ORA-02270: no matching unique or primary key for this column-list 


SQL> ed
Wrote file afiedt.buf

  1  alter table division
  2* add constraint division_employee_ID_num_fk foreign key (employee_ID_num) references employee(employee_ID_num)
SQL> /

Table altered.

SQL> alter table employee
  2  add constraint employee_dept_code_FK foreign key (dept_code) references department(dept_code);
add constraint employee_dept_code_FK foreign key (dept_code) references department(dept_code)
                                     *
ERROR at line 2:
ORA-02275: such a referential constraint already exists in the table 


SQL> spool off
