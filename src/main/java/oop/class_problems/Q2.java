enum Status {
    PENDING, APPROVED, REJECTED
}

class LeaveRequest {
    String employee;
    String dates;
    Status status = Status.PENDING;

    LeaveRequest(String employee, String dates) {
        this.employee = employee;
        this.dates = dates;
    }

    void review(boolean approve) {
        if (status != Status.PENDING) {
            System.out.println("Request already reviewed");
            return;
        }

        status = approve ? Status.APPROVED : Status.REJECTED;
        System.out.println(employee + "'s leave " + status);
    }

    void changeStatus(Status newStatus) {
        if (status != Status.PENDING) {
            System.out.println("Cannot change status from " + status);
        } else {
            status = newStatus;
        }
    }
}

public class Q2 {
    public static void main(String[] args) {
        LeaveRequest r1 = new LeaveRequest("John", "Jan 1-5");
        LeaveRequest r2 = new LeaveRequest("Jane", "Feb 10-11");

        System.out.println("Leave request submitted for John");
        System.out.println("Status: " + r1.status);
        r1.review(true);

        System.out.println("Leave request submitted for Jane");
        System.out.println("Status: " + r2.status);
        r2.review(false);

        r1.changeStatus(Status.PENDING);
    }
}