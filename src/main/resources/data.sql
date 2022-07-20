INSERT INTO Writer (age,name) VALUES (21, 'Jim');
INSERT INTO Writer (age,name) VALUES (26, 'Jack');
INSERT INTO Writer (age,name) VALUES (25, 'Johnnie');
INSERT INTO Content (title,text,posted,writer_id) VALUES ('Test Title','Test content', CURRENT_DATE(), (SELECT id FROM Writer WHERE name = 'Johnnie') );
INSERT INTO Content (title,text,posted,writer_id) VALUES ('Test Title2','Test content 2', CURRENT_DATE(), (SELECT id FROM Writer WHERE name = 'Johnnie') );
INSERT INTO Content (title,text,posted,writer_id) VALUES ('Test Title for Jack','Jack content', CURRENT_DATE(), (SELECT id FROM Writer WHERE name = 'Jack') );
INSERT INTO Content (title,text,posted,writer_id) VALUES ('Test Title 2 for Jim','Jim content 2', CURRENT_DATE(), (SELECT id FROM Writer WHERE name = 'Jim') );
INSERT INTO Content (title,text,posted,writer_id) VALUES ('Hello','Hello content', CURRENT_DATE(), (SELECT id FROM Writer WHERE name = 'Jack') );
INSERT INTO Content (title,text,posted,writer_id) VALUES ('Good Bye','Bye content', CURRENT_DATE(), (SELECT id FROM Writer WHERE name = 'Jim') );