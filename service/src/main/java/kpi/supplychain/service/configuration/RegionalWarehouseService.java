package kpi.supplychain.service.configuration;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import kpi.supplychain.dao.configuration.RegionLayerDao;
import kpi.supplychain.model.configuration.Warehouse;
import kpi.supplychain.pojo.configuration.RegionLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by I on 16.06.2015.
 */
@Service(value = "RegionalWarehouseService")
public class RegionalWarehouseService {

    @Autowired
    private RegionLayerDao regionLayerDao;

    public List<Warehouse> getRegionalWarehouses(final List<Warehouse> nationalWarehouses) {
        return FluentIterable.from(regionLayerDao.list()).transform(new Function<RegionLayer, Warehouse>() {
            @Override
            public Warehouse apply(final RegionLayer regionLayer) {
                return new Warehouse() {{
                    setAdress(regionLayer.getAddressCity());
                    setId(regionLayer.getRegionId());
                    setRoutes(Utils.routesFromWarehouses(nationalWarehouses));
                }};
            }
        }).toList();
    }
}
