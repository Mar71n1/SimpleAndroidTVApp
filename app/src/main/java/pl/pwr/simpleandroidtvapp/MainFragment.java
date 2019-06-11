package pl.pwr.simpleandroidtvapp;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v17.leanback.app.BackgroundManager;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.OnItemViewSelectedListener;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowPresenter;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainFragment extends BrowseFragment {
    private static final String TAG = MainFragment.class.getSimpleName();

    private BackgroundManager mBackgroundManager;
    private ArrayObjectAdapter mRowsAdapter;
    private static final int GRID_ITEM_WIDTH = 300;
    private static final int GRID_ITEM_HEIGHT = 200;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.i(TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
        mBackgroundManager = BackgroundManager.getInstance(getActivity());
        mBackgroundManager.attach(getActivity().getWindow());
        setupUIElements();
        loadRows();
        setupEventListeners();
    }

    private void setupEventListeners() {
        setOnItemViewSelectedListener(new OnItemViewSelectedListener() {
            @Override
            public void onItemSelected(Presenter.ViewHolder viewHolder, Object o, RowPresenter.ViewHolder viewHolder1, Row row) {
                if (o instanceof Image) {
                    Bitmap b = ((BitmapDrawable) ((Image) o).getImage()).getBitmap();
                    Bitmap bitmapResized = Bitmap.createScaledBitmap(b, 1920, 1080, false);
                    mBackgroundManager.setDrawable(new BitmapDrawable(getResources(), bitmapResized));
                    //mBackgroundManager.setDrawable(((Image) o).getImage());
                } else {
                    mBackgroundManager.setDrawable(getResources().getDrawable(R.drawable.csm_settimana_bianca_andalo_8519ddffb8));
                }
            }
        });
    }

    private void setupUIElements() {
        setTitle("Hello Android TV!");
        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);
        setBrandColor(getResources().getColor(R.color.fastlane_background));
        setSearchAffordanceColor(getResources().getColor(R.color.search_opaque));
    }

    private void loadRows() {
        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());

        /*HeaderItem gridItemPresenterHeader = new HeaderItem(0, "Images");

        GridItemPresenter mGridPresenter = new GridItemPresenter();
        ArrayObjectAdapter gridRowAdapter = new ArrayObjectAdapter(mGridPresenter);
        gridRowAdapter.add("ITEM 1");
        gridRowAdapter.add("ITEM 2");
        gridRowAdapter.add("ITEM 3");
        mRowsAdapter.add(new ListRow(gridItemPresenterHeader, gridRowAdapter));*/

        /* CardPresenter */
        HeaderItem cardPresenterHeader = new HeaderItem(0, "Images");
        CardPresenter cardPresenter = new CardPresenter();
        ArrayObjectAdapter cardRowAdapter = new ArrayObjectAdapter(cardPresenter);

        Image image1 = new Image();
        image1.setImage(getResources().getDrawable(R.drawable.csm_settimana_bianca_andalo_8519ddffb8));
        image1.setTitle("Winter");
        cardRowAdapter.add(image1);

        Image image2 = new Image();
        image2.setImage(getResources().getDrawable(R.drawable.nature_3125912_1920));
        image2.setTitle("Autumn");
        cardRowAdapter.add(image2);

        Image image3 = new Image();
        image3.setImage(getResources().getDrawable(R.drawable.nature_3294681_1920));
        image3.setTitle("Summer");
        cardRowAdapter.add(image3);

        mRowsAdapter.add(new ListRow(cardPresenterHeader, cardRowAdapter));
        setAdapter(mRowsAdapter);
    }

    private class GridItemPresenter extends Presenter {
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent) {
            TextView view = new TextView(parent.getContext());
            view.setLayoutParams(new ViewGroup.LayoutParams(GRID_ITEM_WIDTH, GRID_ITEM_HEIGHT));
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.setBackgroundColor(getResources().getColor(R.color.default_background));
            view.setTextColor(Color.WHITE);
            view.setGravity(Gravity.CENTER);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, Object item) {
            ((TextView) viewHolder.view).setText((String) item);
        }

        @Override
        public void onUnbindViewHolder(ViewHolder viewHolder) {

        }
    }
}
