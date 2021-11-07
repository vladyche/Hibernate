insert into post (id, title) values (1, 'post 1');
insert into post (id, title) values (2, 'post 2');
insert into post (id, title) values (3, 'post 3');
insert into post (id, title) values (4, 'post 4');
insert into post (id, title) values (5, 'post 5');
insert into post (id, title) values (6, 'post 6');
insert into post (id, title) values (7, 'post 7');

insert into tag (id, name) values (1, 'news');
insert into tag (id, name) values (2, 'software');
insert into tag (id, name) values (3, 'java');
insert into tag (id, name) values (4, 'hibernate');

insert into posts_tagging (post_id, tag_id) values (1, 1);
insert into posts_tagging (post_id, tag_id) values (1, 2);
insert into posts_tagging (post_id, tag_id) values (1, 3);
insert into posts_tagging (post_id, tag_id) values (1, 4);

insert into posts_tagging (post_id, tag_id) values (1, 1);
insert into posts_tagging (post_id, tag_id) values (2, 1);
insert into posts_tagging (post_id, tag_id) values (3, 1);
insert into posts_tagging (post_id, tag_id) values (4, 1);