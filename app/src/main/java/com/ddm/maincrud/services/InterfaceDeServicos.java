package com.ddm.maincrud.services;

import com.ddm.maincrud.dto.DtoLogin;
import com.ddm.maincrud.dto.DtoUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface InterfaceDeServicos {

    @POST("/auth/login")
    Call<DtoLogin> login(@Body DtoLogin dtoLogin);

    @POST("/users")
    Call<DtoUser> cadastrarUsuario(@Body DtoUser dtoUser);

    @GET("/users")
    Call<List<DtoUser>> todosUsuarios(@Header("Authorization") String authorization);

}

