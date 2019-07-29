CREATE TABLE Department(
	DepartmentId INT PRIMARY KEY,
	DepartmentName VARCHAR(50),
	Location VARCHAR(50)
);

CREATE TABLE Employee(
	EmployeeNo INT PRIMARY KEY,
	EmployeeName VARCHAR(50),
	Salary INT,
	DepartmentId INT FOREIGN KEY REFERENCES Department(DepartmentId)
);

INSERT INTO Department VALUES(10,'Management','Andheri');
INSERT INTO Department VALUES(20,'Manufacturing','Andheri');
INSERT INTO Department VALUES(30,'Salling','Pune');
INSERT INTO Department VALUES(40,'Management','Pune');

INSERT INTO Employee VALUES(101,'Darshan',5000,10);
INSERT INTO Employee VALUES(102,'Vivek',10000,30);
INSERT INTO Employee VALUES(103,'Hiren',8000,10);
INSERT INTO Employee VALUES(104,'Manish',9000,20);

SELECT * FROM Department;
SELECT * FROM Employee;