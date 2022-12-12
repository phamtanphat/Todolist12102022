package com.example.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.ViewHolder> {
    private final List<Work> worksData;
    private OnItemClickListener onItemClickListener;
    private SimpleDateFormat formatTime = new SimpleDateFormat("yyyy/MM/dd");

    public WorkAdapter(List<Work> worksData, OnItemClickListener listener) {
        this.worksData = worksData;
        this.onItemClickListener = listener;
    }

    public void updateWorks(List<Work> works) {
        List<Work> newWorks = new ArrayList<>();
        newWorks.addAll(works);
        worksData.clear();
        worksData.addAll(newWorks);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_work, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(worksData.get(position));
    }

    @Override
    public int getItemCount() {
        return worksData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCreateDate, tvTitle, tvDescription;
        ImageView imgDelete, imgWork;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            init(itemView);
            imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onDeleteClick(
                            worksData.get(getAdapterPosition()).getId(),
                            getAdapterPosition()
                    );
                }
            });
        }

        private void init(View itemView) {
            imgWork = itemView.findViewById(R.id.image_view_work);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvCreateDate = itemView.findViewById(R.id.tv_date);
            tvDescription = itemView.findViewById(R.id.tv_description);
            imgDelete = itemView.findViewById(R.id.img_delete);
        }

        public void bindView(Work work) {
            tvTitle.setText(work.getTitle());
            tvDescription.setText(work.getDescription());
            tvCreateDate.setText(formatTime.format(work.getCreatedDateMilliSeconds()));
            if (work.getImgWork() != null) {
                imgWork.setImageBitmap(work.getImgWork());
                imgWork.setVisibility(View.VISIBLE);
            } else {
                imgWork.setVisibility(View.GONE);
            }
        }
    }

    public interface OnItemClickListener {
        void onDeleteClick(int rowId, int positionView);
    }

}
