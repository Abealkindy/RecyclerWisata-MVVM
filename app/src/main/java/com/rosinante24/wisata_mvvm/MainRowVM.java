package com.rosinante24.wisata_mvvm;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rosinante24.wisata_mvvm.databinding.ListRowBinding;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import id.gits.mvvmcore.viewmodel.GitsRowVM;

/**
 * Created by Rosinante24 on 9/26/17.
 */

public class MainRowVM extends GitsRowVM<WisataAPIDao, ListRowBinding> {

    public ObservableField<String> bTextJudul = new ObservableField<>();
    public ObservableField<String> bTextTanggal = new ObservableField<>();
    public ObservableField<String> bUrlImage = new ObservableField<>();


    private static final SimpleDateFormat formatTo =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    private static final  SimpleDateFormat formatFrom =
            new SimpleDateFormat("MMMMMMM dd, yyyy", Locale.getDefault());

    public MainRowVM(Context context, ListRowBinding binding, WisataAPIDao data) {
        super(context, binding, data);
        bTextJudul.set(data.getTitle());
        bUrlImage.set("http://entry.sandbox.gits.id/api/alamku/uploads/images/" + data.getUrl_image());
        formatDate(data);
    }

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .crossFade()
                .placeholder(R.mipmap.ic_launcher_round)
                .into(imageView);
    }

    public void formatDate(WisataAPIDao data) {
        try
        {
            bTextTanggal.set(formatFrom.format(formatTo.parse(data.getCreated_at())));
        } catch (ParseException e)
        {
            e.printStackTrace();
        }



    }

}
