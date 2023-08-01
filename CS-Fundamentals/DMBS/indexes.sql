use `sql_invoicing`;
show tables;
select * from payments;

-- Start to create history
set profiling = 1;

select * from payments where invoice_id=18;

-- creates index on number
Create index idx_inv_id on payments(invoice_id);

-- returns the history of each query
show profiles;

-- Will return all the indexes created for payment column
show indexes in payments;

-- Will return time taken for each step for query 11 in profiling table
show profile for query 11;

-- creates index on multiple columns
Create index idx_payment_paymentInvoice on payments(payment_id, invoice_id);

select * from clients;

show indexes in clients;

-- index on string columns
Create index idx_clients_name on clients(name(3));