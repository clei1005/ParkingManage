package pojo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-14
 * Time: 下午5:46
 * To change this template use File | Settings | File Templates.
 */
public class ParkingBoyReport {
    private List<ParkingReport> parkingReportList;
    private int totalParkNum;
    private int totalAvailableNum;

    public List<ParkingReport> getParkingReportList() {
        return parkingReportList;
    }

    public void setParkingReportList(List<ParkingReport> parkingReportList) {
        this.parkingReportList = parkingReportList;
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
