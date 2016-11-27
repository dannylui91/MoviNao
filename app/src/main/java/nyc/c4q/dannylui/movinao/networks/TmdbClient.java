package nyc.c4q.dannylui.movinao.networks;

import nyc.c4q.dannylui.movinao.models.TmdbModel;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dannylui on 11/27/16.
 */

public class TmdbClient {
    private static final String API_URL = "https://api.themoviedb.org/";
    private static final String API_KEY = "ff1e3d7b4f1780567097432b149675d6";
    private static TmdbClient instance;
    private final TmdbApi api;

    private TmdbClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(TmdbApi.class);
    }

    public static TmdbClient getInstance() {
        if (instance == null) {
            instance = new TmdbClient();
        }
        return instance;
    }

    public Call<TmdbModel> getNowPlaying() {
        return api.getNowPlaying(API_KEY, "en-US");
    }
}
