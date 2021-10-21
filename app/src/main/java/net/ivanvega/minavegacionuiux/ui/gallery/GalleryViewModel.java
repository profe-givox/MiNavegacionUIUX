package net.ivanvega.minavegacionuiux.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData <String> urlImage;
    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");

        urlImage = new MutableLiveData<>();
        this.urlImage.setValue(this.urlImageRandom());
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<String> urlImage(){

        return this.urlImage;
    }

    public void setRandomImage(){
        this.urlImage.setValue(this.urlImageRandom());
    }

    private String urlImageRandom() {
        return "https://picsum.photos/"+

                (int)(Math.random()*5 + 3) +"00/"
                +(int)(Math.random()*5 + 3) + "00";

    }


}