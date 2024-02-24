package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Repository
public class CarRepositoryRead {
    List<Car> carData = new ArrayList<>();

    public Iterator<Car> findAll(){
        return carData.iterator();
    }

    public Car findById(String id){
        for (Car car: carData){
            if (car.getCarId().equals(id)){
                return car;
            }
        }
        return null;
    }
}
