package com.barclays.tprogram.ims.controller;
import java.util.List;

/*
 * Interface defining abstract CRUD methods for each of your Controllers.
 */
public interface CrudController<T> {

    List<T> readAll();

    T readyById(Integer id);

    T create(T obj);

    T update(T obj);

    void delete(Integer id);

}