package exday5;

import java.util.*;

public class SampleEx501 {
    public static void main(String[] args) {
        ArrayList<Student> al = new ArrayList<Student>();
        al.add(new Student("A",1,1));
        al.add(new Student("B",1,2));
        al.add(new Student("C",2,3));
        al.add(new Student("D",3,4));

        al.remove(3);
        for(Student s : al){
            System.out.println("番号:" + s.getNumber() + "名前" + s.getName() + "学年" + s.getGrade());
        }
    }
}
