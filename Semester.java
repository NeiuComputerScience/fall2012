/**
 * Created with IntelliJ IDEA.
 * User: troy
 * Date: 10/30/12
 * Time: 11:30 AM
 * To change this template use File | Settings | File Templates.
 */
import java.util.ArrayList;
public class Semester {
    private int  numAssignments;
    private int numTest;
    private int numFinalExam;

    ArrayList<Student>studentList= new ArrayList<Student>();

    public Semester(){

    }

    /*public Semester(int numAssignments,int numTest, int numFinalExam){
        assignments = new int[numAssignments];
        test=new int[numTest];
        this.numFinalExam=numFinalExam;
    }
     public void setAssignmentGrade(int grade){
         for(int i=0; i<assignments.length;i++)
             assignments[i]=grade;
     }*/

    public void setNumAssignments(int numAssignments){
        this.numAssignments=numAssignments;
    }

    public int getNumAssignments(){
        return numAssignments;
    }

    public void setNumTest(int numTest){
        this.numTest=numTest;
    }

    public int getNumTest(){
        return numTest;
    }

    public void addStudent(Student s){
        studentList.add(s);
    }

    public ArrayList<Student>getStudentList(){
        return studentList;
    }

    public ArrayList<Student> sortStudents(ArrayList<Student>students ){
        boolean swapped=true;
        while(swapped){
            swapped=false;
            for(int i=1;i<students.size();i++)
                if(students.get(i-1).getStudentName().compareTo(students.get(i).getStudentName())>0){
                    Student temp=students.get(i);
                    students.set(i,students.get(i-1));
                    students.set(i-1,temp);
                    swapped=true;
                }
        }
        return students;
    }
}
