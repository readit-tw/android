package com.thoughtworks.readit.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thoughtworks.readit.R;
import com.thoughtworks.readit.domain.Resource;

import java.util.List;

/**
 * Created by jaysagar on 7/31/15.
 */
public class ResourceAdapter extends RecyclerView.Adapter<ResourceAdapter.ViewHolder> {
    private List<Resource> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View itemView;
        public TextView txtHeader;
        public TextView txtFooter;

        public ViewHolder(View v) {
            super(v);
            itemView = v;
            txtHeader = (TextView) v.findViewById(R.id.title);
            txtFooter = (TextView) v.findViewById(R.id.link);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ResourceAdapter(List<Resource> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ResourceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.resource_list, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.txtHeader.setText(mDataset.get(position).getTitle());
        holder.txtFooter.setText(mDataset.get(position).getLink());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
