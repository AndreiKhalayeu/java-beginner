package task1;

public class ReportCard {
    public static char convertGrades(int testResult) {
        char grade;
        if (testResult >= 90) {
            grade = 'A';
        } else if (testResult >= 80 && testResult < 89) {
            grade = 'B';
        } else {
            grade = 'D';
        }
        return grade;
    }

    public static void main(String[] args) {
        char yourGrade = ReportCard.convertGrades(88);
        System.out.println("Ваша первая оценка " + yourGrade);
        yourGrade = ReportCard.convertGrades(79);
        System.out.println("Ваша вторая оценка " + yourGrade);
    }
}
