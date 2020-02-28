Begin
for c in (select table_name from user_tables) loop
execute immediate ('drop table '||c.table_name||' cascade constraints');
end loop;
End; 
/

create table Department
(Dept_code char(10) PRimary key,
 dept_name varchar2(20) not null,
 Manager_ID char(10) not null,
 div_code char(10),
 location varchar2(20) not null);

create table Employee
(employee_ID_num char(10) Primary key,
 employee_fname varchar2(15) not null,
 employee_lname varchar2(15) not null,
 employee_email varchar2(30),
 Dept_Code char(10),
 home_address varchar2(30) not null,
 constraint employee_dept_code_fk foreign key (dept_code) references department(dept_code));

create table project
(project_code char(10) primary key,
 project_name varchar2(20) not null);

create table division
(div_code char(10) primary key,
 employee_ID_num char(10),
 div_name varchar2(20) not null, 
 constraint division_employee_ID_num_fk foreign key (employee_ID_num) references employee(employee_ID_num));

create table assigned_project
(project_code char(10),
 employee_ID_num char(10),
 due_date date,
 num_hours char(8),
 primary key (project_code, employee_ID_num),
 foreign key (project_code) references project(project_code),
 foreign key (employee_ID_num) references employee(employee_ID_num));

alter table department
	add constraint department_Manager_ID_fk foreign key (Manager_ID) references employee(employee_ID_Num);

alter table department
	add constraint department_div_code_fk foreign key (div_code) references division(div_code);
