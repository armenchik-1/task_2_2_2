package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.ServiceImp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {

    private List<Car> cars = new ArrayList<>(Arrays.asList(
            new Car("BMW", "M5", 6335),
            new Car("Audi", "R8", 1422),
            new Car("Мерседес", "S221", 553),
            new Car("КИА", "RIO", 3221),
            new Car("Nissan", "Juke", 1322)));

    @GetMapping
    public String showCars(@RequestParam(value = "count", required = false) Integer carCount
            , ModelMap model) {

        if (carCount != null) {
            List<Car> carList = new ServiceImp().getCars(cars, carCount);
            model.addAttribute("cars", carList);
        } else {
            model.addAttribute("cars", cars);
        }

        return "cars";
    }
}
