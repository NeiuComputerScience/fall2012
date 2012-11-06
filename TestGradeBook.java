/**
 * Created with IntelliJ IDEA.
 * User: troy
 * Date: 10/30/12
 * Time: 10:23 AM
 * To change this template use File | Settings | File Templates.
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
public class TestGradeBook {
    public static void main(String[]args)  {
        boolean done = false;
        char reply;
        Semester s1= new Semester();
        ArrayList<Student> studentList;
        Scanner keyboard = new Scanner(System.in);
        try{
            String cl ="Grades.dat";
            File myFile = new File(cl);
            Scanner fr = new Scanner(myFile);

            String[]arr;
            while(fr.hasNext()){

                Student s = new Student();
                String line="";
                line+=fr.nextLine();
                arr=line.split(",");
                s.setStudentName(arr[0]);
                s.setStudentNumber(arr[1]);
                s1.addStudent(s);
            }
            System.out.println();
            studentList=s1.getStudentList();
            for(int i =0; i<studentList.size();i++)
                System.out.println(studentList.get(i).getStudentName()+" "+studentList.get(i).getStudentNumber());
            System.out.println();
            studentList=s1.sortID(studentList);
            for(int i =0; i<studentList.size();i++)
                System.out.println(studentList.get(i).getStudentName()+" "+studentList.get(i).getStudentNumber());
        }
        catch (FileNotFoundException fnfe){
            System.out.println("File not found."+fnfe.toString());
        }


        while(!done){
            System.out.println("S-Set up a new Semester");
            System.out.println("A-Add a student");
            System.out.println("P-Record programming assigment grade");
            System.out.println("T-Record test grade for all students");
            System.out.println("F-Record final grade for all students");
            System.out.println("C-Change student grade");
            System.out.println("G-Calculate final grade for all students");
            System.out.println("O-Output grade data for all students");
            System.out.println("Q-Quit");

            String response = keyboard.next();
            reply=response.charAt(0);

            if(reply=='S'|| reply =='s'){
                //Semester sem = new Semester();
                System.out.print("Enter the number of programming Assigment (ranging from 0-6): ");
                int numAssigments =keyboard.nextInt();
                s1.setNumAssignments(numAssigments);
                System.out.print("Enter the number of tests (ranging from 0-6): ");
                int numTests =keyboard.nextInt();
                s1.setNumTest(numTests);
                System.out.print("Enter the number of final exams(ranging from 0-1): ");
                int numFinalExam =keyboard.nextInt();
                System.out.print("Enter the weight for program assignments: ");
                double programWeight = keyboard.nextDouble();
                System.out.print("Enter the weight for tests: ");
                double testWeight = keyboard.nextDouble();
                System.out.print("Enter the weight for the final exam: ");
                double FinalWeight = keyboard.nextDouble();
                //Semester sem = new Semester(numAssigments,numTests,numFinalExam);
            }

            else if(reply =='A'|| reply=='a' ) {
                keyboard.nextLine();
                Student s = new Student();
                System.out.print("Enter the student's full name: ");
                String fullName = keyboard.nextLine();
                System.out.print("Enter the student's Id number: ");
                String idNumber = keyboard.nextLine();
                s.setStudentName(fullName);
                s.setStudentNumber(idNumber);
                s1.addStudent(s);
                studentList=s1.getStudentList();
            }
            else if(reply=='P'|| reply=='p'){
                studentList=s1.getStudentList();
                System.out.print("Which assigment grade are you entering: ");
                int assignmentNum=keyboard.nextInt();
                while(assignmentNum>s1.getNumAssignments()){
                    System.out.print("Incorrect program number please reenter a valid program number: ");
                    assignmentNum=keyboard.nextInt();
                }
                studentList=s1.sortStudents(studentList);
                keyboard.nextLine();
                for(int i=0; i<studentList.size();i++){
                    System.out.print("Enter "+studentList.get(i).getStudentName()+"'s program "+assignmentNum+" grade: ");
                    String grade = keyboard.nextLine();
                    studentList.get(i).setAssignments(grade);
                    System.out.println(studentList.get(i).getAssignments()); //check to see if the array was being filled
                }
            }
            else if(reply=='T'|| reply=='t'){
                studentList=s1.getStudentList();
                System.out.print("Which Test grade are you entering: ");
                int testNum=keyboard.nextInt();
                while(testNum>s1.getNumTest()){
                    System.out.print("Incorrect test number please reenter a valid test number: ");
                    testNum=keyboard.nextInt();
                }
                studentList=s1.sortStudents(studentList);
                keyboard.nextLine();
                for(int i=0; i<studentList.size();i++){
                    System.out.print("Enter "+studentList.get(i).getStudentName()+"'s test "+testNum+" grade: ");
                    String grade = keyboard.nextLine();
                    studentList.get(i).setTestScoreList(grade);
                    System.out.println(studentList.get(i)); //check to see if the array was being filled
                }
            }

            else if(reply=='F'|| reply=='f'){
                /*Student s = new Student();
                if(s.getFinalExamList().size()>0)
                    System.out.println("A final exam grade has already been entered.");*/
                studentList=s1.getStudentList();
                System.out.print("Enter final exam grade are you entering: ");
                int finalExam=keyboard.nextInt();
                studentList=s1.sortStudents(studentList);
                keyboard.nextLine();
                for(int i=0; i<studentList.size();i++){
                    System.out.print("Enter "+studentList.get(i).getStudentName()+"'s final exam "+finalExam+" grade: ");
                    String grade = keyboard.nextLine();
                    studentList.get(i).setFinalExamList(grade);
                    System.out.println(studentList.get(i)); //check to see if the array was being filled
                }
            }


            else if(reply == 'O'|| reply=='o'){
                try{
                    FileWriter fw = new FileWriter("grades.out");
                    BufferedWriter out = new BufferedWriter(fw);
                    int count =0;
                    studentList=s1.getStudentList();
                    keyboard.nextLine();
                    System.out.print("How do you want to sort output by:");
                    String answer = keyboard.nextLine();
                    if(answer.equalsIgnoreCase("student name"))
                        studentList=s1.sortStudents(s1.getStudentList());
                    else if(answer.equalsIgnoreCase("student number"))
                        studentList=s1.sortID(s1.getStudentList());

                    for(int i=0; i<studentList.size();i++){
                        out.write(studentList.get(i)+"\n");
                        count ++;
                    }
                    out.close();
                    if(count!=1){
                        System.out.println("Saving " + count +" students...");
                        System.out.println("Students saved successfully");
                    }
                    else {
                        System.out.println("Saving " + count +" student...");
                        System.out.println("Student saved successfully");
                    }

                }
                catch(FileNotFoundException fnfe){
                    System.out.println("File not found " +fnfe.toString());
                }
                catch(Exception e){
                    System.out.println("An exception has occurred "+e.toString());
                }
            }

            else if(reply == 'Q'|| reply=='q'){
                done=true;
                try{
                    FileWriter fw = new FileWriter("grades.dat");
                    BufferedWriter out = new BufferedWriter(fw);
                    int count =0;
                    studentList=s1.getStudentList();

                    for(int i=0; i<studentList.size();i++){
                        out.write(studentList.get(i).getStudentName()+","+studentList.get(i).getStudentNumber()+","+studentList.get(i).getAssignments()+","+studentList.get(i).getTestScoreList()+studentList.get(i).getFinalExamList()+"\n");
                        count ++;
                    }
                    out.close();
                    if(count!=1){
                        System.out.println("Saving " + count +" students...");
                        System.out.println("Students saved successfully");
                    }
                    else {
                        System.out.println("Saving " + count +" student...");
                        System.out.println("Student saved successfully");
                    }

                }
                catch(FileNotFoundException fnfe){
                    System.out.println("File not found " +fnfe.toString());
                }
                catch(Exception e){
                    System.out.println("An exception has occurred "+e.toString());
                }
            }
        }
    }
}
