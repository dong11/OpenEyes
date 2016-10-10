package com.rex.hwong.openeyes.ui.iView;

import com.rex.hwong.openeyes.bean.discovery.DiscoveryData;
import com.rex.hwong.openeyes.bean.discovery.DiscoveryItem;

import java.util.List;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 16/10/10
 * @time 下午6:19
 */

public interface IFindFragment {
    void getDiscoveryInfo(List<DiscoveryData> discoveryDatas);
}
