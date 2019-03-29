package br.com.carolina.jasperreport;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class PessoasReportCompiler {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, JRException, IOException {
		System.out.println("gerando PDF");
		Class.forName("com.mysql.jdbc.Driver");
		Connection cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/jasperreports", "jasper","jasper");
		InputStream jrxml = PessoasReport.class.getResourceAsStream("pessoas.jrxml");
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		JasperCompileManager.compileReportToStream(jrxml, output);
		
		byte[] compilereportsData = output.toByteArray();
		output.close();
		
		Map<String, Object> parameters = new LinkedHashMap<String, Object>();
		JasperPrint jp = JasperFillManager.fillReport(new ByteArrayInputStream(compilereportsData), parameters, cx);
		
		JRExporter exporter = new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "teste2.pdf");
		
		System.out.println("gerando PDF");
		
		exporter.exportReport();
		
		System.out.println("feito");

	}

}
