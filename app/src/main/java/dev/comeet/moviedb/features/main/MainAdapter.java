package dev.comeet.moviedb.features.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import dev.comeet.moviedb.R;
import dev.comeet.moviedb.model.MovieItem;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<MovieItem> mItems;
    private Context mContext;
    private PostItemListener mItemListener;

    public MainAdapter(Context context, List<MovieItem> posts, PostItemListener itemListener) {
        mItems = posts;
        mContext = context;
        mItemListener = itemListener;
    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.item_movie, parent, false);

        ViewHolder viewHolder = new ViewHolder(postView, this.mItemListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, int position) {

        MovieItem item = mItems.get(position);
        TextView tvTitle = holder.tvTitle;
        TextView tvDate = holder.tvDate;

        tvTitle.setText(item.getTitle());
        tvDate.setText(item.getReleaseDate());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void updateAnswers(List<MovieItem> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    private MovieItem getItem(int adapterPosition) {
        return mItems.get(adapterPosition);
    }

    public interface PostItemListener {
        void onPostClick(long id);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tvTitle;
        public TextView tvDate;
        PostItemListener mItemListener;

        public ViewHolder(View itemView, PostItemListener postItemListener) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDate = itemView.findViewById(R.id.tvDate);

            this.mItemListener = postItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            MovieItem item = getItem(getAdapterPosition());
            this.mItemListener.onPostClick(item.getId());

            notifyDataSetChanged();
        }
    }
}