package nyc.c4q.dannylui.movinao.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dannylui on 11/27/16.
 */

public class TmdbModel {

    private Integer page;
    private List<Result> results = new ArrayList<Result>();
    private Dates dates;
    private Integer totalPages;
    private Integer totalResults;

    public Integer getPage() {
        return page;
    }

    public List<Result> getResults() {
        return results;
    }

    public Dates getDates() {
        return dates;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }
}
