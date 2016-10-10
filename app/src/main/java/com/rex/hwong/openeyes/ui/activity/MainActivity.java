package com.rex.hwong.openeyes.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.rex.hwong.openeyes.R;
import com.rex.hwong.openeyes.ui.fragment.AuthorFragment;
import com.rex.hwong.openeyes.ui.fragment.FindFragment;
import com.rex.hwong.openeyes.ui.fragment.SelectFragment;
import com.rex.hwong.openeyes.ui.fragment.SelfFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {
    @BindView(R.id.content)
    FrameLayout mContent;
    @BindView(R.id.menu_group)
    RadioGroup mMenuGroup;
    @BindView(R.id.menu_select)
    RadioButton mMenuSelect;
    @BindView(R.id.menu_find)
    RadioButton mMenuFind;
    @BindView(R.id.menu_author)
    RadioButton mMenuAuthor;
    @BindView(R.id.menu_self)
    RadioButton mMenuSelf;

    private ArrayList<Fragment> mFragments;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
    }

    private void init(){
        mFragments = new ArrayList<>();

        mFragments.add(new SelectFragment());
        mFragments.add(new FindFragment());
        mFragments.add(new AuthorFragment());
        mFragments.add(new SelfFragment());

        mMenuGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int titleRes = R.string.menu_select;
                int page = 0;
                switch (checkedId){
                    case R.id.menu_select:
                        break;
                    case R.id.menu_find:
                        page = 1;
                        titleRes = R.string.menu_find;
                        break;
                    case R.id.menu_author:
                        page = 2;
                        titleRes = R.string.menu_author;
                        break;
                    case R.id.menu_self:
                        page = 3;
                        titleRes = R.string.menu_self;
                        break;
                }
                switchFragment(mFragments.get(page), titleRes);
            }
        });

        mMenuGroup.check(R.id.menu_select);
    }

    /**
     * 切换选中的Fragment
     * @param fragment
     * @param titleRes
     */
    private void switchFragment(Fragment fragment, int titleRes) {
        if (currentFragment == null || !currentFragment.getClass().getName().equals(fragment.getClass().getName())) {
            show(fragment, getString(titleRes));
            currentFragment = fragment;
        }
    }

    /**
     * 显示一个fragment
     * @param fragment
     */
    public void show(Fragment fragment, String title){
        //若fragment没有在管理类中，则添加
        if (getSupportFragmentManager().findFragmentByTag(title) == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content, fragment, title)
                    .commit();
        }
        //先隐藏所有的fragment
        hide();
        //显示指定的fragment
        getSupportFragmentManager().beginTransaction().show(fragment).commit();
    }

    /**
     * 隐藏所有的fragment
     */
    public void hide(){
        List<Fragment> list = getSupportFragmentManager().getFragments();
        if(list == null){
            return;
        }
        for(int i = 0;i < list.size();i++){
            getSupportFragmentManager().beginTransaction().hide(list.get(i)).commit();
        }
    }
}
