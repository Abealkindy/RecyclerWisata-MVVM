package com.rosinante24.wisata_mvvm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rosinante24.wisata_mvvm.databinding.ActivityMainBinding;

import id.gits.mvvmcore.activity.GitsActivity;

public class MainActivity extends GitsActivity<MainActivityVM, ActivityMainBinding> {


    @Override
    protected int getToolbarId() {
        return R.id.toolbar;
    }

    @Override
    public int getResLayout() {
        return R.layout.activity_main;
    }

    @Override
    public MainActivityVM getViewModel() {
        return new MainActivityVM(this);
    }

    @Override
    public void bindViewModel(ActivityMainBinding binding, MainActivityVM viewModel) {

        binding.setVm(viewModel);

    }
}
