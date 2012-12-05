import java.util.List;

public class ParkingBoy {
    protected List<ParkPlace> parkPlaces;


    public ParkingBoy(List<ParkPlace> parkPlacesr) {
        this.parkPlaces = parkPlaces;

    }

    public Ticket park(Car car, ParkPlace parkplace) {
        return parkplace.parking(car);
    }

    public Integer getAvailableNum() {
        int availableNum = 0;
        for (ParkPlace parkPlace : parkPlaces) {
            availableNum += parkPlace.GetAvailableNum();
        }
        return availableNum;
    }

    //获取最多空闲车位的车场
    public ParkPlace MaxAvailableParkingLotChooser() {

        int maxsizeIndex = 0;

        for (int i = 1; i < parkPlaces.size(); i++) {
            if (parkPlaces.get(i).GetAvailableNum() > parkPlaces.get(maxsizeIndex).GetAvailableNum())
                maxsizeIndex = i;
        }
        if (parkPlaces.get(maxsizeIndex).GetAvailableNum() == 0) throw new ParkFullException("所有的停车场都已满");
        return parkPlaces.get(maxsizeIndex);

    }

    //取车
    public Car fetch(Ticket ticket) {
        Car fetchedCar = null;
        for (ParkPlace parkPlace : parkPlaces) {
            fetchedCar = parkPlace.fecthCar(ticket);
            if (fetchedCar != null) {
                return fetchedCar;
            }
        }
        throw new NoCarException("没有此车");
    }

}
