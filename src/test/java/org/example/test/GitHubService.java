package org.example.test;

import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 一般情况接口的返回值需要写成Call<User>的形式，但是我这里想直接获取User类，就需要做一些工作了
 */
public interface GitHubService {
    /**
     * 获取github用户信息
     */
    @GET("/users/{username}")
    User getUser(@Path("username") String username);
}