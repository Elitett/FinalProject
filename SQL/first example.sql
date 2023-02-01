/* Multi line
comment*/

-- Single line comment

-- Create table
CREATE TABLE Persons(
PersonID int PRIMARY KEY,
LastName varchar(100),
FirstName varchar(100),
Address varchar(255),
City varchar (50)
);

-- Insert records in the table

INSERT INTO Persons (PersonID, LastName, FirstName, Address, City) VALUES (1000, 'Trump',  'Donald', '721 Fifth Avenue Manhattan', 'New York');

INSERT INTO Persons VALUES (1001, 'Obama', 'Barack', '100 Fifth Avenue Manhattan', 'Florida');

INSERT INTO Persons (PersonID, LastName, FirstName) VALUES (1002, 'Biden', 'Joe');
INSERT INTO Persons (PersonID, LastName, FirstName) VALUES (1003, 'Biden', 'Georg W');

-- delete table
DROP TABLE persons; 

-- View table records
SELECT * FROM persons;

SELECT LastName, City FROM persons;

SELECT LastName, City from persons WHERE City = 'Florida';

-- update data

UPDATE Persons SET City = 'New York' WHERE personID = 1002;

-- DELETE data
DELETE FROM persons WHERE personID = 1003; 

