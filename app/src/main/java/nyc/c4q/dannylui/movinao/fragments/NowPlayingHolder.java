package nyc.c4q.dannylui.movinao.fragments;

import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import nyc.c4q.dannylui.movinao.R;
import nyc.c4q.dannylui.movinao.models.Result;

/**
 * Created by dannylui on 11/27/16.
 */
public class NowPlayingHolder extends RecyclerView.ViewHolder {
    //sizes "w92", "w154", "w185", "w342", "w500", "w780", or "original"
    private static final String BASE_POSTER_URL = "http://image.tmdb.org/t/p/w185/";
    private ImageView moviePoster;
    private TextView movieTitle;
    private TextView movieRating;
    private TextView movieOverview;
    private TextView movieScore;

    public NowPlayingHolder(ViewGroup parent) {
        super(inflateView(parent));
        moviePoster = (ImageView) itemView.findViewById(R.id.image_nowplaying);
        movieTitle = (TextView) itemView.findViewById(R.id.tv_nowplaying_title);
        movieRating = (TextView) itemView.findViewById(R.id.tv_nowplaying_rating);
        movieOverview = (TextView) itemView.findViewById(R.id.tv_nowplaying_overview);
        movieScore = (TextView) itemView.findViewById(R.id.tv_nowplaying_score);

        movieOverview.setMovementMethod(new ScrollingMovementMethod());

    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.vh_nowplaying, parent, false);
    }

    public void bind(Result movie) {
        String posterPath = movie.getPosterPath();
        String title = movie.getTitle();
        String overview = movie.getOverview();
        String score = String.valueOf(movie.getVoteAverage());

        Glide.with(itemView.getContext()).load(BASE_POSTER_URL + posterPath).into(moviePoster);
        movieTitle.setText(title);
        movieOverview.setText(overview);
        movieScore.setText(score);
    }
}
