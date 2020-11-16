package spring.di.entity;

public class NewlecExam implements Exam {

    private int kor;
    private int eng;
    private int math;
    private int com;

    public NewlecExam() {
    }

    public NewlecExam(int kor, int eng, int math, int com) {
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.com = com;
    }

    @Override
    public int total() {
        return kor+eng+math+com;
    }

    @Override
    public float avg() {
        return total() / 4.0f;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public void setCom(int com) {
        this.com = com;
    }

    @Override
    public String toString() {
        return "NewlecEcam{" +
                "kor=" + kor +
                ", eng=" + eng +
                ", math=" + math +
                ", com=" + com +
                '}';
    }
}
