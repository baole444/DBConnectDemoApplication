-- ITRequest database for java sql test
-- Make sure to use compatible script for older version of mysql

create database VBoxData;

use VBoxData;

create table ITRequest (
	ReqID int not null auto_increment, -- id of request
    ReqName varchar(255) not null, -- name of the person that made the request
	ReqDate date not null, -- day of the request
    ReqEmail varchar(255) not null, -- email of the person that made the request
    ReqType varchar(255), -- type of the request
    ReqDetails varchar(255), -- detail of the request
    primary key (ReqID)
);


select * from itrequest;

-- some test data for initialization
insert into itrequest (reqname, reqdate, reqemail, reqtype, reqdetails) values 
	("SirTestAlot Mc.Testing", "2000-01-01", "TestingMcTest12345@testmail.trial", "Test DBConnect call", "SirTestAlot shall test this column"),
    ("Sky Cat", "2024-11-28", "someSkyCat@uwumail.net", "Update MySQL Server", "Please update all your department machine with the latest version of mysql server please, thanks!");
