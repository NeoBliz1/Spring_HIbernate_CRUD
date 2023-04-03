package web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
@Service
public class CarService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarService.class);
    private final List<Car> carList = new ArrayList<>();

    public CarService() {
        LOGGER.info("Create cars");
        carList.add(new Car("Tesla", "ModelS", 2020));
        carList.add(new Car("Tesla", "ModelT", 2022));
        carList.add(new Car("Porsche", "911", 2014));
        carList.add(new Car("Mazda", "Miata", 2002));
        carList.add(new Car("Mazda", "RX-8", 2012));
    }

    public List<Car> getCarList(int count) {
        if (count >= carList.size()) {
            return carList;
        } else {
            return carList.subList(0, count);
        }
    }
}
