import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: troy
 * Date: 10/30/12
 * Time: 9:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class Student {
    private String studentNumber;
    private String studentName;
    //private String testScore;
    //private String assignmentGrade;
    private String finalExamScore;
    public ArrayList<String>assignments=new ArrayList<String>();
    public ArrayList<String>testScoreList= new ArrayList<String>();

    public void setStudentNumber(String number){
        studentNumber=number;
    }

    public String getStudentNumber(){
        return studentNumber;
    }

    public void setStudentName(String studentName){
        this.studentName=studentName;
    }

    public String getStudentName(){
        return studentName;
    }

    public void setTestScoreList(String testGrade){
            testScoreList.add(testGrade );
    }

    public ArrayList<String> getTestScoreList(){
        return testScoreList;
    }
    public void setAssignments(String grade){
        assignments.add(grade);
    }

    public ArrayList<String> getAssignments(){
        return assignments;
    }

    public String toString(){
        String ret=studentName+"\n"+"ID "+studentNumber+"\n";
        for(int i =0; i<assignments.size();i++)
            ret =ret+assignments.get(i)+" Assignment# "+i+"\n";
        for(int i=0;i<testScoreList.size();i++)
            ret=ret+testScoreList.get(i)+" Test# "+i+"\n";
         return ret;
    }
}
