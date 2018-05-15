package id.ac.uty.gridcardview;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    public static final String DEVELOPER_KEY = "\n" + "AIzaSyC1uaDaj3B_T4tPFIsAsryPmJMkHyPU_7k\n";
    private static final  String VIDEO_ID = "c1Zwpi3Fnm0";
    private static final int RECOVERY_DIALOG_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        //Initialize the views
        TextView harga=(TextView) findViewById(R.id.harga);
        TextView alamat =(TextView) findViewById(R.id.lokasi);
        TextView Detail = (TextView) findViewById(R.id.Detail);
        ImageView sportsImage = (ImageView)findViewById(R.id.sportsImageDetail);
        ImageView sportsImage2 = (ImageView)findViewById(R.id.sportsImageDetail2);
        ImageView sportsImage3 = (ImageView)findViewById(R.id.sportsImageDetail3);
        ImageView sportsImage4 = (ImageView)findViewById(R.id.sportsImageDetail4);
        ImageView sportsImage5 = (ImageView)findViewById(R.id.sportsImageDetail5);


        //Get the drawable
        Drawable drawable = ContextCompat.getDrawable
                (this,getIntent().getIntExtra(SportData.IMAGE_KEY, 0));


        //Create a placeholder gray scrim while the image loads
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);

        //Make it the same size as the image
        if(drawable!=null) {
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        harga.setText(getIntent().getStringExtra(SportData.HARGA_KEY));
        alamat.setText(getIntent().getStringExtra(SportData.ALAMAT_KEY));
        //set the text from the intent extra
        Detail.setText(getIntent().getStringExtra(SportData.DETAIL_KEY));

        //Set the text from the Intent extra

        //Load the image using the glide library and the Intent extra
        Glide.with(this).load(getIntent().getIntExtra(SportData.IMAGE_KEY,0))
                .placeholder(gradientDrawable).into(sportsImage);
        Glide.with(this).load(getIntent().getIntExtra(SportData.IMAGE_KEY2,0))
                .placeholder(gradientDrawable).into(sportsImage2);
        Glide.with(this).load(getIntent().getIntExtra(SportData.IMAGE_KEY3,0))
                .placeholder(gradientDrawable).into(sportsImage3);
        Glide.with(this).load(getIntent().getIntExtra(SportData.IMAGE_KEY4,0))
                .placeholder(gradientDrawable).into(sportsImage4);
        Glide.with(this).load(getIntent().getIntExtra(SportData.IMAGE_KEY5,0))
                .placeholder(gradientDrawable).into(sportsImage5);

    }
    public void pindah(View view){
        Intent intent =new Intent(DetailActivity.this, MapsActivity.class);
        startActivity(intent);


    }
}
