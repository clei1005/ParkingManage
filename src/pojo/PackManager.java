package pojo;

import packstrategy.packStrategy;

import java.util.ArrayList;
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

    public PackManager(List<ParkingBoy> parkingBoy, List<ParkPlace> parkPlaces) {
        this.parkPlaces = parkPlaces;
        this.parkingBoy = parkingBoy;

    }

    public Ticket park(Car car) {
        return strategy.getAvailablePark(parkPlaces).parking(car);
    }

    public PackingManagerReport showReport() {
        PackingManagerReport PackingManagerReport=new PackingManagerReport();
        List<ParkingBoyReport> parkingboyreportList = new ArrayList<ParkingBoyReport>();
        int totalParkNum = 0;
        int totalAvailableNum = 0;
        for (ParkingBoy parkingboy : parkingBoy) {
            ParkingReport report = new ParkingReport();
            ParkingBoyReport parkingBoyReport=parkingboy.showReport() ;
            totalAvailableNum = +parkingBoyReport.getTotalAvailableNum();
            totalParkNum = parkingBoyReport.getTotalParkNum() + totalParkNum;
            parkingboyreportList.add(parkingBoyReport);

        }
        PackingManagerReport.setParkingBoyReportList(parkingboyreportList);
        PackingManagerReport.setTotalAvailableNum(totalAvailableNum);
        PackingManagerReport.setTotalParkNum(totalParkNum);
        return PackingManagerReport;
    }
}
