package id.ac.uty.gridcardview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;

/**
 * Created by User on 16/04/2018.
 */

public class SportData {
    private String sportDetail;
    private String sportAlamat;
    private String sportHarga;
    private String sportName;
    private int sportImage;
    private int sportImage2;
    private int sportImage3;
    private int sportImage4;
    private int sportImage5;
    static final String DETAIL_KEY= "Sport Detail";
    static final String ALAMAT_KEY= "Sport Alamat";
    static final String HARGA_KEY= "Sport Harga";
    static final String NAME_KEY = "Sport Name";
    static final String IMAGE_KEY = "Sport Image";
    static final String IMAGE_KEY2 = "Sport Image2";
    static final String IMAGE_KEY3 = "Sport Image3";
    static final String IMAGE_KEY4 = "Sport Image4";
    static final String IMAGE_KEY5 = "Sport Image5";


    public SportData(String sportDetail,String sportAlamat,String sportHarga,String sportName, int sportImage,int sportImage2,int sportImage3,int sportImage4,int sportImage5){
        this.sportDetail=sportDetail;
        this.sportAlamat=sportAlamat;
        this.sportHarga=sportHarga;
        this.sportName=sportName;
        this.sportImage=sportImage;
        this.sportImage2=sportImage2;
        this.sportImage3=sportImage3;
        this.sportImage4=sportImage4;
        this.sportImage5=sportImage5;

    }
    public String getDetailKey() { return  sportDetail;}
    public String getAlamatKey() { return  sportAlamat;}
    public String getHargaKey() { return  sportHarga;}
    public String getSportName(){
        return sportName;
    }

    public int getSportImage(){
        return sportImage;
    }
    public int getSportImage2(){
        return sportImage2;
    }
    public int getSportImage3(){
        return sportImage3;
    }
    public int getSportImage4(){
        return sportImage4;
    }
    public int getSportImage5(){
        return sportImage5;
    }

    static Intent startr(Context context,String sportDetail,String sportAlamat,String sportHarga, String sportName, @DrawableRes int sportImageId,@DrawableRes int sportImageId2,@DrawableRes int sportImageId3,@DrawableRes int sportImageId4,@DrawableRes int sportImageId5){
        Intent detailIntent = new Intent(context, DetailActivity.class);
        detailIntent.putExtra(DETAIL_KEY, sportDetail);
        detailIntent.putExtra(ALAMAT_KEY, sportAlamat);
        detailIntent.putExtra(HARGA_KEY,sportHarga);
        detailIntent.putExtra(NAME_KEY, sportName);
        detailIntent.putExtra(IMAGE_KEY, sportImageId);
        detailIntent.putExtra(IMAGE_KEY2, sportImageId2);
        detailIntent.putExtra(IMAGE_KEY3, sportImageId3);
        detailIntent.putExtra(IMAGE_KEY4, sportImageId4);
        detailIntent.putExtra(IMAGE_KEY5, sportImageId5);
        return detailIntent;

    }
}
