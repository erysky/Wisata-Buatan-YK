package id.ac.uty.gridcardview;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private ArrayList<SportData> mSportData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mSportData = new ArrayList<>();
        myAdapter = new MyAdapter(this, mSportData);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mSportData = new ArrayList<>();
        myAdapter = new MyAdapter(this, mSportData);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(1, dpToPx(5), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);
        prepareSport();


    }

    private void prepareSport(){
        String[] sportList1 = getResources().getStringArray(R.array.sports_detail);
        String[] sportList2 = getResources().getStringArray(R.array.alamat_sport);
        String[] sportList3 = getResources().getStringArray(R.array.Harga_sport);
        String[] sportList = getResources().getStringArray(R.array.sports_titles);
        TypedArray sportImageResources = getResources().obtainTypedArray(R.array.image_sport);
        TypedArray sportImageResources2 = getResources().obtainTypedArray(R.array.image_sport2);
        TypedArray sportImageResources3 = getResources().obtainTypedArray(R.array.image_sport3);
        TypedArray sportImageResources4 = getResources().obtainTypedArray(R.array.image_sport4);
        TypedArray sportImageResources5 = getResources().obtainTypedArray(R.array.image_sport5);
        for(int i=0; i<sportList1.length; i++){

            mSportData.add(new SportData(sportList1[i],sportList2[i],sportList3[i],sportList[i],
                    sportImageResources.getResourceId(i,0),sportImageResources2.getResourceId(i,0),sportImageResources3.getResourceId(i,0),sportImageResources4.getResourceId(i,0),sportImageResources5.getResourceId(i,0)));
        }
        myAdapter.notifyDataSetChanged();
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}
