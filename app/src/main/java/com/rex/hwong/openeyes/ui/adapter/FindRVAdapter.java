package com.rex.hwong.openeyes.ui.adapter;

import android.content.Context;
import android.util.Log;

import com.rex.hwong.openeyes.R;
import com.rex.hwong.openeyes.bean.discovery.DiscoveryItem;
import com.rex.hwong.openeyes.utils.ImageLoader;

import java.util.List;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 16/10/11
 * @time 上午10:02
 */

public class FindRVAdapter extends AutoRVAdapter {

    private List<DiscoveryItem> mList;
    private Context mContext;

    public FindRVAdapter(Context context, List<DiscoveryItem> list) {
        super(context, list);
        mList = list;
        mContext = context;
    }

    @Override
    public int onCreateViewLayoutID(int viewType) {
        return R.layout.fragment_find_item;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(getItemViewType(position) == TYPE_NORMAL) {
//            这里加载数据的时候要注意，是从position-1开始，因为position==0已经被header占用了
            ImageLoader.loadImage(mContext, mList.get(position - 1).getImage(), holder.getImageView(R.id.iv_fragment_find_item));
            holder.getTextView(R.id.tv_fragment_find_item).setText(mList.get(position - 1).getTitle());
        } else {
            return;
        }
    }
}
