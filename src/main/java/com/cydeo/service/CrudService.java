package com.cydeo.service;

import com.cydeo.dto.UserDTO;

import java.util.List;

public interface CrudService<T,ID> { //Generics

//    UserDTO save(UserDTO user);
//    UserDTO findById(String username);
//    List<UserDTO> findAll();
//    void deleteById(String username);

    T save(T user);
    T findById(ID username);
    List<T> findAll();
    void deleteById(ID username);
}
