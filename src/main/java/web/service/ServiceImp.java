package web.service;

import web.model.Car;

import java.util.List;

public class ServiceImp implements web.service.Service {

    @Override
    public List<Car> getCars(List<Car> list, Integer count) {
        return list.stream().limit(count).toList();
    }
}
