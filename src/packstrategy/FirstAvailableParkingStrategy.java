package packstrategy;

import java.util.List;

import exception.ParkFullException;
import pojo.ParkPlace;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-13
 * Time: 下午5:38
 * To change this template use File | Settings | File Templates.
 */
public class FirstAvailableParkingStrategy implements packStrategy {
    public ParkPlace getAvailablePark(List<ParkPlace> parks) {
        for (ParkPlace parkPlace : parks) {
            if (parkPlace.GetAvailableNum() > 0)
                return parkPlace;
        }
        throw new ParkFullException("所有的停车场都已满");

    }

}
