import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

abstract class Assignment {
    String title;
    double maxMarks;
    LocalDate dueDate;

    Assignment(String title, double maxMarks, LocalDate dueDate) {
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDate = dueDate;
    }

    abstract double applyPenalty(double marks, long lateDays);
}

class CodingAssignment extends Assignment {
    CodingAssignment(String title, double marks, LocalDate due) {
        super(title, marks, due);
    }

    double applyPenalty(double marks, long lateDays) {
        return Math.max(0, marks * (1 - 0.10 * lateDays));
    }
}

class WrittenAssignment extends Assignment {
    WrittenAssignment(String title, double marks, LocalDate due) {
        super(title, marks, due);
    }

    double applyPenalty(double marks, long lateDays) {
        return Math.max(0, marks * (1 - 0.20 * lateDays));
    }
}

class Submission {
    String student;
    Assignment assignment;
    LocalDate submittedDate;
    private String status = "Submitted";

    Submission(String student, Assignment assignment, LocalDate date) {
        this.student = student;
        this.assignment = assignment;
        this.submittedDate = date;

        long lateDays = Math.max(0,
                ChronoUnit.DAYS.between(assignment.dueDate, date));

        System.out.println(student + "'s submission for '"
                + assignment.title + "' received ("
                + (lateDays == 0 ? "on time" : lateDays + " days late")
                + "). Status: " + status);
    }

    void grade(double marks) {
        if (!status.equals("Submitted")) {
            System.out.println("Cannot grade this submission again.");
            return;
        }

        long lateDays = Math.max(0,
                ChronoUnit.DAYS.between(assignment.dueDate, submittedDate));

        double finalMarks = assignment.applyPenalty(marks, lateDays);
        double penalty = marks - finalMarks;

        System.out.printf("%s graded: %.2f/%.0f%n",
                student, finalMarks, assignment.maxMarks);

        if (lateDays > 0) {
            System.out.printf("Late penalty: %.0f%%%n",
                    penalty / marks * 100);
        }

        status = "Graded";
    }

    void resubmit() {
        if (status.equals("Graded")) {
            System.out.println("Cannot resubmit: '" +
                    assignment.title + "' has already been graded.");
        } else {
            System.out.println("Resubmission allowed.");
        }
    }
}

public class Q2 {
    public static void main(String[] args) {
        Assignment a1 = new CodingAssignment(
                "Linked List Lab", 50,
                LocalDate.of(2026, 3, 10));

        Assignment a2 = new WrittenAssignment(
                "Design Essay", 50,
                LocalDate.of(2026, 3, 12));

        Submission s1 = new Submission(
                "Asha", a1, LocalDate.of(2026, 3, 10));

        Submission s2 = new Submission(
                "Ravi", a2, LocalDate.of(2026, 3, 14));

        s1.grade(45);
        s2.grade(40);
        s1.resubmit();
    }
}