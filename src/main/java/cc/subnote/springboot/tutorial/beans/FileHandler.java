package cc.subnote.springboot.tutorial.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class FileHandler {
    private FileWriter fileWriter;

    @PostConstruct
    public void init() throws IOException {
        File file = new File("sample.txt");
        fileWriter = new FileWriter(file, true);
        fileWriter.write("초기화: 파일이 열렸습니다.\n");
        fileWriter.flush();
        System.out.println("파일 열림");
    }

    public void writeData(String data) throws IOException {
        fileWriter.write(data + "\n");
        fileWriter.flush();
    }

    @PreDestroy
    public void cleanup() throws IOException {
        fileWriter.write("소멸: 파일이 닫힙니다.\n");
        fileWriter.close();
        System.out.println("파일 닫힘");
    }
}