package pojo;

import packstrategy.packStrategy;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-14
 * Time: 上午9:34
 * To change this template use File | Settings | File Templates.
 */
public class PackManager {
    protected List<ParkingBoy> parkingBoy;
    protected List<ParkPlace> parkPlaces;
    private packStrategy strategy;
    public PackManager(List<ParkingBoy> parkingBoy) {
        this.parkingBoy = parkingBoy;

    }
    public PackManager(List<ParkingBoy> parkingBoy,List<ParkPlace> parkPlaces) {
        this.parkPlaces = parkPlaces;
        this.parkingBoy = parkingBoy;

    }
    public Ticket park(Car car) {
        return strategy.getAvailablePark(parkPlaces).parking(car);
    }

}
