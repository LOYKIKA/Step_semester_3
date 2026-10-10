import java.util.*;

interface NotificationChannel {
    void send(String student, String title);
}

class EmailChannel implements NotificationChannel {
    public void send(String student, String title) {
        System.out.println("[Email → " + student + "] " + title);
    }
}

class SmsChannel implements NotificationChannel {
    public void send(String student, String title) {
        System.out.println("[SMS → " + student + "] " + title);
    }
}

class AppChannel implements NotificationChannel {
    public void send(String student, String title) {
        System.out.println("[App → " + student + "] " + title);
    }
}

class Student {
    String name;
    String department;
    List<NotificationChannel> channels = new ArrayList<>();

    Student(String name, String department) {
        this.name = name;
        this.department = department;
    }

    void addChannel(NotificationChannel channel) {
        channels.add(channel);
    }
}

class Notice {
    String title;
    Set<String> departments;

    Notice(String title, Set<String> departments) {
        this.title = title;
        this.departments = departments;
    }

    boolean isValid() {
        return title != null && !title.trim().isEmpty()
                && departments != null && !departments.isEmpty();
    }
}

class NoticeBoard {
    List<Student> students = new ArrayList<>();

    void addStudent(Student student) {
        students.add(student);
    }

    void postNotice(Notice notice) {
        if (!notice.isValid()) {
            System.out.println(
                    "Cannot post notice: At least one target department is required.");
            return;
        }

        System.out.println("Notice '" + notice.title
                + "' posted to " + String.join(", ", notice.departments) + ".");

        for (Student student : students) {
            if (notice.departments.contains(student.department)) {
                for (NotificationChannel channel : student.channels) {
                    channel.send(student.name, notice.title);
                }
            }
        }
    }
}

public class Q5 {
    public static void main(String[] args) {
        NoticeBoard board = new NoticeBoard();

        Student asha = new Student("Asha", "CSE");
        asha.addChannel(new EmailChannel());
        asha.addChannel(new AppChannel());

        Student ravi = new Student("Ravi", "ECE");
        ravi.addChannel(new SmsChannel());

        board.addStudent(asha);
        board.addStudent(ravi);

        board.postNotice(new Notice(
                "Lab Closed Tomorrow",
                new HashSet<>(Arrays.asList("CSE"))));

        board.postNotice(new Notice(
                "Fee Deadline Extended",
                new HashSet<>(Arrays.asList("CSE", "ECE"))));

        board.postNotice(new Notice(
                "Sports Day",
                new HashSet<>()));
    }
}