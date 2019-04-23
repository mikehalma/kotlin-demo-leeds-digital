package bjss.mike.kotlindemo.examples.g_delegation_example;

import com.google.common.collect.ForwardingList;

import java.util.ArrayList;
import java.util.List;

public class CargoWeightsGuava<T extends Integer> extends ForwardingList<T> {

    private final List<T> delegate = new ArrayList();
    private final List<T> overweightCargo = new ArrayList();
    private final Integer MAX_WEIGHT = new Integer(1000);

    @Override
    protected List<T> delegate() {
        return delegate;
    }

    @Override
    public boolean add(T weight) {
        if (weight.intValue() > MAX_WEIGHT) {
            overweightCargo.add(weight);
        }
        return delegate.add(weight);
    }

    public List<T> getOverweightCargo() {
        return overweightCargo;
    }
}
