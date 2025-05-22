package cc.subnote.springboot.tutorial.di;

// 실행 클래스
public class DIMain {
    public static void main(String[] args) {
        // 외부에서 DataReport 객체를 생성
        DataReport dataReport = new DataReport();
        // ReportGenerator에 주입하여 사용 → ReportGenerator는 DataReport의 생성에 관여하지 않음
        ReportGeneratorWithDI generator = new ReportGeneratorWithDI(dataReport);
        generator.generateReport();

        /**
         * // 기존 DataReport 대신 TestDataReport 객체를 생성하여 주입
         * // (DataReport와 TestDataReport의 메서드 시그니처가 동일해야 함)
         * TestDataReport testDataReport = new TestDataReport();
         * ReportGenerator generator = new ReportGenerator(testDataReport);
         * generator.generateReport(); // 출력 - 리포트 생성: 테스트용 데이터
         */
    }
}