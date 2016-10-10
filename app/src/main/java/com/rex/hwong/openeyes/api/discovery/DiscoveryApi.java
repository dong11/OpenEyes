package com.rex.hwong.openeyes.api.discovery;

import com.rex.hwong.openeyes.bean.discovery.DiscoveryResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 16/10/10
 * @time 下午6:02
 */

public interface DiscoveryApi {
    @GET("/api/v3/discovery?udid=ecd5a3fdbbbe47d5b753ffb99eb6c326fe9eaeb1&vc=137&vn=2.7.1&deviceModel=Custom%20Phone%20-%204.4.4%20-%20API%2019%20-%20768x1280&first_channel=eyepetizer_360_market&last_channel=eyepetizer_360_market&system_version_code=19")
    Observable<DiscoveryResponse> getDiscoveryInfo();
}
