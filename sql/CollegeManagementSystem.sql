CREATE TABLE College(
	CollegeId INT PRIMARY KEY,
	CollegeName VARCHAR(50),
	City VARCHAR(20),
	State VARCHAR(20),
	Country VARCHAR(20)
);
CREATE TABLE CollegeDepartment(
	DepartmentId INT PRIMARY KEY,
	DepartmentName VARCHAR(50),
	CollegeId INT FOREIGN KEY REFERENCES College(CollegeId)
);
CREATE TABLE Professor(
	ProfessorId INT PRIMARY KEY,
	ProfessorName VARCHAR(50),
	ContactNumber NUMERIC(10),
	EmailId VARCHAR(30),
	City VARCHAR(20),
	State VARCHAR(20),
	DepartmentId INT FOREIGN KEY REFERENCES CollegeDepartment(DepartmentId)
);
CREATE TABLE Student(
	StudentId INT PRIMARY KEY,
	StudentName VARCHAR(50),
	ContactNumber NUMERIC(10),
	EmailId VARCHAR(30),
	City VARCHAR(20),
	State VARCHAR(20),
	DepartmentId INT FOREIGN KEY REFERENCES CollegeDepartment(DepartmentId)
);


INSERT INTO College VALUES(1001,'vivekanand college','surat','gujrat','india');
INSERT INTO College VALUES(1002,'sutex college','surat','gujrat','india');


INSERT INTO CollegeDepartment VALUES(101,'Computer Science & Engineering',1001);
INSERT INTO CollegeDepartment VALUES(102,'Electrical Engineering',1002);
INSERT INTO CollegeDepartment VALUES(103,'Computer Science & Engineering',1002);
INSERT INTO CollegeDepartment VALUES(104,'Software Engineering',1001);


INSERT INTO Student VALUES(1,'darshan',1234567890,'darshan@gmail.com','surat','gujrat',101);
INSERT INTO Student VALUES(2,'dhanraj',6789054321,'dhanraj@gmail.com','surat','gujrat',103);
INSERT INTO Student VALUES(3,'mitul',7999654321,'mitul@gmail.com','surat','gujrat',101);
INSERT INTO Student VALUES(4,'priyal',9987654321,'priyal@gmail.com','surat','gujrat',104);


INSERT INTO Professor VALUES(11,'vivek',0987654321,'vivek@gmail.com','surat','gujrat',101);
INSERT INTO Professor VALUES(12,'hiren',1234567890,'hiren@gmail.com','surat','gujrat',102);
INSERT INTO Professor VALUES(13,'ratnesh',7999654321,'ratnesh@gmail.com','surat','gujrat',104);
INSERT INTO Professor VALUES(14,'manish',6789054321,'manish@gmail.com','surat','gujrat',103);
INSERT INTO Professor VALUES(15,'onkar',9987654321,'onkar@gmail.com','surat','gujrat',102);


SELECT * FROM College;
SELECT * FROM CollegeDepartment;
SELECT * FROM Student;
SELECT * FROM Professor;