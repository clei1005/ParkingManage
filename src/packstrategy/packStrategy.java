package packstrategy;

import pojo.ParkPlace;

import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-13
 * Time: 下午5:10
 * To change this template use File | Settings | File Templates.
 */
public interface packStrategy {
    ParkPlace getAvailablePark(List<ParkPlace> parks);
}
