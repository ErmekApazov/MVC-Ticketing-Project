package com.cydeo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapService <T,ID> { // abstracting implementation, roleservice and userservice same impl

    public Map<ID, T> map = new HashMap<>(); // database

    // why Map not List. method findById method is suitable to implement in map.

    T save(ID id, T object){
        map.put(id, object);
        return object;
    }

    List<T> findAll(){
        return new ArrayList<T>(map.values());
    }

    T findById(ID id){

        return map.get(id);
    }

    void deleteById(ID id){
        map.remove(id);
    }

}
