package nyc.c4q.leighdouglas.ufeed.news_card;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import nyc.c4q.leighdouglas.ufeed.R;

/**
 * Created by shannonalexander-navarro on 1/6/17.
 */

public class NewsFragment extends Fragment {

    FrameLayout newsLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.news_fragment, container, false);

        newsLayout = (FrameLayout) root.findViewById(R.id.news_frag);
        return root;

    }
}
