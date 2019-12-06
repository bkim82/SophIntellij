package day10;

public class Student implements Comparable<Student>{
  private String name;
  private int age;
  
  public Student (String name, int age) {
    this.name = name;
    this.age = age;
  }
  
  public String toString() {
    return age + ": " + name;
  }

  public boolean equals(Student s) {
    if (this.name.equals(s.name) && this.age ==s.age) {
      return true;
    }
    return false;
  }

  public int compareTo(Student s) {
//    if (this.age > s.age) {
//      return 1;
//    }
//    else if (this.age == s.age){
//      if (this.name.compareTo(s.name) > 0) {
//        return 1;
//      }
//      else {
//        return -1;
//      }
//    }
//    return -1;

    if (this.age < s.age) {
      return 1;
    }
    else if (this.age > s.age) {
      return -1;
    }
    else {
      return this.name.compareTo(s.name);
    }

  }
  /* Implement equals.  
   * Two students are equal if both name and age are equal. 
   */
  
  /* Implement compareTo
   * Older students come before younger students.
   * Students of the same age are ordered alphabetically.
   */
}  