package net.harunote.springboottutorial.di;

import net.harunote.springboottutorial.di.without.ReportGenerator;

// 실행 클래스
public class DIMain {
    public static void main(String[] args) {
        // 외부에서 DataReport 객체를 생성
        DataReport dataReport = new DataReport();
        // ReportGenerator에 주입하여 사용 → ReportGenerator는 DataReport의 생성에 관여하지 않음
        ReportGeneratorWithDI generator = new ReportGeneratorWithDI(dataReport);
        generator.generateReport();
    }
}