package pojo;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-14
 * Time: 下午5:00
 * To change this template use File | Settings | File Templates.
 */
public class ParkingReport {
    private String parkno;
    private int parknum;
    private int availablenum;

    public String getParkno() {
        return parkno;
    }

    public void setParkno(String parkno) {
        this.parkno = parkno;
    }

    public int getAvailablenum() {
        return availablenum;
    }

    public void setAvailablenum(int availablenum) {
        this.availablenum = availablenum;
    }

    public int getParknum() {
        return parknum;
    }

    public void setParknum(int parknum) {
        this.parknum = parknum;
    }
}
