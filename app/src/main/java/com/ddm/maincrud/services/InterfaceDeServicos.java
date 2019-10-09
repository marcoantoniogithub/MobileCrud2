package com.ddm.maincrud.services;

import com.ddm.maincrud.dto.DtoLogin;
import com.ddm.maincrud.dto.DtoUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface InterfaceDeServicos {

    @POST("/users")
    Call<DtoUser> cadastraUsuario(@Body DtoUser dtoUser);

    @POST("/auth/login")
    Call<DtoLogin> login(@Body DtoLogin dtoLogin);
}

