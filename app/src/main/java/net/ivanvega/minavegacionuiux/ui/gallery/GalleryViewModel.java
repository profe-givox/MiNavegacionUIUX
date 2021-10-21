package net.ivanvega.minavegacionuiux.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private String urlImage=null;
    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public String urlImage(){
        if(this.urlImage==null){
            this.urlImage = urlImageRandom();
        }

        return this.urlImage;
    }

    private String urlImageRandom() {
        return "https://picsum.photos/"+

                (int)(Math.random()*5 + 3) +"00/"
                +(int)(Math.random()*5 + 3) + "00";

    }


}