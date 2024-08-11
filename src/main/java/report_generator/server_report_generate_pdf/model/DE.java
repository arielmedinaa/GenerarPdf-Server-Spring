package report_generator.server_report_generate_pdf.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "DE")
public class DE {

    @XmlElement(name = "dDVId")
    public String cdc;

    @XmlElement(name = "dRucEm")
    public String rucSinDv;

    @XmlElement(name = "dDVEmi")
    public String rucConDv;

    public String getRucEmi() {
        return rucSinDv + "-" + rucConDv;
    }

    @XmlElement(name = "dNumDoc")
    public String nroFac;

    @XmlElement(name = "dNumTim")
    public Integer timbrado;

    @XmlElement(name = "dFeIniT")
    public Date fechaTim;

    @XmlElement(name = "dEst")
    public String dsuc;

    @XmlElement(name = "dPunExp")
    public String dexp;

    @XmlElement(name = "dFeEmiDE")
    public Date fechaDE;

    @XmlElement(name = "dCondTiCam")
    public String condicion;

    @XmlElement(name = "dDesMoneOpe")
    public String moneda;

    @XmlElement(name = "dTiCam")
    public String cambio;

    @XmlElement(name = "cambioIte")
    public String cambioIte;

    @XmlElement(name = "cdcAsoc")
    public String cdcAsoc;

    @XmlElement(name = "dRucRec")
    public String rucCli;

    @XmlElement(name = "dNomRec")
    public String cliNom;

    @XmlElement(name = "dDirEmi")
    public String dire;

    @XmlElement(name = "dTelEmi")
    public String tel;

    @XmlElement(name = "dEmailRec")
    public String mail;

    @XmlElement(name = "iTipTra")
    public String tipTransac;

    @XmlElement(name = "dTotBruOpeItem")
    public String subtotal;

    @XmlElement(name = "dTotOpeGs")
    public String subtotalMe;

    @XmlElement(name = "dTotOpe")
    public String totalOp;

    @XmlElement(name = "dTotalGs")
    public String totalOpMe;

    @XmlElement(name = "dTotGralOpe")
    public String total;

    @XmlElement(name = "dTotIVA")
    public String totalMe;

    @XmlElement(name = "dTotDesc")
    public String descuento;

    @XmlElement(name = "descuentoMe")
    public String descuentoMe;

    @XmlElement(name = "kude")
    public String kude;

    @XmlElement(name = "dDCondOpe")
    public String cuotas;

    @XmlElement(name = "dDesTiDE")
    public String tipdocAsoc;

    @XmlElement(name = "iTiDE")
    public String tipDE;

    @XmlElement(name = "dDesTImp")
    public String rucDv;

    @XmlElement(name = "dIVA5")
    public String iva5;

    @XmlElement(name = "dBaseGrav5")
    public String iva5Me;

    @XmlElement(name = "dIVA10")
    public String iva10;

    @XmlElement(name = "dBaseGrav10")
    public String iva10Me;

    @XmlElement(name = "dTotIVA")
    public String totiva;

    @XmlElement(name = "dTotGs")
    public String totivaMe;

    @XmlElement(name = "motivo")
    public String motivo;

    @XmlElement(name = "urlLogo")
    public String urlLogo;

    @XmlElement(name = "dNomEmi")
    public String NomComp;

    @XmlElement(name = "dDirEmi")
    public String dDirEmi;

    @XmlElement(name = "dTelEmi")
    public String dTelEmi;

    @XmlElement(name = "dDesCiuEmi")
    public String dDesCiuEmi;

    @XmlElement(name = "dEmailE")
    public String dEmailE;

    @XmlElement(name = "dDesActEco")
    public String dDesActEco;

    @XmlElement(name = "dNomEmi")
    public String empresa;

    @XmlElement(name = "dTotalGs")
    public Long totGs;

    @XmlElement(name = "importeLetra")
    public String importeLetra;

    @XmlElement(name = "cItems")
    public Integer cItems;

    @XmlElement(name = "dSub10")
    public Long totgra10;

    @XmlElement(name = "dSub5")
    public Long totgra5;

    @XmlElement(name = "dSubExe")
    public Long totexe;

    @XmlElement(name = "totexeme")
    public Double totexeme;

    @XmlElement(name = "dSub10")
    public Double totgra10me;

    @XmlElement(name = "dSub5")
    public Double totgra5me;
}