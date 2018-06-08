package com.ankit.solutions.n26.dao;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public interface TransactionDao<T> {
    void update(long timestamp, UnaryOperator<T> updater);

    T reduce(BinaryOperator<T> reducer);
}
