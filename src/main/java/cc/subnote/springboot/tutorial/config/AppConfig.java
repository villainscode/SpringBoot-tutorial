package cc.subnote.springboot.tutorial.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("modelMapperAppConfig")
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();    
    }
}