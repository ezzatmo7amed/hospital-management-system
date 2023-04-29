package com.hospital.api;

import com.hospital.api.pdf.PdfGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class HospitalApplication {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    public static void main(String[] args) {
     //   SpringApplication.run(HospitalApplication.class, args);

        ApplicationContext ac = SpringApplication.run(HospitalApplication.class, args);

        PdfGenerator pDFGenerator = ac.getBean("pdfGenerator",PdfGenerator.class);

        pDFGenerator.generatePdfReport();
    }

}
