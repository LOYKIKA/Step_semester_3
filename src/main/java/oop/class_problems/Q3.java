import java.util.*;

abstract class Question {
    String question;
    String correctAnswer;
    int marks;

    Question(String question, String answer, int marks) {
        this.question = question;
        this.correctAnswer = answer;
        this.marks = marks;
    }

    abstract boolean evaluate(String answer);
}

class MCQ extends Question {
    MCQ(String q, String a, int m) {
        super(q, a, m);
    }

    boolean evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}

class TrueFalse extends Question {
    TrueFalse(String q, String a, int m) {
        super(q, a, m);
    }

    boolean evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}

class Attempt {
    Map<Question, String> answers = new LinkedHashMap<>();
    boolean submitted = false;

    void answer(Question q, String answer) {
        if (submitted) {
            System.out.println("Cannot change submitted answers");
            return;
        }

        answers.put(q, answer);
        System.out.println("Answer recorded");
    }

    void submit() {
        if (submitted) {
            System.out.println("Exam already submitted");
            return;
        }

        submitted = true;
        int score = 0;
        int total = 0;

        for (Question q : answers.keySet()) {
            total += q.marks;

            if (q.evaluate(answers.get(q))) {
                score += q.marks;
                System.out.println(q.question + ": Correct");
            } else {
                System.out.println(q.question + ": Incorrect");
            }
        }

        System.out.println("Total score: " + score + "/" + total);
    }
}

public class Q3 {
    public static void main(String[] args) {
        Question q1 = new MCQ("Question 1", "C", 5);
        Question q2 = new TrueFalse("Question 2", "False", 5);

        Attempt attempt = new Attempt();

        System.out.println("Exam started");
        attempt.answer(q1, "C");
        attempt.answer(q2, "True");

        attempt.submit();
        attempt.answer(q1, "A");
    }
}