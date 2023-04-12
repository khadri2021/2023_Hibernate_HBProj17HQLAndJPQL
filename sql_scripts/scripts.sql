select * from chicken;

select * from chicken where C_NAME = 'KADAKANATH'; 
select * from chicken where C_QTY = 1;
select * from chicken where C_COST <= 200;
select * from chicken where C_NAME like 'S%';
select * from chicken where C_COST > 100 and C_COST <= 200;


select * from company;


select * from Food1;


create table food1(id bigint primary key,cost varchar(255),name varchar(255));

insert into food1 (select * from food);-- SQL

update food set cost = 30 where name="poori";
delete from food where id= 10;












select 
chicken0_.C_ID as c_id1_0_, 
chicken0_.C_COST as c_cost2_0_, 
chicken0_.C_NAME as c_name3_0_, 
chicken0_.C_QTY as c_qty4_0_ from CHICKEN chicken0_ where chicken0_.C_NAME=?;

select chicken0_.C_ID as c_id1_0_,
chicken0_.C_COST as c_cost2_0_,
chicken0_.C_NAME as c_name3_0_, 
chicken0_.C_QTY as c_qty4_0_ from CHICKEN chicken0_ where chicken0_.C_QTY=?;
