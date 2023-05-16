package com.courier.spring.service;

import com.courier.spring.model.RegisterModel;

import java.util.List;

public interface RegisterService {
    RegisterModel createCourier(RegisterModel register);
    RegisterModel updateCourier(RegisterModel register);
    void deleteCourier(RegisterModel register);
    RegisterModel findUserById(RegisterModel register);
    List<RegisterModel>courierList();
    RegisterModel getCourier(RegisterModel register);
}