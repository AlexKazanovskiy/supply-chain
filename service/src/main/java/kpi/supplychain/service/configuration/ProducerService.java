package kpi.supplychain.service.configuration;

import com.google.common.base.Function;
import kpi.supplychain.dao.configuration.ProducerLayerDao;
import kpi.supplychain.model.configuration.Warehouse;
import kpi.supplychain.pojo.configuration.ProducerLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.google.common.collect.FluentIterable.from;

@Service(value = "ProducerService")
public class ProducerService {

    @Autowired
    private ProducerLayerDao producerLayerDao;

    public List<Warehouse> getProducers() {
        return from(producerLayerDao.list()).transform(new Function<ProducerLayer, Warehouse>() {
            @Override
            public Warehouse apply(final ProducerLayer producerLayer) {
                return new Warehouse() {{
                    setId(producerLayer.getId());
                    setAdress(producerLayer.getName());
                }};
            }
        }).toList();
    }
}
