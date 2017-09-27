package com.rosinante24.wisata_mvvm;

import android.support.v7.app.AppCompatActivity;

import com.rosinante24.wisata_mvvm.databinding.ActivityMainBinding;
import com.rosinante24.wisata_mvvm.databinding.ListRowBinding;

import java.util.List;

import id.gits.mvvmcore.adapter.GitsAdapter;

/**
 * Created by Rosinante24 on 9/26/17.
 */

public class MainAdapter extends GitsAdapter<WisataAPIDao, MainRowVM, ListRowBinding> {
    public MainAdapter(List<WisataAPIDao> collection) {
        super(collection);
    }

    @Override
    public MainRowVM createViewModel(AppCompatActivity activity, ListRowBinding binding, WisataAPIDao item, int position) {
        return new MainRowVM(activity, binding, item);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_row;
    }

    @Override
    public void render(ListRowBinding binding, MainRowVM viewModel, WisataAPIDao item) {
        binding.setVm(viewModel);

    }

    @Override
    public void onRowClick(WisataAPIDao data, int position) {

    }
}
