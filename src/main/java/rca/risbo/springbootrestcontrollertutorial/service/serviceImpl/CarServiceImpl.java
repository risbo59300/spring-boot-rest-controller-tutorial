package rca.risbo.springbootrestcontrollertutorial.service.serviceImpl;

import org.springframework.stereotype.Service;
import rca.risbo.springbootrestcontrollertutorial.model.Car;
import rca.risbo.springbootrestcontrollertutorial.service.CarService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarServiceImpl implements CarService {

    private List<Car> cars = new ArrayList<>(Arrays.asList(
            new Car(1L, "Astra", "Opel", 100, 18000d),
            new Car(2L, "Insigna", "Opel", 120, 220000d),
            new Car(3L, "Golf", "VW", 90, 17000d)
    ));

    @Override
    public List<Car> getAllCars() {
        return cars;
    }

    @Override
    public List<Car> getCarsWithPriceFilter(Double min, Double max) {
        return cars
                .stream()
                .filter(car -> car.getPrice() >= min && car.getPrice() <= max)
                .toList();
    }

    @Override
    public Car getById(Long id) {
        return cars
                .stream()
                .filter(car -> car.getId().equals(id))
                .findAny()
                .orElseThrow();
    }

    @Override
    public Car create(Car car) {
        Long newId = cars
                .stream()
                .mapToLong(car_ -> Long.valueOf(car_.getId()))
                .max()
                .orElse(0L) + 1L;
        car.setId(newId);
        cars.add(car);
        return getById(car.getId());
    }

    @Override
    public Car update(Long id, Car carRequest) {
        Car carToBeUpdated = getById(id);
        carToBeUpdated.setBrand(carRequest.getBrand());
        carToBeUpdated.setHorses(carRequest.getHorses());
        carToBeUpdated.setModel(carRequest.getModel());
        carToBeUpdated.setPrice(carRequest.getPrice());
        return carToBeUpdated;
    }

    @Override
    public void delete(Long id) {
        boolean successfullDeletion = cars.
                removeIf(car -> car.getId().equals(id));
        if ( !successfullDeletion) {
            throw new NoSuchElementException();
        }
    }
}
