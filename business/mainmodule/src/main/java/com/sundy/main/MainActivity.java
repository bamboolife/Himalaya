package com.sundy.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;

import com.sundy.common.base.BaseActivity;
import com.sundy.common.base.BaseMvvmActivity;
import com.sundy.main.fragment.MainFragment;
import com.sundy.main.mvvm.viewmodel.MainViewModel;
import com.sundy.main.test.MainPresenter;
import com.sundy.main.test.User;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected int onBindLayout() {
        return R.layout.bbl_main_layout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //清除全屏显示
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //去除背景色,避免过度绘制
        setTheme(R.style.NullTheme);
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.bbl_main_layout);


    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        if (findFragment(MainFragment.class)==null){
           MainFragment mainFragment=new MainFragment();
           loadRootFragment(R.id.fl_content, mainFragment);
        }
    }


//    @Override
//    public Class<MainViewModel> onBindViewModel() {
//        return MainViewModel.class;
//    }
//
//    @Override
//    public ViewModelProvider.Factory onBindViewModelFactory() {
//        return new ViewModelProvider.AndroidViewModelFactory(getApplication());
//    }
//
//    @Override
//    public void initViewObservable() {
//
//    }
}
