package nyc.c4q.dannylui.movinao.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.dannylui.movinao.models.Result;

/**
 * Created by dannylui on 11/27/16.
 */
public class NowPlayingAdapter extends RecyclerView.Adapter {
    private List<Result> movieList = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NowPlayingHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        NowPlayingHolder npHolder = (NowPlayingHolder) holder;
        Result movie = movieList.get(position);
        npHolder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void updateList(List<Result> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }
}
