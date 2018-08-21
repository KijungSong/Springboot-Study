insert into member(id, name, email, passwd, regdate)
    values(1, 'song', 'skj4522@gmail.com', '1234', now());

insert into member_role(id, name, member_id) values (1, 'USER', 1);
