package com.maryang.fastrxjava.data.source

import com.google.gson.JsonElement
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.*

interface GithubApi {

    @GET("search/repositories")
    fun searchRepos(
        @Query("q") search: String
    ): Single<JsonElement>

    @GET("/user/following/{username}")
    fun getFollowing(
        @Path("username") username: String
    ): Completable

    @PUT("/user/following/{username}")
    fun follow(
        @Path("username") username: String
    ): Completable

    @DELETE("/user/following/{username}")
    fun unfollow(
        @Path("username") username: String
    ): Completable

    @GET("user/starred/{owner}/{repo}")
    fun checkStar(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Completable

    @PUT("user/starred/{owner}/{repo}")
    fun star(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Completable

    @DELETE("user/starred/{owner}/{repo}")
    fun unstar(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Completable
}
