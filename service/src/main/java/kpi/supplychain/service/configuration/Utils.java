package kpi.supplychain.service.configuration;

import com.google.common.base.Function;
import kpi.supplychain.model.configuration.Route;
import kpi.supplychain.model.configuration.Warehouse;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Maps.uniqueIndex;

public class Utils {

    public static Map<Integer, Route> routesFromWarehouses(List<Warehouse> warehouses) {
        List<Route> routes = from(warehouses).transform(new Function<Warehouse, Route>() {
            @Override
            public Route apply(Warehouse warehouse) {
                return new Route(warehouse.getId());
            }
        }).toList();
        return new TreeMap<>(uniqueIndex(routes, new Function<Route, Integer>() {
                    @Override
                    public Integer apply(Route route) {
                        return route.getWarehouse_id();
                    }
                }
        ));
    }
}
