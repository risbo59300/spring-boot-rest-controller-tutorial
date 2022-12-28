package rca.risbo.springbootrestcontrollertutorial.service;

import rca.risbo.springbootrestcontrollertutorial.model.Car;

import java.util.List;

public interface CarService {

    /**
     * Retrieve allcars currently existing
     * @return
     */
    List<Car> getAllCars();

    /**
     *
     * @param min
     * @param max
     * @return A list of cars with price inside [min, max]
     */
    List<Car> getCarsWithPriceFilter(Double min, Double max);

    /**
     *
     * @param id The id of the car
     * @return The car with the matching id
     */
    Car getById(Long id);

    /**
     *
     * @param id The id of the car to updated
     * @param carRequest The car object to be updated
     * @return The updated car
     */
    Car update(Long id, Car carRequest);

    /**
     *
     * @param car The car object to be created
     * @return The car object that was created
     */
    Car create(Car car);

    /**
     *
     * @param id The id of the car to be deleted
     */
    void delete(Long id);




}
