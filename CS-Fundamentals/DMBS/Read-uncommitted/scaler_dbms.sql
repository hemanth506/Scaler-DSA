use `sql_invoicing`;
show tables;
select * from payments;

-- To get to know the transaction level
show variables like "tx_isolation";
-- ---------------------
set session transaction isolation level read uncommitted;
start transaction;
select * from payments where payment_id=1;
update payments set amount=70 where payment_id=1;
commit;
-- ---------------------