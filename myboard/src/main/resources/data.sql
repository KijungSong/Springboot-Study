insert into member(id, name, email, passwd, regdate)
    values(1, 'song', 'skj4522@gmail.com', '{bcrypt}$2a$10$0IKjNgE8fn.5oTSc4V0Cj.9NArYsSZYEZl7NVwV/cPP27dKDOGy76', now());

insert into member_role(id, name, member_id) values (1, 'USER', 1);


insert into board(id, title, content, regdate, member_id)
    values(1, '1번째 글', '글 내용 1', now(), 1);
insert into board(id, title, content, regdate, member_id)
    values(2, '2번째 글', '글 내용 2', now(), 1);
insert into board(id, title, content, regdate, member_id)
    values(3, '3번째 글', '글 내용 3', now(), 1);
insert into board(id, title, content, regdate, member_id)
    values(4, '4번째 글', '글 내용 4', now(), 1);
insert into board(id, title, content, regdate, member_id)
    values(5, '5번째 글', '글 내용 5', now(), 1);
