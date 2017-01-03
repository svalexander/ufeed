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
import nyc.c4q.leighdouglas.ufeed.grateful_card.gratitude_model.GratitudeCard;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

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

        FloatingActionButton save = (FloatingActionButton) root.findViewById(R.id.grat_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userDate = dateET.getText().toString();
                String firstInput = firstET.getText().toString();
                String secondInput = secondET.getText().toString();
                String thirdInput = thirdET.getText().toString();
                String fourthInput = fourthET.getText().toString();
                String fifthInput = fifthET.getText().toString();
                String sixthInput = sixthET.getText().toString();
                String seventhInput = seventhET.getText().toString();
                String eighthInput = eighthET.getText().toString();
                String ninthInput = ninthET.getText().toString();
                String tenthInput = tenthET.getText().toString();

                addGratitudeCard(new GratitudeCard(userDate, firstInput, secondInput,
                        thirdInput, fourthInput, fifthInput, sixthInput, seventhInput, eighthInput,
                        ninthInput, tenthInput) );
                refreshCatList();
                Intent intent = new Intent(getContext(), GratitudeMainActivity.class);
                startActivity(intent);
            }
        });

        return root;

    }

    public void addGratitudeCard(GratitudeCard gratCard) {
        cupboard().withDatabase(GratitudeMainActivity.gratitudeDatabase).put(gratCard);
    }
    private void refreshCatList() {
        GratitudeMainActivity.gratitudeAdapter.notifyDataSetChanged();
    }

}
