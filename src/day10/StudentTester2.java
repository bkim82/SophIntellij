package day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class StudentTester2 {
  public static final String[] names = {
    "Esteban","Lariana","Jasmine","Neel","Steven",
    "Barr","Maya","Vivian","Kyle", "Lynn", "Jueun",
    "Sarah", "Therese", "Hailey", "Ryan"
  };
  
  public static void main(String[] args) {
    ArrayList<Student> students = new ArrayList();

    Random r = new Random(143);

    for (int i = 0; i < 30; i++) {
      int name = r.nextInt(names.length);
      int age = r.nextInt((19-13) + 1) + 13;
      Student s = new Student(names[name], age);
      students.add(s);
    }

    Collections.sort(students);

    for (Student s: students) {
      System.out.println(s);
    }
    
    /* Fill students with 30 students having random names from "names"
     * and random ages in the range [13,19]/ */

    // Sort the list students.

    // Print the list using a for each loop.
  }
}

/* Should output:
19: Jasmine
19: Lynn
19: Neel
19: Steven
18: Ryan
18: Ryan
18: Vivian
17: Jueun
17: Neel
17: Therese
17: Vivian
16: Neel
15: Hailey
15: Jueun
15: Jueun
15: Maya
15: Neel
15: Sarah
15: Therese
14: Hailey
14: Jasmine
14: Lynn
14: Lynn
13: Barr
13: Kyle
13: Lariana
13: Lynn
13: Neel
13: Neel
13: Steven
 */

               
      