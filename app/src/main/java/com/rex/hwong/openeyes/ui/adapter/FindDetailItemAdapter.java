package com.rex.hwong.openeyes.ui.adapter;

import android.content.Context;

import com.rex.hwong.openeyes.R;
import com.rex.hwong.openeyes.bean.discovery.detail.DetailData;
import com.rex.hwong.openeyes.utils.DateFormatUtil;
import com.rex.hwong.openeyes.utils.ImageLoader;

import java.util.List;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 2016/10/23
 * @time 下午7:17
 */

public class FindDetailItemAdapter extends AutoRVAdapter {

    private Context mContext;
    private List<DetailData> mList;

    public FindDetailItemAdapter(Context context, List<DetailData> list) {
        super(context, list);
        mContext = context;
        mList = list;
    }

    @Override
    public int onCreateViewLayoutID(int viewType) {
        return R.layout.fragment_find_detail_item;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ImageLoader.loadImage(mContext, mList.get(position).getData().getCover().getFeed(), holder.getImageView(R.id.iv_fragment_find_detail_item));
        holder.getTextView(R.id.tv_fragment_find_detail_item_title).setText(mList.get(position).getData().getTitle());
        holder.getTextView(R.id.tv_fragment_find_detail_item_info).setText(
                "#" + mList.get(position).getData().getCategory()
                        + "  /  " + DateFormatUtil.secToTime(mList.get(position).getData().getDuration()));
    }
}
