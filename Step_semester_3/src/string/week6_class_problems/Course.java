package string.week6_class_problems;

public class Course {

    String code;
    String title;
    int credits;
    int labCredits;

    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    public int totalCredits() {
        return credits + labCredits;
    }

    public static void main(String[] args) {

        Course course1 = new Course("CS101", "Java Programming", 4);
        Course course2 = new Course("CS102", "Java Lab", 3, 1);

        System.out.println("Course 1 total credits: " + course1.totalCredits());
        System.out.println("Course 2 total credits: " + course2.totalCredits());
    }
}