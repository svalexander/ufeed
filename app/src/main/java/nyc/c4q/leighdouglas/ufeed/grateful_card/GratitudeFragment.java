package nyc.c4q.leighdouglas.ufeed.grateful_card;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import nyc.c4q.leighdouglas.ufeed.R;

/**
 * Created by shannonalexander-navarro on 12/23/16.
 */

public class GratitudeFragment extends Fragment {

    private EditText dateET;
    private EditText firstET;
    private EditText secondET;
    private EditText thirdET;
    private EditText fourthET;
    private EditText fifthET;
    private EditText sixthET;
    private EditText seventhET;
    private EditText eighthET;
    private EditText ninthET;
    private EditText tenthET;
    CoordinatorLayout layout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.gratitude_fragment, container, false);

        layout = (CoordinatorLayout) root.findViewById(R.id.grat_frag);
        // promptTV = (TextView) itemView.findViewById(promptTV);

        dateET = (EditText) root.findViewById(R.id.date);
        firstET = (EditText) root.findViewById(R.id.firstET);
        secondET = (EditText) root.findViewById(R.id.secondET);
        thirdET = (EditText) root.findViewById(R.id.thirdET);
        fourthET = (EditText) root.findViewById(R.id.fourthET);
        fifthET = (EditText) root.findViewById(R.id.fifthET);
        sixthET = (EditText) root.findViewById(R.id.sixthET);
        seventhET = (EditText) root.findViewById(R.id.seventhET);
        eighthET = (EditText) root.findViewById(R.id.eighthET);
        ninthET = (EditText) root.findViewById(R.id.ninthET);
        tenthET = (EditText) root.findViewById(R.id.tenthET);

        FloatingActionButton close = (FloatingActionButton) root.findViewById(R.id.grat_close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), GratitudeMainActivity.class);
                startActivity(intent);
            }
        });

        return root;

    }


}
