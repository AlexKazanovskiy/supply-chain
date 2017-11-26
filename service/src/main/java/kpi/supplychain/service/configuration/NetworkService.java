package kpi.supplychain.service.configuration;

import kpi.supplychain.model.configuration.DistanceMatrix;
import kpi.supplychain.model.configuration.LocalWarehouse;
import kpi.supplychain.model.configuration.Network;
import kpi.supplychain.model.configuration.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.google.common.collect.Iterables.toArray;

public class NetworkService {

    @Autowired
    private LocalWarehouseService localWarehouseService;

    @Autowired
    private DistanceMatrixService distanceMatrixService;

    @Autowired
    private RegionalWarehouseService regionalWarehouseService;

    @Autowired
    private ProducerService producerService;

    @Autowired
    private NationalWarehouseService nationalWarehouseService;

    public Network getNetwork() {
        Network network = new Network();
        network.setData(new int[9][11]);

        DistanceMatrix distanceMatrix = distanceMatrixService.getDistanceMatrix();

        List<Warehouse> producers = producerService.getProducers();
        network.setProducer(toArray(producers, Warehouse.class));

        List<Warehouse> nationalWarehouses = nationalWarehouseService.getNationalWarehouses(producers);
        network.setNational(toArray(nationalWarehouses, Warehouse.class));

        List<Warehouse> regionalWarehouses = regionalWarehouseService.getRegionalWarehouses(nationalWarehouses);
        network.setRegional(toArray(regionalWarehouses, Warehouse.class));

        List<LocalWarehouse> localWarehouses = localWarehouseService.getLocalWarehouses(distanceMatrix, regionalWarehouses);
        network.setLocal(toArray(localWarehouses, LocalWarehouse.class));

        network.notifyObservers();
        return network;
    }


}
