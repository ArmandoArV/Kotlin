package mx.tec.apis.service

import mx.tec.apis.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface IService {
    @GET(value = "users")
    fun getUsers(): Call<List<User>>

    @GET(value = "users/{id}")
    fun getUserById(@Path("id") id: Int): Call<User>

    @PUT("users/{id}")
    fun updateUser(@Path("id") id: Int, @Body user: User): Call<User>

}