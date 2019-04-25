package bjss.mike.kotlindemo.examples.g_delegation_example;

import com.google.common.collect.ForwardingList;

import java.util.ArrayList;
import java.util.List;

public class CargoWeightsGuava extends ForwardingList<Integer> {

    private final List<Integer> delegate = new ArrayList();
    private final List<Integer> overweightCargo = new ArrayList();
    private final static int MAX_WEIGHT = 1000;

    @Override
    protected List<Integer> delegate() {
        return delegate;
    }

    @Override
    public boolean add(Integer weight) {
        if (weight > MAX_WEIGHT) {
            overweightCargo.add(weight);
        }
        return delegate.add(weight);
    }

    public List<Integer> getOverweightCargo() {
        return overweightCargo;
    }
}
