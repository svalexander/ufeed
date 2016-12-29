package nyc.c4q.leighdouglas.ufeed.grateful_card;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.leighdouglas.ufeed.R;
import nyc.c4q.leighdouglas.ufeed.grateful_card.gratitude_model.GratitudeCard;

/**
 * Created by shannonalexander-navarro on 12/23/16.
 */

public class GratitudeFragment extends Fragment {

    List<GratitudeCard> gratefulList = new ArrayList<>();
    RecyclerView gratitudeRV;
    GratitudeAdapter gratitudeAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.gratitude_fragment, container, false);

        gratitudeRV = (RecyclerView) root.findViewById(R.id.gratitudeRv);
        gratitudeRV.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        gratitudeAdapter = new GratitudeAdapter(gratefulList);
        gratitudeRV.setAdapter(gratitudeAdapter);
        return root;
    }
}
