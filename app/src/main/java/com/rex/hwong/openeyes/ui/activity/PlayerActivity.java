package com.rex.hwong.openeyes.ui.activity;

import android.net.Uri;
import android.os.Bundle;

import com.rex.hwong.openeyes.R;
import com.rex.hwong.openeyes.utils.PlayerManager;

public class PlayerActivity extends BaseActivity implements PlayerManager.PlayerStateListener{

    private PlayerManager player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        initPlayer();
    }

    private void initPlayer() {
        player = new PlayerManager(this);
        player.setFullScreenOnly(true);
        player.setScaleType(PlayerManager.SCALETYPE_FILLPARENT);
        player.playInFullScreen(true);

        player.setPlayerStateListener(this);

        player.play("http://baobab.kaiyanapp.com/api/v1/playUrl?vid=10588&editionType=default");

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onPlay() {

    }
}
