package cc.subnote.springboot.tutorial.beans;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {
    private final FileHandler fileHandler;

    @GetMapping("/write")
    public String writeData(@RequestParam String data) throws IOException {
        fileHandler.writeData(data);
        return "파일에 데이터가 저장되었습니다.";
    }
}