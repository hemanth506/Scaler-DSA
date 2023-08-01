Use `sql_hr`;
Select * from employees;
select * from offices;
select  o.office_id, count(*) as count, o.address as office_addess, e.employee_id  from employees as e
 join offices as o 
 on o.office_id = e.office_id 
 group by e.office_id, office_addess, e.employee_id;


