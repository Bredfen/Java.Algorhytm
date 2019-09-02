public class Grade {
    public int getGrade(int value, int grade){
        int result;

        if (value == 0) return 1;
        if (grade == 1) return value;
        result = getGrade(value,grade-1);
        result *= value;
        return result;

    }
}
class GradeStart{
    public static void main(String[] args) {
        Grade grade = new Grade();
        System.out.println(grade.getGrade(2, 13));
    }
}
