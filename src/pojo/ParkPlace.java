package pojo;

import exception.NoCarException;
import exception.NoPlaceException;
import pojo.Car;

import java.util.HashMap;
import java.util.Map;

public class ParkPlace {
    private Map<Ticket, Car> parkedCarList = new HashMap<Ticket, Car>();



    private Integer maxParkingNum;
    private String parkPlaceNo;
    private int capacity;

    public ParkPlace(int maxParkingNum) {
        this.maxParkingNum = maxParkingNum;
    }

    public Integer getMaxParkingNum() {
        return maxParkingNum;
    }
    public String getParkPlaceNo() {
        return parkPlaceNo;
    }

    public void setParkPlaceNo(String parkPlaceNo) {
        this.parkPlaceNo = parkPlaceNo;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }





    public Integer GetAvailableNum() {
        return maxParkingNum - parkedCarList.size();
    }


    public Ticket parking(Car c) throws NoPlaceException {
        if (GetAvailableNum() == 0) {
            throw new NoPlaceException("没有停车位了！");
        }
        Ticket ticket = new Ticket();
        parkedCarList.put(ticket, c);

        return ticket;
    }


    public Car GetParkedCar(Ticket pp) throws NoCarException {
        if (parkedCarList.containsKey(pp)) {
            return parkedCarList.remove(pp);
        }
        throw new NoCarException("没有此车 请拨打110！");
    }

    //取车
    public Car fecthCar(Ticket ticket) {

        Car car = parkedCarList.get(ticket);
        if (car != null) {
            parkedCarList.remove(ticket);
        }
        return car;

    }
}
