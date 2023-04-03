package web.model;

import java.util.Objects;

public class Car {
    private final String innerModel;
    private final String innerSeries;
    private final int innerProductionYear;

    public Car(String model, String series, int productionYear) {
        innerModel = model;
        innerSeries = series;
        innerProductionYear = productionYear;
    }

    public String getInnerModel() {
        return innerModel;
    }


    public String getInnerSeries() {
        return innerSeries;
    }


    public int getInnerProductionYear() {
        return innerProductionYear;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getInnerProductionYear() == car.getInnerProductionYear()
                && Objects.equals(getInnerModel(), car.getInnerModel())
                && Objects.equals(getInnerSeries(), car.getInnerSeries());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInnerModel(), getInnerSeries(), getInnerProductionYear());
    }
}
