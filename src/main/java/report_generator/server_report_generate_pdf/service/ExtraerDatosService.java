package report_generator.server_report_generate_pdf.service;

import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.stereotype.Service;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import report_generator.server_report_generate_pdf.model.DE;

import jakarta.xml.bind.*;
//import report_generator.server_report_generate_pdf.model.NC;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Service
public class ExtraerDatosService {

    private final String BASE_PATH = "G:/Server-report/Reports/";



    public ByteArrayOutputStream generarReporte(String ruc, String codEst, String codExp, String reportType) throws JRException, JAXBException {
        String reporteDir = BASE_PATH + ruc + "/" + codEst + "/" + codExp + "/" + reportType + "/";
        String reportePath;
        String xmlPath;
        if (reportType.equals("factura")) {
            reportePath = reporteDir + "DE_FAC.jasper";
            xmlPath = reporteDir + "DE.xml";
            System.out.println(xmlPath);
        } else {
            reportePath = reporteDir + "DE.jasper";
            xmlPath = reporteDir + "NC.xml";
        }

        DE de = (DE) parseXml(xmlPath);
            JRXmlDataSource xmlDataSource = new JRXmlDataSource(new File(xmlPath), "/root");
            Map<String, Object> parametros = mapearParametros(de, reportType);

            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(reportePath));
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, xmlDataSource);

            ByteArrayOutputStream pdfStream = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, pdfStream);

            return pdfStream;
        }
        public void printXml(Object obj) throws JAXBException {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter sw = new StringWriter();
            marshaller.marshal(obj, sw);
            System.out.println(sw.toString());
        }

        private Object parseXml (String xmlFilePath) throws JAXBException {
            JAXBContext context = JAXBContext.newInstance(DE.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            System.out.println("Proceso de unmarshaller" + xmlFilePath);
            DE de = (DE) unmarshaller.unmarshal(new File(xmlFilePath));
            if (de == null) {
                throw new IllegalArgumentException("El objeto rDE es nulo después del unmarshalling.");
            }
            System.out.println("Unmarshalling exitoso: " + de);
            return de;
        }

        private Map<String, Object> mapearParametros (DE deDatos, String reportType){
            Map<String, Object> parametros = new HashMap<>();

            if ("factura".equals(reportType)) {
                parametros.put("cdc", deDatos.cdc);
                parametros.put("rucEmi", deDatos.getRucEmi()); // Concatenación de rucSinDv y rucConDv
                parametros.put("timbrado", deDatos.timbrado);
                parametros.put("fechaTim", deDatos.fechaTim);
                parametros.put("dsuc", deDatos.dsuc);
                parametros.put("dexp", deDatos.dexp);
                parametros.put("nroFac", deDatos.nroFac);
                parametros.put("fechaDE", deDatos.fechaDE);
                parametros.put("condicion", deDatos.condicion);
                parametros.put("moneda", deDatos.moneda);
                parametros.put("cambio", deDatos.cambio);
                parametros.put("cambioIte", deDatos.cambioIte);
                parametros.put("cdcAsoc", deDatos.cdcAsoc);
                parametros.put("rucCli", deDatos.rucCli);
                parametros.put("cliNom", deDatos.cliNom);
                parametros.put("dire", deDatos.dire);
                parametros.put("tel", deDatos.tel);
                parametros.put("mail", deDatos.mail);
                parametros.put("tipTransac", deDatos.tipTransac);
                parametros.put("subtotal", deDatos.subtotal);
                parametros.put("subtotalMe", deDatos.subtotalMe);
                parametros.put("totalOp", deDatos.totalOp);
                parametros.put("totalOpMe", deDatos.totalOpMe);
                parametros.put("total", deDatos.total);
                parametros.put("totalMe", deDatos.totalMe);
                parametros.put("descuento", deDatos.descuento);
                parametros.put("descuentoMe", deDatos.descuentoMe);
                parametros.put("kude", deDatos.kude);
                parametros.put("cuotas", deDatos.cuotas);
                parametros.put("tipdocAsoc", deDatos.tipdocAsoc);
                parametros.put("tipDE", deDatos.tipDE);
                parametros.put("rucDv", deDatos.rucDv);
                parametros.put("iva5", deDatos.iva5);
                parametros.put("iva5Me", deDatos.iva5Me);
                parametros.put("iva10", deDatos.iva10);
                parametros.put("iva10Me", deDatos.iva10Me);
                parametros.put("totiva", deDatos.totiva);
                parametros.put("totivaMe", deDatos.totivaMe);
                parametros.put("motivo", deDatos.motivo);
                parametros.put("urlLogo", deDatos.urlLogo);
                parametros.put("NomComp", deDatos.NomComp);
                parametros.put("dDirEmi", deDatos.dDirEmi);
                parametros.put("dTelEmi", deDatos.dTelEmi);
                parametros.put("dDesCiuEmi", deDatos.dDesCiuEmi);
                parametros.put("dEmailE", deDatos.dEmailE);
                parametros.put("dDesActEco", deDatos.dDesActEco);
                parametros.put("empresa", deDatos.empresa);
                parametros.put("totGs", deDatos.totGs);
                parametros.put("importeLetra", deDatos.importeLetra);
                parametros.put("cItems", deDatos.cItems);
                parametros.put("totgra10", deDatos.totgra10);
                parametros.put("totgra5", deDatos.totgra5);
                parametros.put("totexe", deDatos.totexe);
                parametros.put("totexeme", deDatos.totexeme);
                parametros.put("totgra10me", deDatos.totgra10me);
                parametros.put("totgra5me", deDatos.totgra5me);
            } else {
                throw new IllegalArgumentException("Tipo de reporte no soportado: " + reportType);
            }
            System.out.println(parametros);
            return parametros;
        }
}