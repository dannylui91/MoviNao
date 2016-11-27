package nyc.c4q.dannylui.movinao.networks;

import nyc.c4q.dannylui.movinao.models.TmdbModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dannylui on 11/27/16.
 */

public interface TmdbApi {
    @GET("3/movie/now_playing")
    Call<TmdbModel> getNowPlaying(
            @Query("api_key") String apiKey,
            @Query("language") String language
    );
}
