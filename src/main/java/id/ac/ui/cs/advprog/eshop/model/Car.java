package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Car implements Product {
    private String carId;
    private String carName;
    private String carColor;
    private int carQuantity;

    public String getId() {
        return this.getCarId();
    }

    public void setId(String carId){
        this.setCarId(carId);
    }

    @Override
    public String getName() {
        return this.getCarName();
    }

    @Override
    public void setName(String carName){
        this.setCarName(carName);
    }

    @Override
    public int getQuantity(){
        return this.getCarQuantity();
    }

    @Override
    public void setQuantity(int carQuantity){
        this.setCarQuantity(carQuantity);
    }


}
