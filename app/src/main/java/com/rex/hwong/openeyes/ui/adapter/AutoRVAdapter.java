package com.rex.hwong.openeyes.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.List;

/**
 * Created by dong on 16/4/6.
 */
public abstract class AutoRVAdapter extends RecyclerView.Adapter<RVHolder> {
    public List<?> list;
    private Context context;
    private View mHeaderView;
    private View mFooterView;

    public static final int TYPE_HEADER = 0x01;  //说明是带有Header的
    public static final int TYPE_FOOTER = 0x10;  //说明是带有Footer的
    public static final int TYPE_NORMAL = 0x11;  //说明是不带有header和footer的

    public AutoRVAdapter(Context context, List<?> list) {
        this.list = list;
        this.context = context;
    }
    @Override
    public RVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mHeaderView != null && viewType == TYPE_HEADER) {
            return new RVHolder(mHeaderView);
        }
        if(mFooterView != null && viewType == TYPE_FOOTER){
            return new RVHolder(mFooterView);
        }
        View view = LayoutInflater.from(context).inflate(onCreateViewLayoutID(viewType), parent, false);
        return new RVHolder(view);
    }
    public abstract int onCreateViewLayoutID(int viewType);
    @Override
    public void onViewRecycled(final RVHolder holder) {
        super.onViewRecycled(holder);
    }
    @Override
    public void onBindViewHolder(final RVHolder holder, final int position) {
        onBindViewHolder(holder.getViewHolder(), position);
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(null, v, holder.getPosition(), holder.getItemId());
                }
            });
        }
    }
    public abstract void onBindViewHolder(ViewHolder holder, int position);

    @Override
    public int getItemCount() {
        if(mHeaderView == null && mFooterView == null){
            return list.size();
        }else if(mHeaderView == null && mFooterView != null) {
            return list.size() + 1;
        }else if (mHeaderView != null && mFooterView == null) {
            return list.size() + 1;
        }else {
            return list.size() + 2;
        }
    }
    private AdapterView.OnItemClickListener onItemClickListener;
    public AdapterView.OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    public void setFootView(View footView) {
        mFooterView = footView;
        notifyItemInserted(getItemCount() - 1);
    }

    @Override
    public int getItemViewType(int position) {
        if (mHeaderView != null && position == 0) {
            //第一个item应该加载Header
            return TYPE_HEADER;
        }
        if (mFooterView != null && position == getItemCount() - 1) {
            //最后一个,应该加载Footer
            return TYPE_FOOTER;
        }
        return TYPE_NORMAL;
    }
}
