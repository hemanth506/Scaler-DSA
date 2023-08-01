use `sql_store`;
select * from customers;

-- Joins 
-- select c1.customer_id, c1.state from customers c1 join customers c2 on c1.state = c2.state group by c2.state having avg(c2.points) < c1.points; 

select state, round(avg(points), 2) from customers group by state; 

-- sub query in where
select customer_id, state from customers cust where points > (Select avg(points) from customers group by state having state=cust.state);

-- sub query in select
select  customer_id, state, points, (Select round(avg(points), 2) from customers where state = cs.state group by state) as avg_points from customers cs; 