package com.marco.crud.services;

import com.marco.crud.dto.DtoLogin;
import com.marco.crud.dto.DtoUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface InterfaceDeServicos {

    @POST("/auth/login")
    Call<DtoLogin> login(@Body DtoLogin dtoLogin);

    @POST("/users")
    Call<DtoUser> cadastrarUsuario(@Body DtoUser dtoUser);

    @GET("/users")
    Call<List<DtoUser>> todosUsuarios(@Header("Authorization") String authorization);

    @PUT("/users/{id}")
    Call<DtoUser> atualizaUsuario(@Path("id") Integer userId, @Header("Authorization") String authorization, @Body DtoUser dtoUser);

    @DELETE("/users/{id}")
    Call<Void> deletaUsuario(@Path("id") Integer userId, @Header("Authorization") String authorization);

}
