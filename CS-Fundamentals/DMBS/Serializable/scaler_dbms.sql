use `sql_invoicing`;
-- show tables;
select * from payments;

-- To get to know the transaction level
show variables like "tx_isolation";
set session transaction isolation level serializable;

set autocommit=0;
start transaction;
select * from payments where payment_id=1 For update;
update payments set amount= 10 where payment_id=1;
select * from payments where payment_id=1;
commit;