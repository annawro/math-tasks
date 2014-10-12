package pl.tasks.web;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="bean")
public class Bean {

	private boolean disable;

	public String button1(){
		return "result";
	}
	
	
	public Bean() {
		this.disable = false;
	}

	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

}
