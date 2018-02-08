drop table orders;
drop table transactions;
drop table software;
drop table customers;
drop table company;
drop table credit_card_order;
drop table supplies;
drop table selected_software;





create table customers
   (customer_id 	varchar2(10)	not null,
    customer_name	varchar2(20)	not null,
    address		varchar2(10)	not null,
    phone		varchar2(15)	not null,
    email		varchar2(30)	not null,
    primary key(customer_id));

create table company 
   (company_id		varchar2(10)	not null,
    name 		varchar2(20)	not null,
    primary key(company_id));

create table credit_card_order
   (account_no 	varchar2(10)	not null,
    exp_date 	date		not null,
    card_type 	varchar2(10)	not null,
    primary key(account_no));

create table software
   (soft_id	 	varchar2(10)	not null,
    company_id		varchar2(10)	not null,   
    soft_name 		varchar2(10)	not null,
    category	 	varchar2(10)	not null,
    price	 	number		not null,
    available_copy 	number		not null,
    primary key(soft_id),
    foreign key(company_id) references company(company_id));

create table transactions
   (trans_id	 	varchar2(15)	not null,
    order_id		varchar2(10)	not null,
    customer_id 	varchar2(10)	not null,
	total_amount	number,
    primary key(trans_id),
    foreign key(customer_id) references customers(customer_id)
	);

create table orders
   (order_id	 	varchar2(15)	not null,
    trans_id	 	varchar2(15)	not null,
    payment_method 	varchar2(15)	not null,
    account_no 		varchar2(15)	not null,
    primary key(order_id),
    foreign key(account_no) references credit_card_order(account_no)
	);

create table supplies
   (company_id		varchar2(10)	not null,
    soft_id 		varchar2(10)	not null,
    supplies_date 	date		not null,
    primary key(company_id,soft_id));

create table selected_software
   (soft_id		varchar2(10)	not null,
    order_id 		varchar2(10)	not null,
    soft_date 		date		not null,
    primary key(soft_id,order_id));
	
create table cardtype(
	card varchar2(19)
	); 
insert into cardtype values('cash');
insert into cardtype values('credit card');

/* populate relations */
/*
insert into customer	values ('11111',	'parvez',	'khilgaon',	'01676188432',	'abc@gmail.com');
insert into customer	values ('22222',	'shadhin',	'badda',	'01676188433',	'afc@gmail.com');
insert into customer	values ('33333',	'jahid',	'uttora',	'01676188438',	'atc@gmail.com');


insert into company	values ('A101',	'Microsoft');
insert into company	values ('B102',	'Iobit');
insert into company	values ('C103',	'Adobe');



insert into credit_card_order values ('4A',	'12-AUG-2015', 'card1');
insert into credit_card_order values ('5A',	'15-AUG-2015', 'card2');
insert into credit_card_order values ('6A',	'19-AUG-2015',  'card3');

insert into software values ('AAA','A101','ASC', 'Protection', 300, 20);
insert into software values ('BBB','B102','Norton', 'Antivirus', 900, 10);
insert into software values ('CCC','C103','Photoshop', 'Design', 800, 30);

insert into orders	values ('L-17',		'Cash', '4A');
insert into orders	values ('M-19',		'Credit card', '5A');
insert into orders	values ('N-14',		'Credit card', '6A');

insert into transaction	values ('123A', 'M-19', '11111', 500);
insert into transaction	values ('123B',	'L-17', '22222', 700);
insert into transaction	values ('123C',	'L-17', '33333', 900);


*/


commit;