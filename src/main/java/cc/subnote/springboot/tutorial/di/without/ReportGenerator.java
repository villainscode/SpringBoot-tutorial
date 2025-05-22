package cc.subnote.springboot.tutorial.di.without;

import cc.subnote.springboot.tutorial.di.DataReport;

// ReportGenerator: 리포트를 생성하는 클래스
public class ReportGenerator {
    // 내부에서 DataReport 객체를 직접 생성함 → 강한 결합
    private DataReport dataReport = new DataReport();
    //private TestDataReport dataReport = new TestDataReport();

    public void generateReport() {
        // ReportGenerator가 DataReport의 동작을 직접 결정함
        String data = dataReport.getReportData();
        System.out.println("리포트 생성: " + data);
    }
}