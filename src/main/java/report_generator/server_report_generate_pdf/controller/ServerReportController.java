package report_generator.server_report_generate_pdf.controller;

//import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import service.ExtraerDatosService;

import java.io.ByteArrayOutputStream;

@CrossOrigin
@RequestMapping("/reportes")
@RestController
public class ServerReportController {

    @Autowired
    private ExtraerDatosService extraerDatosService;

    @GetMapping("/generar_pdf/{ruc}/{codEst}/{codExp}/{reportType}")
    public ResponseEntity<byte[]> generarPdf(@PathVariable("ruc") String ruc,
                                             @PathVariable("codEst") String codEst,
                                             @PathVariable("codExp") String codExp,
                                             @PathVariable("reportType") String reportType) {
        try {
            ByteArrayOutputStream pdfStream = extraerDatosService.generarReporte(ruc, codEst, codExp, reportType);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline; filename=report.pdf");

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentType(org.springframework.http.MediaType.APPLICATION_PDF)
                    .body(pdfStream.toByteArray());
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
