package pl.tasks.web;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfCreator {

	public static void main(String[] args) {
		Document document = new Document();

		try {
			PdfWriter.getInstance(document, new FileOutputStream("FirstPdf.pdf"));
			document.open();

			Image image1 = Image.getInstance("test.jpg");
	        document.add(image1);

			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
