package kpi.supplychain.service.configuration;


import kpi.supplychain.model.configuration.LocalWarehouse;
import kpi.supplychain.model.configuration.Network;
import kpi.supplychain.model.configuration.Warehouse;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service(value = "InventoryManagment")
public class InventoryManagment {

    private static double regionPrice = 56;
    private static double nationalPrice = 82;

    public void solve(int week, Network network) {
        double sum = 0;

        for (LocalWarehouse local : network.getLocal()) {
            Set<Integer> keys = local.getRoutes().keySet();
            for (Integer key : keys) {
                Warehouse region = network.getRegional()[key];
                region.getReserve()[0] = Math.sqrt(Math.pow(local.getAllTeaDeviation(), 2) + Math.pow(region.getReserve()[0], 2));
                region.getReserve()[1] = Math.sqrt(Math.pow(local.getAllSupDeviation(), 2) + Math.pow(region.getReserve()[1], 2));
                region.getReserve()[2] = Math.sqrt(Math.pow(local.getAllSouseDeviation(), 2) + Math.pow(region.getReserve()[2], 2));
                region.getVolumes()[0] += local.getAllTeaDemands();
                region.getVolumes()[1] += local.getAllSupDemands();
                region.getVolumes()[2] += local.getAllSouseDemands();
            }
        }

        for (int i = 0; i < network.getRegionalCount(); i++) {
            Warehouse region = network.getRegional()[i];
            region.getReserve()[0] *= Math.sqrt(week);// Math.pow(local.getAllTeaDeviation(),2)+Math.pow(region.reserve[0],2));
            region.getReserve()[1] *= Math.sqrt(week);// Math.pow(local.getAllSupDeviation(),2)+Math.pow(region.reserve[1],2));
            region.getReserve()[2] *= Math.sqrt(week);// Math.pow(local.getAllSouseDeviation(),2)+Math.pow(region.reserve[2],2));

            region.getVolumes()[0] *= week;// local.getAllTeaDemands();
            region.getVolumes()[1] *= week;// local.getAllSupDemands();
            region.getVolumes()[2] *= week;// local.getAllSouseDemands();


            System.out.println("r" + region.getAdress() + " product: " + (network.getRegional()[i].getVolumes()[0] + network.getRegional()[i].getVolumes()[1] + network.getRegional()[i].getVolumes()[2]) + " " + (network.getRegional()[i].getReserve()[0] + network.getRegional()[i].getReserve()[1] + network.getRegional()[i].getReserve()[2]));

            sum = region.getVolumes()[0] + region.getVolumes()[1] + region.getVolumes()[2] + network.getReserveCoef() * (region.getReserve()[0] + region.getReserve()[1] + region.getReserve()[2]);
        }

        network.setRegionWarehouseCost(sum * regionPrice);

    }

    public void solveNationalProblem(Network network) {
        double sum = 0;

        for (Warehouse regional : network.getRegional()) {
            Set<Integer> keys = regional.getRoutes().keySet();
            for (Integer key : keys) {
                Warehouse national = network.getNational()[key];

                national.getReserve()[0] += regional.getReserve()[0] * regional.getRoutes().get(key).getVolumes()[0] / regional.getVolumes()[0];
                national.getReserve()[1] += regional.getReserve()[1] * regional.getRoutes().get(key).getVolumes()[1] / regional.getVolumes()[1];
                national.getReserve()[2] += regional.getReserve()[2] * regional.getRoutes().get(key).getVolumes()[2] / regional.getVolumes()[2];

                national.getVolumes()[0] += regional.getRoutes().get(key).getVolumes()[0];
                national.getVolumes()[1] += regional.getRoutes().get(key).getVolumes()[1];// regional.getAllSupDemands();
                national.getVolumes()[2] += regional.getRoutes().get(key).getVolumes()[2];// regional.getAllSouseDemands();

                sum = national.getVolumes()[0] + national.getVolumes()[1] + national.getVolumes()[2] + network.getReserveCoef()
                        * (national.getReserve()[0] + national.getReserve()[1] + national.getReserve()[2]) / 2;
            }
        }

        for (int i = 0; i < network.getNationalCount(); i++) {
            System.out.println("r" + network.getNational()[i].getAdress() + " product: " + (network.getNational()[i].getVolumes()[0] + network.getNational()[i].getVolumes()[1] + network.getNational()[i].getVolumes()[2]) + " " + (network.getNational()[i].getReserve()[0] + network.getNational()[i].getReserve()[1] + network.getNational()[i].getReserve()[2]));
        }

        network.setNatonalWarehouseCost(sum * nationalPrice);
    }

}
