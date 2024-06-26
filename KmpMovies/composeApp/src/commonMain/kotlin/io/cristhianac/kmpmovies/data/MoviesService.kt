package io.cristhianac.kmpmovies.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class MoviesService(
    private val apikey:String,
    private val client: HttpClient

){
    suspend fun fetchPopularMovies(): RemoteResult {
        return client
            .get("https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=$apikey")
            .body<RemoteResult>()
    }
   suspend fun fetchMovie(movieId: Int): RemoteMovie {
       return client
           .get("https://api.themoviedb.org/3/movie/$movieId?api_key=$apikey")
           .body<RemoteMovie>()

   }

}