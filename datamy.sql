insert into customers	values ('11111',	'parvez',	'khilgaon',	'01676188432',	'abc@gmail.com');
insert into customers	values ('22222',	'shadhin',	'badda',	'01676188433',	'afc@gmail.com');
insert into customers	values ('33333',	'jahid',	'uttora',	'01676188438',	'atc@gmail.com');


insert into company	values ('A101',	'Microsoft');
insert into company	values ('B102',	'Iobit');
insert into company	values ('C103',	'Adobe');


insert into credit_card_order values ('4A',	'12-AUG-2017', 'card1');
insert into credit_card_order values ('5A',	'15-AUG-2017', 'card2');
insert into credit_card_order values ('6A',	'19-AUG-2017',  'card3');


insert into software values ('AAA','A101','ASC', 'Protection', 300, 20);
insert into software values ('BBB','B102','Norton', 'Antivirus', 900, 10);
insert into software values ('CCC','C103','Photoshop', 'P_Editor', 800, 30);
insert into software values ('ADA','A101','AC', 'Potection', 30, 2);


insert into transactions values ('123A', 'M-19', '11111', 500);
insert into transactions values ('123B', 'L-17', '22222', 700);
insert into transactions values ('123C', 'L-17', '33333', 900);

insert into orders values ('L-17',	'123A',	'Cash', '4A');
insert into orders values ('M-19',	'123B',	'Credit card', '5A');
insert into orders values ('N-14',	'123C',	'Credit card', '6A');

insert into supplies values ('A101', 'AAA',	'17-JUN-2015');
insert into supplies values ('B102', 'BBB',	'10-MAY-2015');
insert into supplies values ('C103', 'CCC',	'05-MAY-2015');

insert into selected_software values ('AAA', 'L-17',	'07-JUN-2015');
insert into selected_software values ('BBB', 'M-19',	'10-JUN-2015');
insert into selected_software values ('CCC', 'N-14',	'25-MAY-2015');
commit;


