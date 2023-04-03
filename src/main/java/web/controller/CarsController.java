package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarsController {
    private final CarService innerCarService;
    @Autowired
    public CarsController(CarService carService) {
        innerCarService = carService;
    }
    @GetMapping("/cars")
    public String printCars(@RequestParam(name = "count", required = false, defaultValue = "5") int count,
                            ModelMap model) {
        List<Car> carList = innerCarService.getCarList(count);
        model.addAttribute("carList", carList);
        return "cars";
    }
}
