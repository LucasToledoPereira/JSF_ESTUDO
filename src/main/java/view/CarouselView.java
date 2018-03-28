package view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Car;
import services.CarService;

@Named
@ViewScoped
public class CarouselView implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Car> cars;
    
    private Car selectedCar;
     
    @Inject
    private CarService service;
     
    @PostConstruct
    public void init() {
        cars = service.createCars(9);
    }
 
    public List<Car> getCars() {
        return cars;
    }
 
    public void setService(CarService service) {
        this.service = service;
    }
 
    public Car getSelectedCar() {
        return selectedCar;
    }
 
    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }
}
