package io.cristhianac.kmpmovies.data

class MoviesRepository(private val moviesService: MoviesService) {
    suspend fun fetchPopularMovies(): List<Movie> {
        return moviesService.fetchPopularMovies().results.map { it.toDomainMovie() }

    }
    suspend fun fetchMovie(movieId: Int): Movie {
        return moviesService.fetchMovie(movieId).toDomainMovie()

    }
}
private fun RemoteMovie.toDomainMovie() = Movie(
    id = id,
    title = title,
    poster = "https://image.tmdb.org/t/p/w500$posterPath"
)