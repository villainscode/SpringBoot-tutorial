package cc.subnote.springboot.tutorial.di;

/**
 * Please explain the class!!
 *
 * @author : codevillain
 * @fileName : ReportGeneratorWithDI
 * @since : 2/26/25
 */
public class ReportGeneratorWithDI {
    // ReportGenerator: 외부에서 DataReport 객체를 주입받음
    private DataReport dataReport;

    // 생성자 주입: 외부에서 DataReport를 전달받음
    public ReportGeneratorWithDI(DataReport dataReport) {
        this.dataReport = dataReport;
    }

    public void generateReport() {
        String data = dataReport.getReportData();
        System.out.println("리포트 생성: " + data);
    }
}