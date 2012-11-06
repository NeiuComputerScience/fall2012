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
            Semester sem = new Semester();
            studentList=sem.sortStudents(studentList);
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
                Semester sem = new Semester();
                System.out.print("Enter the number of programming Assigment (ranging from 0-6): ");
                int numAssigments =keyboard.nextInt();
                s1.setNumAssignments(numAssigments);
                System.out.print("Enter the number of tests (ranging from 0-6): ");
                int numTests =keyboard.nextInt();
                s1.setNumTest(numTests);
                System.out.print("Enter the number of final exams(ranging from 0-1): ");
                int numFinalExam =keyboard.nextInt();
                //Semester sem = new Semester(numAssigments,numTests,numFinalExam);
            }

            else if(reply =='A'|| reply=='a' ) {
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
        }
    }
}
