insert into user (id, birth_date, name) values
(1001, sysdate(), 'Adam'),
(1002, sysdate(), 'Jack'),
(1003, sysdate(), 'Bill');

insert into post (id, description, user_id) values
(1001, 'Benz', 1001),
(1002, 'BMW', 1002),
(1003, 'Audi', 1003);