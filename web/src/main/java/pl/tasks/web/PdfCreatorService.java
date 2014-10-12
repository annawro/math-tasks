package pl.tasks.web;

import java.awt.Graphics2D;
import java.io.FileOutputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

@ManagedBean
@ViewScoped
public class PdfCreatorService {

	@ManagedProperty(value = "#{spinnerView}")
	private SpinnerView spinnerView;

	public void print(String file) {
		Document document = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream(file));
			document.open();
			addTitlePage(document);
			PdfContentByte cb = writer.getDirectContent();
			@SuppressWarnings("deprecation")
			Graphics2D graphics2D = cb.createGraphics(PageSize.A5.getWidth(),
					PageSize.A4.getHeight());
			graphics2D.drawString("Hello World", 80, 54);
			graphics2D.dispose();
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addTitlePage(Document document) throws DocumentException {
		Paragraph preface = new Paragraph();
		addEmptyLine(preface, 1);
		Paragraph title = new Paragraph("Polynomials", new Font(
				Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD));
		title.setAlignment(Element.ALIGN_CENTER);
		preface.add(title);
		addEmptyLine(preface, 1);
		preface.add(new Paragraph("The generated polynomial: "
				+ getSpinnerView().getPolynomial(), new Font(
				Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL)));
		addEmptyLine(preface, 3);
		Paragraph paragraph = new Paragraph("The graph of the polynomial",
				new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL));
		paragraph.setAlignment(Element.ALIGN_CENTER);
		preface.add(paragraph);
		document.add(preface);
		document.newPage();
	}

	private void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

	public SpinnerView getSpinnerView() {
		return spinnerView;
	}

	public void setSpinnerView(SpinnerView spinnerView) {
		this.spinnerView = spinnerView;
	}

}
