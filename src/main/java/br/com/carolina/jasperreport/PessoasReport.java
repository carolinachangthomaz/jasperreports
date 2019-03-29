package br.com.carolina.jasperreport;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;



public class PessoasReport {

	public static void main(String[] args) throws SQLException, JRException, ClassNotFoundException, IOException {
		System.out.println("gerando PDF");
		Class.forName("com.mysql.jdbc.Driver");
		Connection cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/jasperreports", "jasper","jasper");
//		InputStream relatorio = PessoasReport.class.getResourceAsStream("pessoas.jasper");
//		
//		Map<String, Object> parameters = new LinkedHashMap<String, Object>();
//		JasperPrint jp = JasperFillManager.fillReport(relatorio, parameters, cx);
//		
//		JRExporter exporter = new JRPdfExporter();
//		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
//		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "teste.pdf");
//		
//		System.out.println("gerando PDF");
//		
//		exporter.exportReport();
		
//      File tmpDir = File.createTempFile("tmp", "Relartorio");
//		tmpDir.mkdirs();
//		File file1 = new File("MyFolder");
//		System.out.println("tmpDir.getAbsolutePath() " +tmpDir.getAbsolutePath());
//		File file = new File(tmpDir.getAbsolutePath()+ File.separator+ "teste.txt");
//		file1.mkdir();
//		System.out.println("file.getParent()" +file.getParent());
//		new File(file.getParent()).mkdirs();
//		if(!file.exists()) {
//			file.createNewFile();
//		}else {
//			System.out.println("existe file");
//		}
//		
		
		File tmpDir = File.createTempFile("tmp", "Relartorio");
		tmpDir.mkdirs();
		System.out.println("tmpDir.getAbsolutePath() " +tmpDir.getAbsolutePath());
		File file2 = new File(tmpDir.getAbsolutePath()+ File.separator+ "test2.txt");
		tmpDir.mkdir();
		System.out.println("tmpDir.getAbsolutePath() " +file2.getAbsolutePath());
			if(!file2.exists()) {
				file2.createNewFile();
			}else {
				System.out.println("existe file");
			}
		
//		File folder = new File("MyFolder");
//		File file1 = new File(folder.getAbsolutePath()+ File.separator+ "test2.txt");
//		folder.mkdir();
//		
//			if(!file1.exists()) {
//				file1.createNewFile();
//			}else {
//				System.out.println("existe file");
//			}
		
//        InputStream relatorio = PessoasReport.class.getResourceAsStream("pessoas.jasper");
//		
//		Map<String, Object> parameters = new LinkedHashMap<String, Object>();
//		JasperPrint jp = JasperFillManager.fillReport(relatorio, parameters, cx);
//		
//		JRExporter exporter = new JRPdfExporter();
//		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
//		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "teste.pdf");
//		
//		System.out.println("gerando PDF");
		
//		exporter.exportReport();
		
		
		System.out.println("feito");
	}
}
