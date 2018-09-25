--- Roles
select * from user;

INSERT INTO ROLE (role_id,role) VALUES (1,'USER');
INSERT INTO ROLE (role_id,role) VALUES (2,'ADMIN');


--- USERS
INSERT INTO USER (id,first_name,last_name,email,password,enabled,token_Expired) VALUES (1,'Ahmed','Salem','ahmed.salem@gmail.com','1234',true,true);
INSERT INTO USER (id,first_name,last_name,email,password,enabled,token_Expired) VALUES (2,'Belal','Omar','belal.omar@gmail.com','1515',true,true);

-- USER ROLES
INSERT INTO users_roles (USER_ID,ROLE_ID) VALUES (1,1);
INSERT INTO users_roles (USER_ID,ROLE_ID) VALUES (1,2);
INSERT INTO users_roles (USER_ID,ROLE_ID) VALUES (2,1);


-- Sample Todo
INSERT INTO ITEM (ITEM_ID,CREATED_ON,DONE,TODO,USER_ID ) values (1,'2018-09-17 18:47:52.69',true,'Go to GYM after ',1);
INSERT INTO ITEM (ITEM_ID,CREATED_ON,DONE,TODO,USER_ID ) values (2,'2018-09-18 18:47:52.69',false,'Study Docker For Java Developer',1);
INSERT INTO ITEM (ITEM_ID,CREATED_ON,DONE,TODO,USER_ID ) values (3,'2018-09-23 18:47:52.69',true,'Study Docker',2);
INSERT INTO ITEM (ITEM_ID,CREATED_ON,DONE,TODO,USER_ID ) values (4,'2018-09-23 18:47:52.69',true,'Study AWS',2);
INSERT INTO ITEM (ITEM_ID,CREATED_ON,DONE,TODO,USER_ID ) values (5,'2018-09-23 18:47:52.69',true,'Study Design pattern',1);