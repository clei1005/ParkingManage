package pojo;

import exception.NoCarException;
import exception.ParkFullException;
import packstrategy.packStrategy;
import pojo.Car;
import pojo.ParkPlace;
import pojo.Ticket;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    protected List<ParkPlace> parkPlaces;
    private packStrategy strategy;
    private String parkingBoyNo;

    public String getParkingBoyNo() {
        return parkingBoyNo;
    }

    public void setParkingBoyNo(String parkingBoyNo) {
        this.parkingBoyNo = parkingBoyNo;
    }

    public ParkingBoy(List<ParkPlace> parkPlaces) {
        this.parkPlaces = parkPlaces;

    }

    public ParkingBoy(List<ParkPlace> parkPlaces, packStrategy strategy) {
        this.parkPlaces = parkPlaces;
        this.strategy = strategy;
    }

    public Ticket park(Car car) {
        return strategy.getAvailablePark(parkPlaces).parking(car);
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

    public ParkingBoyReport showReport() {
        ParkingBoyReport parkingBoyReport=new ParkingBoyReport();
        int totalParkNum = 0;
        int totalAvailableNum = 0;
        List<ParkingReport> parkingreportList = new ArrayList<ParkingReport>();
        for (ParkPlace parkPlace : parkPlaces) {

            ParkingReport report = new ParkingReport();
            report.setParkno(parkPlace.getParkPlaceNo());

            report.setAvailablenum(parkPlace.GetAvailableNum());
            totalAvailableNum = +parkPlace.GetAvailableNum();
            report.setParknum(parkPlace.getMaxParkingNum());
            totalParkNum = parkPlace.getMaxParkingNum() + totalParkNum;
            parkingreportList.add(report);

        }
        parkingBoyReport.setTotalAvailableNum(totalAvailableNum);
        parkingBoyReport.setTotalParkNum(totalAvailableNum);
        parkingBoyReport.setParkingReportList(parkingreportList);
        return parkingBoyReport;
    }

}
