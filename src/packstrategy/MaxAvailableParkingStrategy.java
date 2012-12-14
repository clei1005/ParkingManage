package packstrategy;

import exception.ParkFullException;
import pojo.ParkPlace;

import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-13
 * Time: 下午5:40
 * To change this template use File | Settings | File Templates.
 */
public class MaxAvailableParkingStrategy implements packStrategy {
    public ParkPlace getAvailablePark(List<ParkPlace> parks){
        int maxsizeIndex=0;

        for(int i=1;i< parks.size();i++){
            if(parks.get(i).GetAvailableNum()> parks.get(maxsizeIndex).GetAvailableNum())
                maxsizeIndex=i;
        }
        if(parks.get(maxsizeIndex).GetAvailableNum()==0)throw new ParkFullException("所有的停车场都已满");
        return   parks.get(maxsizeIndex);
    }

}
