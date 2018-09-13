insert into USER_TBL values(1, 'xvanhalenx', '123123', 1, 1, 1, 1);
insert into USER_TBL values(2, 'admin', 'admin', 1, 1, 1, 1);

insert into CUSTOMER_TBL values(1, 1, 'Ivan Venor', 'García');
insert into ADMIN_TBL values(2, 2, 'Ivan Venor (admin)', 'García');


insert into AUTHORITY_TBL values(1, 1, 'ROLE_ADMIN');
insert into AUTHORITY_TBL values(2, 1, 'ROLE_CUSTOMER');


insert into ACCOUNT_TBL values(1, 1, '00112233445566', '2016-02-28', 125590.55);
insert into ACCOUNT_TBL values(2, 1, '00112233445577', '2016-02-20', 150000.00);

insert into MOVEMENT_TBL values(1, 1, '00112233445566', '00112233445577', 50000.00, 'WITHDRAWAL', '2016-01-06', 'Christmas Party', '000222555888');
insert into MOVEMENT_TBL values(2, 2, '00112233445566', '00112233445577', 50000.00, 'DEPOSIT', '2016-01-06', 'Christmas Party', '000222555777');
insert into MOVEMENT_TBL values(3, 2, '00112233445588', '00112233445577', 2000.00, 'DEPOSIT', '2016-01-06', 'Christmas Party', '000222555666');
insert into MOVEMENT_TBL values(4, 2, '00112233445599', '00112233445577', 4500.00, 'DEPOSIT', '2016-01-06', 'Christmas Party', '000222555999');

