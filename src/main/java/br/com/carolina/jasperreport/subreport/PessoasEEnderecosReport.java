package br.com.carolina.jasperreport.subreport;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedHashMap;
import java.util.Map;

import br.com.carolina.jasperreport.PessoasReport;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class PessoasEEnderecosReport {

	public static void main(String[] args) throws Exception {
		System.out.println("gerando PDF");
		Class.forName("com.mysql.jdbc.Driver");
		Connection cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/jasperreports", "jasper","jasper");
		InputStream theReport = compileReport();
		
		
		Map<String, Object> parameters = new LinkedHashMap<String, Object>();
		JasperPrint jp = JasperFillManager.fillReport(theReport, parameters, cx);
		
		JRExporter exporter = new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "teste34.pdf");
		
		System.out.println("gerando PDF");
		
		exporter.exportReport();
		
		System.out.println("feito");
	}
	
	public static InputStream compileReport() throws Exception{
		
        InputStream isPCC = PessoasEEnderecosReport.class.getResourceAsStream("pessoas.jrxml");
        
        
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		JasperCompileManager.compileReportToStream(isPCC, output);
		byte[] compilereportsData = output.toByteArray();
		//FileOutputStream filePCC = new FileOutputStream("pessoasEEnderecosDetalhe.jasper");
		//filePCC.write(compilereportsData);
		
		//filePCC.close();
		
		return new ByteArrayInputStream(compilereportsData);
	}
}
