package mobapde.machineproject.nessfit;
// package com.example.user.nessfit;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ExerciseAdapter extends CursorRecyclerViewAdapter<ExerciseAdapter.ExerciseViewHolder> {

    public ExerciseAdapter(Context context, Cursor cursor) {
        super(context, cursor);
    }

    @Override
    public void onBindViewHolder(ExerciseAdapter.ExerciseViewHolder viewHolder, Cursor cursor) {
        long currID = cursor.getLong(cursor.getColumnIndex(Exercise.COLUMN_ID));
        //int photo_url = cursor.getInt(cursor.getColumnIndex(Exercise.COLUMN_PHOTO)); //todo validate this solution
        String name = cursor.getString(cursor.getColumnIndex(Exercise.COLUMN_NAME));

        viewHolder.exerciseName.setText(name);
        viewHolder.itemContainer.setTag(currID);

        viewHolder.itemContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long currID = (long)view.getTag();
                onItemClickListener.onItemClick(currID);
            }
        });
    }

    @Override
    public ExerciseAdapter.ExerciseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercise_list_item, parent, false);
        return new ExerciseViewHolder(v);
    }

    public class ExerciseViewHolder extends RecyclerView.ViewHolder{
        ImageView exerciseFeaturedImage;
        TextView exerciseName;
        LinearLayout itemContainer;

        public ExerciseViewHolder(View itemView) {
            super(itemView);

            exerciseFeaturedImage = (ImageView) itemView.findViewById(R.id.exercise_featured_image);
            exerciseName = (TextView) itemView.findViewById(R.id.exercise_name);
            itemContainer = (LinearLayout) itemView.findViewById(R.id.item_container);
        }
    }

    public interface OnItemClickListener{
        public void onItemClick(long currID);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
}
