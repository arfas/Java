DROP DATABASE IF EXISTS cs532db2;

CREATE DATABASE cs532db2;

USE cs532db2;

CREATE TABLE UserLogin (
  Username varchar(15) NOT NULL PRIMARY KEY,
  Password varchar(15) NOT NULL
);
  
INSERT INTO UserLogin VALUES ('peter', 'abc'),
                            ('lily', 'abc'),
                            ('carl', 'abc');
                          
CREATE TABLE UserRole (   
  Username VARCHAR(15) NOT NULL,
  Rolename VARCHAR(15) NOT NULL,

  PRIMARY KEY (Username, Rolename)
);
  
INSERT INTO UserRole VALUES ('peter', 'admin'),
                            ('lily', 'support'),
                            ('carl', 'support');
