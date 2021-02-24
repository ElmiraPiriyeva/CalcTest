Insert Into students (ST_ID,FIRST_NAME,LAST_NAME,GPA,CLASS_OF) Values  (2,'Elmira','Piriyeva',3.12,2021);
Insert Into students (ST_ID,FIRST_NAME,LAST_NAME,GPA,CLASS_OF) Values  (3,'Aytan','Quliyeva',2.46,2023);
Insert Into students (ST_ID,FIRST_NAME,LAST_NAME,GPA,CLASS_OF) Values  (1,'Lamiya','Aydinova',1.68,2023);

Insert Into courses (CR_ID,COURSE_NAME,COURSE_CREDIT,PASSING_GRADE,PREREQUISITE) Values (2300,'Web & Mobile 2',6,75,'Web & Mobile 1');
Insert Into courses (CR_ID,COURSE_NAME,COURSE_CREDIT,PASSING_GRADE,PREREQUISITE) Values (2406,'Principles of Programming 2',4,70,'Principles of Programming 1');
Insert Into courses (CR_ID,COURSE_NAME,COURSE_CREDIT,PASSING_GRADE,PREREQUISITE) Values (2123,'Fundamentals of Database',6,75,null);

Insert Into enrollments(ST_ID,CR_ID) Values (2,2300);
Insert Into enrollments(ST_ID,CR_ID) Values (3,2300);
Insert Into enrollments(ST_ID,CR_ID) Values (1,2406);
Insert Into enrollments(ST_ID,CR_ID) Values (3,2406);



