package com.rosinante24.wisata_mvvm;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.gits.mvvmcore.viewmodel.GitsVM;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Rosinante24 on 9/26/17.
 */

public class MainActivityVM extends GitsVM {

    private final List<WisataAPIDao> mList = new ArrayList<>();
    public LinearLayoutManager layoutManager;
    public MainAdapter bAdapter;

    public MainActivityVM(Context context) {
        super(context);


        bAdapter = new MainAdapter(mList);
        layoutManager = new LinearLayoutManager(mContext);
        callApi();
    }

    private void callApi() {
        addSubscription(ApiClient.getInstance()
                .getEndpoint()
                .getWisata(
                        3
                )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<WisataListDao>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNext(WisataListDao wisataListDao) {
                        mList.addAll(wisataListDao.getDatawisata());
                        bAdapter.notifyDataSetChanged();
                    }
                }));
    }
}
