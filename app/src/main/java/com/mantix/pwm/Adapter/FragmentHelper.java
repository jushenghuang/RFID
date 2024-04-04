package com.mantix.pwm.Adapter;

import android.content.Context;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.mantix.pwm.InfoFragment;
import com.mantix.pwm.MainFragment;
import com.mantix.pwm.R;

public class FragmentHelper {
    Context context;//上下文
    FragmentManager fgmm;//片段页面管理器
    FragmentTransaction fragmentTransaction;//事务
    Fragment newFgm ;//新的片段页面
    public FragmentHelper(Context context, FragmentManager fgmm, Fragment newFgm ) {
        this.context = context;
        this.fgmm = fgmm;
        this.newFgm=newFgm;
        fragmentTransaction = fgmm.beginTransaction();
    }
    public FragmentHelper(Context context, FragmentManager fgmm) {
        this.context = context;
        this.fgmm = fgmm;
        fragmentTransaction = fgmm.beginTransaction();
    }
    public void doPageReturn(String tag) {
        //Fragment parentFragment = new MainFragment();
        //FragmentTransaction fragmentTransaction = fgmm.beginTransaction();
        fragmentTransaction.replace(R.id.fgLayout, newFgm,tag);

        fragmentTransaction.commit();
    }
    /**
     * 隐藏已经打开过的画面不要重新加载
     * */
    public void showNewHideOld(String currentTag,String newTag){
        Fragment currentFragment = fgmm.findFragmentByTag(currentTag);
        Log.e("fragmentHelper", "showNewHideOld: "+ newFgm.getTag());
           if (currentFragment!=null) {
               fragmentTransaction
                       .hide(currentFragment)
                       .add(R.id.fgLayout, newFgm,"info")
                       .commit();
           }
           else{
               Log.e("fragmentHelper", "showNewHideOld: isnull");
           }
    }
    public void showOldCloseCurrent(String currentTag,String olgTag){
        Fragment current = fgmm.findFragmentByTag(currentTag);
        Fragment old = fgmm.findFragmentByTag(olgTag);

        if (old != null) {
            fragmentTransaction
                    .hide(current)
                    .show(old)
                    .commit();
        }
        else{
            Log.e("fragmentHelper", "showNewHideOld: isnull");
        }
    }


}
