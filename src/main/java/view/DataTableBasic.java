package view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.ReorderEvent;

import model.Car;
import services.CarService;

@Named
@ViewScoped
public class DataTableBasic implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Car> cars;
	private List<Car> cars1;
    private List<Car> cars2;
	
	@Inject
	private CarService service;
	 
    @PostConstruct
    public void init() {
        cars = service.createCars(20);
        cars1 = service.createCars(10);
        cars2 = service.createCars(10);
    }
     
    public List<Car> getCars() {
        return cars;
    }
    
    public List<Car> getCars1() {
        return cars1;
    }
 
    public List<Car> getCars2() {
        return cars2;
    }
 
    public void setService(CarService service) {
        this.service = service;
    }
    
    public void onRowReorder(ReorderEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Row Moved", "From: " + event.getFromIndex() + ", To:" + event.getToIndex());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
