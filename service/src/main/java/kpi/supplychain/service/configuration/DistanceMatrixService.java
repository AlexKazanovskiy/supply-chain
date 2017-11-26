package kpi.supplychain.service.configuration;

import kpi.supplychain.dao.configuration.DistanceMatrixDao;
import kpi.supplychain.model.configuration.DistanceMatrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Stryzhov.
 */
@Service(value = "DistanceMatrixService")
public class DistanceMatrixService {

    @Autowired
    private DistanceMatrixDao distanceMatrixDao;

    public DistanceMatrix getDistanceMatrix() {
        DistanceMatrix distanceMatrix = new DistanceMatrix();

        List<kpi.supplychain.pojo.configuration.DistanceMatrix> distanceMatrixResult = distanceMatrixDao.list();

        for (kpi.supplychain.pojo.configuration.DistanceMatrix aDistanceMatrixResult : distanceMatrixResult) {
            int destination = aDistanceMatrixResult.getDestination();
            int origin = aDistanceMatrixResult.getOriginals();
            int value = aDistanceMatrixResult.getDistance();
            distanceMatrix.getMatrix()[origin][destination] = value;
        }
        return distanceMatrix;
    }
}
