package kpi.supplychain.service.configuration;

import com.google.common.base.Function;
import kpi.supplychain.dao.configuration.NationalLayerDao;
import kpi.supplychain.model.configuration.Warehouse;
import kpi.supplychain.pojo.configuration.NationalLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.google.common.collect.FluentIterable.from;

/**
 * Created by I on 16.06.2015.
 */
@Service(value = "NationalWarehouseService")
public class NationalWarehouseService {

    @Autowired
    private NationalLayerDao nationalLayerDao;

    public List<Warehouse> getNationalWarehouses(final List<Warehouse> producers) {
        return from(nationalLayerDao.list()).transform(new Function<NationalLayer, Warehouse>() {
            @Override
            public Warehouse apply(final NationalLayer nationalLayer) {
                return new Warehouse() {{
                    setId(nationalLayer.getId());
                    setAdress(nationalLayer.getName());
                    setRoutes(Utils.routesFromWarehouses(producers));
                }};
            }
        }).toList();
    }
}
