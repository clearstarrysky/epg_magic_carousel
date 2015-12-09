package com.sss.magicwheel.manager;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sss.magicwheel.R;

import java.util.List;

/**
 * @author Alexey Kovalev
 * @since 04.12.2015.
 */
public class WheelAdapter extends RecyclerView.Adapter<WheelAdapter.WheelItemViewHolder> {

    private final List<WheelDataItem> dataItems;
    private final LayoutInflater inflater;

    public WheelAdapter(Context context, List<WheelDataItem> dataItems) {
        this.dataItems = dataItems;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public WheelItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        WheelBigWrapperView bigWrapperView = (WheelBigWrapperView) inflater.inflate(R.layout.wheel_big_wrapper_layout, parent, false);
        return new WheelItemViewHolder(bigWrapperView);
    }

    @Override
    public void onBindViewHolder(WheelItemViewHolder holder, int position) {
        holder.bindData(dataItems.get(position));
    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    static class WheelItemViewHolder extends RecyclerView.ViewHolder {

        private final WheelBigWrapperView bigWrapperView;

        public WheelItemViewHolder(WheelBigWrapperView bigWrapperView) {
            super(bigWrapperView);
            this.bigWrapperView = bigWrapperView;
        }

        void bindData(WheelDataItem dataItem) {
            bigWrapperView.updateText(dataItem.getTitle());
        }
    }

}