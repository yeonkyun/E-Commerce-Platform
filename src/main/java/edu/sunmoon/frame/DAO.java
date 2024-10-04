package edu.sunmoon.frame;

import java.sql.Connection;
import java.util.List;

public interface DAO<K, V> {
    V insert(V v, Connection connection) throws Exception;
    V update(V v, Connection connection) throws Exception;
    Boolean delete(K k, Connection connection) throws Exception;
    V select(K k, Connection connection) throws Exception;
    List<V> select(Connection connection) throws Exception;
}
