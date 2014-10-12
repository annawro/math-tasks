package pl.tasks.web;

import java.io.InputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
public class FileDownloadView {

	private StreamedContent file;

	@ManagedProperty(value = "#{spinnerView}")
	private SpinnerView spinnerView;

	public FileDownloadView() {
		// InputStream stream = ((ServletContext) FacesContext
		// .getCurrentInstance().getExternalContext().getContext())
		// .getResourceAsStream("/test.jpg");

		// file = new DefaultStreamedContent(stream, "application/pdf",
		// "polynomial.pdf");*/
		InputStream stream = ((ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext())
				.getResourceAsStream("/test.jpg");
		file = new DefaultStreamedContent(stream, "image/jpg",
				"test.jpg");

	}

	public StreamedContent getFile() {
		return file;
	}
	
	
	public SpinnerView getSpinnerView() {
		return spinnerView;
	}

	public void setSpinnerView(SpinnerView spinnerView) {
		this.spinnerView = spinnerView;
	}

}
