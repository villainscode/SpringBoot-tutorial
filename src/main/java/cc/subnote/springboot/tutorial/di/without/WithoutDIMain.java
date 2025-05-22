package cc.subnote.springboot.tutorial.di.without;

// 실행 클래스
public class WithoutDIMain {
    public static void main(String[] args) {
        ReportGenerator generator = new ReportGenerator();
        generator.generateReport();
    }
}