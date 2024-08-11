package report_generator.server_report_generate_pdf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@CrossOrigin
@RequestMapping("/hola")
public class ServerReportGeneratePdfApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerReportGeneratePdfApplication.class, args);
        System.out.println("Hello");
    };
};
