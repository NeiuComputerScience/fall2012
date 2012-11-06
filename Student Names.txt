•	Student Names
•	Record
•	Alter grades
•	Final Semester grades
•	Grades.dat
1)	Commands 
a)	S = new semester
i)	Number of assignments ( assignments >= 0 && assignment <=6)
ii)	Number of tests (test >= 0  && test <=3)
iii)	Final exam (final >=0 && final <=1)
iv)	Weight of each altogether adding up to 100 (100%) (e.g. assignment(s) = 30, test(s) = 30, final = 40, 30+30+40 = 100)
b)	A = add a student
i)	First name
ii)	Last name
iii)	Student number (1-9999)(check number is not repeated)
c)	P = program assignment is recorded
i)	Ask which assignment
ii)	(upon valid assignment #) prompt each student name alphabetically
iii)	If assignment # greater than # of assignments, print error message
d)	T = test grade is recorded
i)	Ask which test is to be recorded
ii)	If test # is in valid prompt error message
iii)	(upon valid test #) prompt each student name alphabetically 
e)	F = record final exam grade
i)	Prompt each student name alphabetically
ii)	If no final print out error message
f)	C = Change a grade
i)	Change grade on a valid student, valid assignment, test, or final.
ii)	If not print out error message
g)	G = Calculate the final grade
i)	There must be students, and contain graded assignments, tests, or final.
ii)	If not print out error message
h)	O = output grade data
i)	There must be data(students)
i)	Q = quit the program
2)	Cases (preconditions)
a)	Case P ( assignment != 0)
b)	Case T (test !=0)
c)	Case F(final !=0)
d)	Case C(must have a grade in the test, grade or assignment)
e)	Case G(there must be students)
f)	Case O
