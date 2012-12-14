package pojo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-14
 * Time: 下午6:02
 * To change this template use File | Settings | File Templates.
 */
public class PackingManagerReport {
    private List<ParkingBoyReport> parkingBoyReportList;
    private int totalParkNum;
    private int totalAvailableNum;

    public List<ParkingBoyReport> getParkingBoyReportList() {
        return parkingBoyReportList;
    }

    public void setParkingBoyReportList(List<ParkingBoyReport> parkingBoyReportList) {
        this.parkingBoyReportList = parkingBoyReportList;
    }

    public int getTotalParkNum() {
        return totalParkNum;
    }

    public void setTotalParkNum(int totalParkNum) {
        this.totalParkNum = totalParkNum;
    }

    public int getTotalAvailableNum() {
        return totalAvailableNum;
    }

    public void setTotalAvailableNum(int totalAvailableNum) {
        this.totalAvailableNum = totalAvailableNum;
    }
}
