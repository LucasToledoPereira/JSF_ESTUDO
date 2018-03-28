package view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ButtonsView implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void buttonAction(ActionEvent actionEvent) {
        addMessage("Welcome to Primefaces!!");
    }
	
	public void save(ActionEvent actionEvent) {
        addMessage("Data saved");
    }
     
    public void update(ActionEvent actionEvent) {
        addMessage("Data updated");
    }
     
    public void delete(ActionEvent actionEvent) {
        addMessage("Data deleted");
    }
     
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
