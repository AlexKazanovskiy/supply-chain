package kpi.supplychain.service.configuration;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import kpi.supplychain.dao.configuration.DistributionsDao;
import kpi.supplychain.dao.configuration.LocalLayerDao;
import kpi.supplychain.model.configuration.DistanceMatrix;
import kpi.supplychain.model.configuration.LocalWarehouse;
import kpi.supplychain.model.configuration.Route;
import kpi.supplychain.model.configuration.Warehouse;
import kpi.supplychain.pojo.configuration.Distributions;
import kpi.supplychain.pojo.configuration.LocalLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.FluentIterable.from;

/**
 * Created by Stryzhov.
 */
@Service(value = "LocalWarehouseService")
public class LocalWarehouseService {

    @Autowired
    private LocalLayerDao localLayerDao;

    @Autowired
    private DistributionsDao distributionsDao;

    private int[] products = {1001, 1002, 1003, 1004, 1005, 1006, 1009};
    private int[] regionCount = {0, 29, 30, 24, 12, 21, 14, 11, 12, 29, 18};

    public List<LocalWarehouse> getLocalWarehouses(DistanceMatrix distanceMatrix,
                                                   List<Warehouse> regionalWarehouses) {
        List<LocalWarehouse> localWarehouses = new ArrayList<>();

        List<LocalLayer> localLayerResult = localLayerDao.list();
        List<Distributions> distributions = distributionsDao.list();

        for (LocalLayer local : localLayerResult) {
            LocalWarehouse localWarehouse = new LocalWarehouse();
            localWarehouse.setId(local.getId());
            localWarehouse.setAdress(local.getAddressCity());
            localWarehouse.setExpectedValues(new double[products.length]);
            localWarehouse.setStandartDeviations(new double[products.length]);
            final int regionKey = local.getRegionKey();
            localWarehouse.setRegion(regionKey);


            for (int j = 0; j < products.length; j++) {
                final int finalJ = j;
                ImmutableList<Distributions> distributionsResult = from(distributions)
                        .filter(new Predicate<Distributions>() {
                            @Override
                            public boolean apply(Distributions distributions) {
                                return distributions.getProduct() == products[finalJ];
                            }
                        })
                        .filter(new Predicate<Distributions>() {
                            @Override
                            public boolean apply(Distributions distributions) {
                                return distributions.getRegion() == regionKey;
                            }
                        }).toList();
                for (int x = 0; x < distributionsResult.size(); x++) {
                    localWarehouse.getExpectedValues()[j] = distributionsResult.get(x).getExpected_value() / regionCount[regionKey];
                    localWarehouse.getStandartDeviations()[j] = distributionsResult.get(x).getStandard_deviation();
                    localWarehouse.getStandartDeviations()[j] = Math.pow(localWarehouse.getStandartDeviations()[j], 2) / regionCount[regionKey];
                    localWarehouse.getStandartDeviations()[j] = Math.sqrt(localWarehouse.getStandartDeviations()[j]);
                }
            }
            localWarehouse.setRoutes(Utils.routesFromWarehouses(regionalWarehouses));
            for (Route route :localWarehouse.getRoutes().values()) {
                route.setKm(distanceMatrix.getDistance(localWarehouse.getId(), route.getWarehouse_id()));
            }
            localWarehouses.add(localWarehouse);
        }
        return localWarehouses;
    }
}
