USE SchoolDatabase;
GO

INSERT INTO [dbo].[UserType](
		UserTypeName
	) VALUES
		('Student'),
		('FacultyMember');

INSERT INTO [dbo].[User](
		[Name],
		Surname,
		Email,
		UserTypeID
	) VALUES
		('John', 'Doe', 'john.doe@gmail.com', 1),
		('Aris', 'Nanabhai', 'arisn@bbd.co.za', 1),
		('Spongebob', 'Squarepants', 'spongebob@yahoo.com', 1),
		('Rudolph', 'Esterhuysen', 'rudolphe@bbdsoftware.com', 2),
		('Lucky', 'Nkosi', 'lucky@bbd.co.za', 2),
		('Jacob', 'Zuma', 'jacob.zuma@hotmail.com', 1),
		('Bugs', 'Bunny', 'bugz@gmail.com', 1);

INSERT INTO [dbo].[Course](
		[CourseName],
		[CourseDescription]
	) VALUES
		('Computer Science','Computer science is the study of computers and how they work, including software, hardware, and algorithms.'),
		('Mathematics', 'Mathematics is an area of knowledge that includes such topics as numbers.'),
		('Economics', 'Economics focuses on the behaviour and interactions of economic agents and how economies work.');

INSERT INTO [dbo].Module(
		[ModuleName],
		[ModuleDescription],
		[CourseID]
	) VALUES
		('Introduction to Computer Science', 'Introduction to programming using Java', 1),
		('Data structures and algorithms', 'Data structures and algorithms are the studies of commonly used computational methods.', 1),
		('Computer networks', 'This branch of computer science aims to manage networks between computers worldwide.', 1),
		('Calculus 1', 'Differentiation and integration', 2),
		('Algebra 1', 'Introduction to group theory',  2),
		('Econ 101', 'Introduction to microeconomics', 3);

INSERT INTO [dbo].Enrolment(
		UserID,
		ModuleID,
		Term
	) VALUES
		(1, 1, 'Sem1 2021'),
		(1, 2, 'Sem2 2021'),
		(1, 3, 'Sem1 2022'),
		(2, 4, 'Sem1 2021'),
		(2, 5, 'Sem2 2021'),
		(3, 6, 'Sem1 2022'),
		(6, 1, 'Sem1 2021'),
		(6, 2, 'Sem2 2021'),
		(6, 3, 'Sem1 2022'),
		(7, 1, 'Sem1 2021'),
		(7, 2, 'Sem2 2021');

INSERT INTO [dbo].Assessment(
		ModuleID,
		AssessmentType,
		AssessmentWeight
	) VALUES
		(1, 'Assignment', 10),
		(1, 'Test', 15),
		(1, 'Project', 25),
		(1, 'Exam', 50),
		(2, 'Assignment', 30),
		(2, 'Exam', 70),
		(3, 'Assignment', 20),
		(3, 'Report', 40),
		(3, 'Exam', 40),
		(4, 'Test', 25),
		(4, 'Assignment', 10),
		(4, 'Exam', 65),
		(5, 'Test', 25),
		(5, 'Exam', 75),
		(6, 'Report', 25),
		(6, 'Test', 15),
		(6, 'Exam', 60);

INSERT INTO [dbo].Grade(
		EnrolmentID,
		AssessmentID, 
		[GradeObtained]
	) VALUES
		(1, 1, 100),
		(1, 2, 45),
		(1,3,45),
		(1,4,70),
		(7,1,85),
		(7,2,63),
		(7,3,80),
		(7,4,78),
		(10,1,55),
		(10,2, 48),
		(10,3,54),
		(10,4,35),
		(2,5,59),
		(2,6, 63),
		(8,5,75),
		(8,6,90),
		(11,5,56),
		(11,6,44),
		(3,7,54),
		(3,8,66),
		(3,9,57),
		(9,7,77),
		(9,8,65),
		(9,9,74),
		(4,10,50),
		(4,11,65),
		(4,12,53),
		(5,13,49),
		(5,14,62),
		(6,15,0),
		(6,16,23),
		(6,17,0);

