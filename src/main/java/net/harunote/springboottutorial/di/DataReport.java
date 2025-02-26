package net.harunote.springboottutorial.di;

// DataFetcher: 데이터를 가져오는 역할을 수행하는 구체 클래스
public class DataReport {
    public String getReportData() {
        // 실제 데이터베이스나 외부 API에서 데이터를 가져온다고 가정
        return "데이터베이스의 데이터";
    }
}