package rca.risbo.springbootrestcontrollertutorial.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import rca.risbo.springbootrestcontrollertutorial.model.Car;
import rca.risbo.springbootrestcontrollertutorial.service.CarService;

import java.util.List;

@RestController
@RequestMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarRestController {

    private final CarService carService;

    @Autowired
    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAll() {
        return carService.getAllCars();
    }

    @GetMapping(params = {"minPrice", "maxPrice"})
    public List<Car> getAllFilterdByPrice(
            @RequestParam @Positive(message = "minPrice parameter must be greater than zero") Double minPrice,
            @RequestParam @Positive(message = "maxPrice parameter must be greater than zero") Double maxPrice)
    {
        return carService.getCarsWithPriceFilter(minPrice, maxPrice);
    }

    @GetMapping("/{id}")
    public Car getById(@PathVariable Long id) {
        return  carService.getById(id);
    }

    @PostMapping
    public Car createCar(@Valid @RequestBody Car car) {
        return carService.create(car);
    }

    @PutMapping("/{id}")
    public Car updateCar(@RequestBody Car car, @PathVariable Long id) {
        return carService.update(id, car);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable Long id) {
        carService.delete(id);
    }


}
