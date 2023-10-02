package br.com.guru.usecases.port;


import java.util.List;

public interface RestService <T> {

    List<T> get(final String resource);

    T get(final String resource, Class<T> clazz);

    int post(final String resource, final T entity);

    boolean put(final String resource, final T entity);

    boolean delete(final String resource);

}