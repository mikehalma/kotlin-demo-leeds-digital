package bjss.mike.kotlindemo.examples.g_delegation_example;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.UnaryOperator;

public class CargoWeightsJava implements List<Integer> {

    private List<Integer> delegate = new ArrayList<>();
    private List<Integer> overweightCargo = new ArrayList<>();
    private final static int MAX_WEIGHT = 1000;

    @Override
    public boolean add(Integer integer) {
        if (integer > MAX_WEIGHT) {
            overweightCargo.add(integer);
        }
        return delegate.add(integer);
    }

    public List<Integer> getOverweightCargo() {
        return overweightCargo;
    }

    @Override
    public int size() {
        return delegate.size();
    }

    @Override
    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return delegate.contains(o);
    }

    @NotNull
    @Override
    public Iterator<Integer> iterator() {
        return delegate.iterator();
    }

    @NotNull
    @Override
    public Object[] toArray() {
        return delegate.toArray();
    }

    @NotNull
    @Override
    public <T> T[] toArray(@NotNull T[] ts) {
        return delegate.toArray(ts);
    }

    @Override
    public boolean remove(Object o) {
        return delegate.remove(o);
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> collection) {
        return delegate.containsAll(collection);
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends Integer> collection) {
        return delegate.addAll(collection);
    }

    @Override
    public boolean addAll(int i, @NotNull Collection<? extends Integer> collection) {
        return delegate.addAll(i, collection);
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> collection) {
        return delegate.removeAll(collection);
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> collection) {
        return delegate.retainAll(collection);
    }

    @Override
    public void replaceAll(UnaryOperator<Integer> operator) {
        delegate.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super Integer> c) {
        delegate.sort(c);
    }

    @Override
    public void clear() {
        delegate.clear();
    }

    @Override
    public boolean equals(Object o) {
        return delegate.equals(o);
    }

    @Override
    public int hashCode() {
        return delegate.hashCode();
    }

    @Override
    public Integer get(int i) {
        return delegate.get(i);
    }

    @Override
    public Integer set(int i, Integer integer) {
        return delegate.set(i, integer);
    }

    @Override
    public void add(int i, Integer integer) {
        delegate.add(i, integer);
    }

    @Override
    public Integer remove(int i) {
        return delegate.remove(i);
    }

    @Override
    public int indexOf(Object o) {
        return delegate.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return delegate.lastIndexOf(o);
    }

    @NotNull
    @Override
    public ListIterator<Integer> listIterator() {
        return delegate.listIterator();
    }

    @NotNull
    @Override
    public ListIterator<Integer> listIterator(int i) {
        return delegate.listIterator(i);
    }

    @NotNull
    @Override
    public List<Integer> subList(int i, int i1) {
        return delegate.subList(i, i1);
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return delegate.spliterator();
    }
}
