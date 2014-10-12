package pl.tasks.web;

import javax.annotation.PostConstruct;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.generator.polynomial.PolynomialsGenerator;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import pl.tasks.model.Polynomial;

@ManagedBean
@RequestScoped
public class ChartView implements Serializable {

	private static final long serialVersionUID = 1L;
	private LineChartModel lineModel;

	@ManagedProperty(value = "#{spinnerView}")
	private SpinnerView spinnerView;

	@PostConstruct
	public void init() {
		createLineModels();
	}

	public LineChartModel getLineModel() {
		return lineModel;
	}

	private void createLineModels() {
		lineModel = initLinearModel();
		lineModel.setTitle("Polynomial Chart");
		lineModel.setLegendPosition("e");
		Axis yAxis = lineModel.getAxis(AxisType.Y);
		yAxis.setMin(-25);
		yAxis.setMax(75);
	}

	private LineChartModel initLinearModel() {
		LineChartModel model = new LineChartModel();

		Polynomial polynomial = spinnerView.getPolynomial();
		PolynomialsGenerator polynomialValue = new PolynomialsGenerator();

		System.out.println(polynomialValue.toString());
		LineChartSeries series1 = new LineChartSeries();
		series1.setLabel("Chart of the polynomial");

		series1.set(-1,
				polynomialValue.valueOfPolynomialInPoint(polynomial, -1.0));
		series1.set(-2,
				polynomialValue.valueOfPolynomialInPoint(polynomial, -2.0));
		series1.set(-3,
				polynomialValue.valueOfPolynomialInPoint(polynomial, -3.0));
		series1.set(-4,
				polynomialValue.valueOfPolynomialInPoint(polynomial, -4.0));
		series1.set(-5,
				polynomialValue.valueOfPolynomialInPoint(polynomial, -5.0));
		series1.set(-8,
				polynomialValue.valueOfPolynomialInPoint(polynomial, -8.0));
		series1.set(0,
				polynomialValue.valueOfPolynomialInPoint(polynomial, 0.0));
		series1.set(1,
				polynomialValue.valueOfPolynomialInPoint(polynomial, 1.0));
		series1.set(2,
				polynomialValue.valueOfPolynomialInPoint(polynomial, 2.0));
		series1.set(3,
				polynomialValue.valueOfPolynomialInPoint(polynomial, 3.0));
		series1.set(4,
				polynomialValue.valueOfPolynomialInPoint(polynomial, 4.0));
		series1.set(10,
				polynomialValue.valueOfPolynomialInPoint(polynomial, 10.0));
		series1.set(9,
				polynomialValue.valueOfPolynomialInPoint(polynomial, 9.0));
		series1.set(8,
				polynomialValue.valueOfPolynomialInPoint(polynomial, 8.0));
		series1.set(5,
				polynomialValue.valueOfPolynomialInPoint(polynomial, 5.0));

		model.addSeries(series1);

		return model;
	}

	public SpinnerView getSpinnerView() {
		return spinnerView;
	}

	public void setSpinnerView(SpinnerView spinnerView) {
		this.spinnerView = spinnerView;
	}

}
