USE master;

GO 

/*
ALTER DATABASE SchoolDatabase
SET
    SINGLE_USER
WITH
    ROLLBACK IMMEDIATE;

GO 
*/


DROP DATABASE IF EXISTS SchoolDatabase;

CREATE DATABASE SchoolDatabase;

GO 


USE SchoolDatabase;
GO


CREATE TABLE
	UserType(
		[UserTypeID]  [int] NOT NULL IDENTITY(1, 1) PRIMARY KEY,
		[UserTypeName] [varchar] (50) NOT NULL
	);

CREATE TABLE
    [User](
        [UserID] [int] NOT NULL IDENTITY(1, 1) PRIMARY KEY,
        [Name] [varchar] (50) NOT NULL,
		[Surname] [varchar] (50) NOT NULL,
        [Email] [varchar] (150) NOT NULL,
        [UserTypeID] int NOT NULL,
		CONSTRAINT [FK_User_UserType_UserTypeID] FOREIGN KEY (UserTypeID) REFERENCES UserType(UserTypeID),
		UNIQUE (Email)
    );
    
CREATE TABLE
	[Course](
		[CourseID] [int] NOT NULL IDENTITY(1,1) PRIMARY KEY,
		[CourseName] [varchar] (50) NOT NULL,
		[CourseDescription] [varchar] (150)
	);

CREATE TABLE 
	[Module](
		[ModuleID] [int] NOT NULL IDENTITY(1,1) PRIMARY KEY,
		[ModuleName] [varchar] (50) NOT NULL,
		[ModuleDescription] [varchar] (150),
		[CourseID] [int] NOT NULL,
		CONSTRAINT [FK_Module_CourseID] FOREIGN KEY (CourseID) REFERENCES Course (CourseID)
	);

CREATE TABLE 
	[Enrolment](
		[EnrolmentID]  [int] NOT NULL IDENTITY(1,1) PRIMARY KEY,
		[UserID] [int] NOT NULL,
		[ModuleID] [int] NOT NULL,
		[Term] [varchar] (50),
		CONSTRAINT [FK_Enrolment_ModuleID] FOREIGN KEY (ModuleID) REFERENCES Module (ModuleID),
		CONSTRAINT [FK_Enrolment UserID] FOREIGN KEY (UserID) REFERENCES [User] (UserID)
	);

CREATE TABLE
	[Assessment](
		[AssessmentID]  [int] NOT NULL IDENTITY(1,1) PRIMARY KEY,
		[AssessmentType] [varchar] (50),
		[ModuleID] [int] NOT NULL,
		[AssessmentDescription] [varchar] (150),
		[AssessmentWeight] [decimal],
		CONSTRAINT [FK_Assessment_ModuleID] FOREIGN KEY (ModuleID) REFERENCES Module (ModuleID)
	);

CREATE TABLE 
	[Grade](
		[EnrolmentID] [int] NOT NULL,
		[AssessmentID] [int] NOT NULL,
		[GradeObtained] [decimal] NOT NULL,
		CONSTRAINT [PK_Grade] PRIMARY KEY (EnrolmentID, AssessmentID),
		CONSTRAINT [FK_Grade_EnrolmentID] FOREIGN KEY (EnrolmentID) REFERENCES Enrolment (EnrolmentID),
		CONSTRAINT [FK_Grade_AssessmentID] FOREIGN KEY (AssessmentID) REFERENCES Assessment (AssessmentID)
	);