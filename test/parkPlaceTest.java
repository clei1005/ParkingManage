import exception.NoCarException;
import exception.NoPlaceException;
import org.junit.Assert;
import org.junit.Test;
import packstrategy.FirstAvailableParkingStrategy;
import packstrategy.MaxAvailableParkingStrategy;
import packstrategy.packStrategy;
import pojo.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 51ibm
 * Date: 12-11-11
 * Time: 下午3:10
 * To change this template use File | Settings | File Templates.
 */
public class parkPlaceTest {

    @Test
    public void parkPlace_Parking_HavePlace() {

        ParkPlace PP = new ParkPlace(20);
        Car C = new Car();
        Ticket proof = PP.parking(C);
        Assert.assertNotNull(proof);
    }

    @Test(expected = NoPlaceException.class)
    public void parkPlace_Parking_NoPlace() {
        ParkPlace PP = new ParkPlace(1);
        PP.parking(new Car());
        Ticket proof = PP.parking(new Car());
        Assert.assertFalse(true);
    }

    @Test
    public void parkPlace_GetCar() {

        ParkPlace PP = new ParkPlace(20);
        Car car = new Car();
        Ticket proof = PP.parking(car);

        Assert.assertSame(car, PP.GetParkedCar(proof));

    }

    @Test(expected = NoCarException.class)
    public void parkPlace_GetCar_NoThisCar() {

        ParkPlace PP = new ParkPlace(20);
        Ticket proof = PP.parking(new Car());
        PP.GetParkedCar(proof);

        PP.GetParkedCar(proof);

    }

    @Test
    public void parkPlace_ShowAvailableNum() {
        int maxParkingNum = 20;
        ParkPlace PP = new ParkPlace(maxParkingNum);
        PP.parking(new Car());
        PP.parking(new Car());
        Assert.assertEquals(Integer.valueOf(maxParkingNum - 2), PP.GetAvailableNum());
    }


    //作为一个停车员，我需要管理多个停车场；

    //  以便停车的时候，我可以快速的停进有空车位的停车场；取车的时候我能取到正确的车辆。

    //策略方式
    @Test
    public void parkBoy_ShouldParkCar(packStrategy strategy) {
        if (strategy == null)
            strategy = new FirstAvailableParkingStrategy();


        Car car = new Car();
        int maxParkingNum = 20;
        ParkPlace parkPlace = new ParkPlace(maxParkingNum);
        ArrayList<ParkPlace> parkPlaces = new ArrayList<ParkPlace>();
        parkPlaces.add(parkPlace);
        ParkingBoy parkingBoy = new ParkingBoy(parkPlaces, strategy);
        Ticket ticket = parkingBoy.park(car);
        Assert.assertEquals(new Integer(maxParkingNum - 1), parkingBoy.getAvailableNum());

    }

    /*取车---

   * */
    @Test
    public void parkBoy_ShouldfetchCar() {
        Car car = new Car();
        int maxParkingNum = 20;
        ParkPlace parkPlace = new ParkPlace(maxParkingNum);
        ArrayList<ParkPlace> parkPlaces = new ArrayList<ParkPlace>();
        parkPlaces.add(parkPlace);
        ParkingBoy parkingBoy = new ParkingBoy(parkPlaces);
        Ticket ticket = parkingBoy.park(car, parkPlace);
        Assert.assertSame(car, parkingBoy.fetch(ticket));
    }
    //------------end-------------/

    //作为一个停车员，我需要管理多个停车场；

    //  以便停车的时候，停入到最空闲的车场。

    //策略模式
    @Test
    public void parkBoy_ShouldPark_mostAvailableCar(packStrategy strategy) {
        if (strategy == null)
            strategy = new MaxAvailableParkingStrategy();
        Car car = new Car();
        int maxParkingNum = 20;
        ParkPlace parkPlace = new ParkPlace(maxParkingNum);
        ArrayList<ParkPlace> parkPlaces = new ArrayList<ParkPlace>();

        ParkingBoy parkingBoy = new ParkingBoy(parkPlaces, strategy);
        Ticket ticket = parkingBoy.park(car);
        Assert.assertEquals(new Integer(maxParkingNum - 1), parkingBoy.getAvailableNum());

    }
    //------------end-------------/

    //作为停车场的经理（Parking Manager），我要管理多个停车仔，让他们停车，同时也可以自己随机停车

    //让停车仔停车
    //策略模式

    @Test
    public void parkManager_ShouldPark_byParkingBoy(packStrategy strategy) {
        if (strategy == null)
            strategy = new MaxAvailableParkingStrategy();
        Car car = new Car();
        int maxParkingNum = 20;
        ParkPlace parkPlace = new ParkPlace(maxParkingNum);
        ArrayList<ParkPlace> parkPlaces = new ArrayList<ParkPlace>();
        ParkingBoy parkingBoy = new ParkingBoy(parkPlaces, strategy);
        ArrayList<ParkingBoy> parkingBoys = new ArrayList<ParkingBoy>();

        PackManager packManager = new PackManager(parkingBoys);
        Ticket ticket = packManager.park(car);
        Assert.assertEquals(new Integer(maxParkingNum - 1), parkingBoy.getAvailableNum());

    }

    //------------end-------------/

    //作为停车场的经理（Parking Manager），我要管理多个停车仔，让他们停车，同时也可以自己随机停车

    //自己停车
    //策略模式

    @Test
    public void parkManager_ShouldPark_byOwn(packStrategy strategy) {
        if (strategy == null)
            strategy = new MaxAvailableParkingStrategy();
        Car car = new Car();
        int maxParkingNum = 20;
        ParkPlace parkPlace = new ParkPlace(maxParkingNum);
        ArrayList<ParkPlace> parkPlaces = new ArrayList<ParkPlace>();
        ParkingBoy parkingBoy = new ParkingBoy(parkPlaces, strategy);
        ArrayList<ParkingBoy> parkingBoys = new ArrayList<ParkingBoy>();

        PackManager packManager = new PackManager(parkingBoys, parkPlaces);
        Ticket ticket = packManager.park(car);
        Assert.assertEquals(new Integer(maxParkingNum - 1), parkingBoy.getAvailableNum());
    }

    //作为停车场的主管（Parking Director），我希望看到一张报表，其中包括经理和每个停车仔所管理的车
    // 停车仔
    @Test
    public void parkBoy_ReviewReport() {
        Car car = new Car();
        int maxParkingNum = 20;
        ParkPlace parkPlace = new ParkPlace(maxParkingNum);
        ArrayList<ParkPlace> parkPlaces = new ArrayList<ParkPlace>();
        ParkingBoy parkingBoy = new ParkingBoy(parkPlaces);
        Ticket ticket = parkingBoy.park(car);
        Assert.assertEquals(new Integer(maxParkingNum - 1).intValue(), parkingBoy.showReport().getTotalAvailableNum());
    }

    //作为停车场的主管（Parking Director），我希望看到一张报表，其中包括经理和每个停车仔所管理的车
    // 停车管理员
    @Test
    public void parkManager_ReviewReport() {
        Car car = new Car();
        int maxParkingNum = 20;
        ParkPlace parkPlace = new ParkPlace(maxParkingNum);
        ArrayList<ParkPlace> parkPlaces = new ArrayList<ParkPlace>();
        ParkingBoy parkingBoy = new ParkingBoy(parkPlaces);

        ArrayList<ParkingBoy> parkingBoys = new ArrayList<ParkingBoy>();

        PackManager packManager = new PackManager(parkingBoys, parkPlaces);
        Ticket ticket = packManager.park(car);
        Assert.assertEquals(new Integer(maxParkingNum - 1).intValue(), packManager.showReport().getTotalAvailableNum());
    }
}
