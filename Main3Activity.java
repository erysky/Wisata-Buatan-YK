package id.ac.uty.gridcardview;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class Main3Activity extends AppCompatActivity implements ViewFactory {
    Integer[] imageIDS = {R.drawable.hobbit, R.drawable.hobit1, R.drawable.hobit2,
            R.drawable.hobit3, R.drawable.hobit4, R.drawable.hobit5,R.drawable.mangrove1, R.drawable.mangrove2, R.drawable.mangrove3,
            R.drawable.mangrove4, R.drawable.mangrove5, R.drawable.jogjabay, R.drawable.jogjabay1, R.drawable.jogjabay3,
            R.drawable.jogjabay4, R.drawable.jogjabay5, R.drawable.lampion, R.drawable.lampion1, R.drawable.lampion3,
            R.drawable.lampion4, R.drawable.lampion5,R.drawable.nglangeran, R.drawable.nglangeran1, R.drawable.nglangeran3,
            R.drawable.nglangeran4, R.drawable.nglangeran5,R.drawable.selokan1, R.drawable.selokan2, R.drawable.selokan3,
            R.drawable.selokan4, R.drawable.selokan5,R.drawable.sindu1, R.drawable.sindu2, R.drawable.sindu3,
            R.drawable.sindu4, R.drawable.sindu5,R.drawable.stone1, R.drawable.stone2, R.drawable.stone3,
            R.drawable.stone4, R.drawable.stone5,R.drawable.world1, R.drawable.world2, R.drawable.world3,
            R.drawable.world4, R.drawable.world5,R.drawable.upside1, R.drawable.upside2, R.drawable.upside3,
            R.drawable.upside4, R.drawable.upside5};
    Gallery gallery;
    ImageSwitcher imageSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher1);
        imageSwitcher.setFactory(this);
        imageSwitcher.setAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out));
        gallery = (Gallery) findViewById(R.id.gallery1);
        gallery.setAdapter(new ImageAdapter(this));
        gallery.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position,
                                    long id) {
                imageSwitcher.setImageResource(imageIDS[position]);
            }
        });
    }
    @Override
    public View makeView() {
        ImageView imageView = new ImageView(this);
//imageView.setBackgroundColor(0xFF000000);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(new
                ImageSwitcher.LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.FILL_PARENT));
        return imageView;
    }
    public class ImageAdapter extends BaseAdapter{

        Context context;
        int itemBackground;
        public ImageAdapter(Context c){
            context = c;
            TypedArray a = obtainStyledAttributes(R.styleable.Gallery1);
            itemBackground = a.getResourceId(R.styleable.Gallery1_android_galleryItemBackground, 0);
            a.recycle();
        }
        @Override
        public int getCount() {
            return imageIDS.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if(convertView == null){
                imageView = new ImageView(context);
                imageView.setImageResource(imageIDS[position]);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new Gallery.LayoutParams(150, 120));
            }else {
                imageView = (ImageView) convertView;
            }
            imageView.setBackgroundResource(itemBackground);

            return imageView;
        }

    }
}