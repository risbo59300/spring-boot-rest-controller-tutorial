package rca.risbo.springbootrestcontrollertutorial.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private Long id;
    private String model;
    private String brand;
    private Integer horses;
    private Double price;

    @NotNull(message = "Model must not be null")
    @NotEmpty(message = "Model must have value")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @NotNull(message = "Brand must not be null")
    @NotEmpty(message = "Brand must have value")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @NotNull(message = "Horses must not be null")
    @Positive
    public Integer getHorses() {
        return horses;
    }

    public void setHorses(Integer horses) {
        this.horses = horses;
    }

    @NotNull(message = "Price must not be null")
    @Positive
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
