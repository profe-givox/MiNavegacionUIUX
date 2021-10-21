package net.ivanvega.minavegacionuiux.ui.gallery;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.squareup.picasso.Picasso;

import net.ivanvega.minavegacionuiux.R;
import net.ivanvega.minavegacionuiux.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;

    private ImageView img;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        /*
        View layoutGallery =
                inflater.inflate(R.layout.fragment_gallery, container, false);

        img = layoutGallery.findViewById(R.id.imgRandom);


        Picasso.with(getContext()).
                load(new GalleryViewModel().urlImage()).into(img);
        */



        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGallery;
        final ImageView img = binding.imgRandom;
        final Button btnRan = binding.btnChangeImg;
        final ImageView img2 = binding.imageView2;

        btnRan.setOnClickListener(view -> galleryViewModel.setRandomImage());

        Picasso.with(getContext()).
                load(galleryViewModel.urlImage().getValue()).into(img);



        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        galleryViewModel.urlImage().observe(getViewLifecycleOwner()
                , new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        Picasso.with(getContext()
                                ).load(s).into(img2);
                    }
                });



        return root;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}