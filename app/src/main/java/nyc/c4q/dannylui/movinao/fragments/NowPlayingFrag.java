package nyc.c4q.dannylui.movinao.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.dannylui.movinao.R;
import nyc.c4q.dannylui.movinao.models.Result;
import nyc.c4q.dannylui.movinao.models.TmdbModel;
import nyc.c4q.dannylui.movinao.networks.TmdbClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dannylui on 11/26/16.
 */

public class NowPlayingFrag extends Fragment {
    private TmdbClient client;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_nowplaying, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_nowplaying);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new NowPlayingAdapter());

        //call tmdb
        tmdbApi();
    }

    private void tmdbApi() {
        client = TmdbClient.getInstance();
        Call<TmdbModel> call = client.getNowPlaying();
        call.enqueue(new Callback<TmdbModel>() {
            @Override
            public void onResponse(Call<TmdbModel> call, Response<TmdbModel> response) {
                TmdbModel model = response.body();
                List<Result> nowPlayingMovieList = model.getResults();
                System.out.println(nowPlayingMovieList);
                NowPlayingAdapter adapter = (NowPlayingAdapter) recyclerView.getAdapter();
                adapter.updateList(nowPlayingMovieList);
            }

            @Override
            public void onFailure(Call<TmdbModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
