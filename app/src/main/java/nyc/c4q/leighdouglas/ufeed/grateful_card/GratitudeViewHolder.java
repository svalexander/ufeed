package nyc.c4q.leighdouglas.ufeed.grateful_card;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import nyc.c4q.leighdouglas.ufeed.R;
import nyc.c4q.leighdouglas.ufeed.grateful_card.gratitude_model.GratitudeCard;

/**
 * Created by shannonalexander-navarro on 12/23/16.
 */

public class GratitudeViewHolder extends RecyclerView.ViewHolder {

    private TextView promptTV;
    private TextView dateTV;
    private TextView firstTV;
    private TextView secondTV;
    private TextView thirdTV;
    private TextView fourthTV;
    private TextView fifthTV;
    private TextView sixthTV;
    private TextView seventhTV;
    private TextView eighthTV;
    private TextView ninthTV;
    private TextView tenthTV;
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

    public static View inflateView(ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.gratitude_item, parent, false);
    }
    public GratitudeViewHolder(ViewGroup parent) {
        super(inflateView(parent));

        promptTV = (TextView) itemView.findViewById(R.id.promptTV);
        dateTV = (TextView) itemView.findViewById(R.id.saved_date);
        firstTV = (TextView) itemView.findViewById(R.id.saved_first);
        secondTV = (TextView) itemView.findViewById(R.id.saved_second);
        thirdTV = (TextView) itemView.findViewById(R.id.saved_third);
        fourthTV = (TextView) itemView.findViewById(R.id.saved_fourth);
        fifthTV = (TextView) itemView.findViewById(R.id.saved_fifth);
        sixthTV = (TextView) itemView.findViewById(R.id.saved_sixth);
        seventhTV = (TextView) itemView.findViewById(R.id.saved_seventh);
        eighthTV = (TextView) itemView.findViewById(R.id.saved_eighth);
        ninthTV = (TextView) itemView.findViewById(R.id.saved_ninth);
        tenthTV = (TextView) itemView.findViewById(R.id.saved_tenth);
        dateET = (EditText) itemView.findViewById(R.id.date);
        firstET= (EditText) itemView.findViewById(R.id.firstET);
        secondET = (EditText) itemView.findViewById(R.id.secondET);
        thirdET = (EditText) itemView.findViewById(R.id.thirdET);
        fourthET = (EditText) itemView.findViewById(R.id.fourthET);
        fifthET = (EditText) itemView.findViewById(R.id.fifthET);
        sixthET = (EditText) itemView.findViewById(R.id.sixthET);
        seventhET = (EditText) itemView.findViewById(R.id.seventhET);
        eighthET = (EditText) itemView.findViewById(R.id.eighthET);
        ninthET = (EditText) itemView.findViewById(R.id.ninthET);
        tenthET = (EditText) itemView.findViewById(R.id.tenthET);
    }

    public void bind(GratitudeCard things) {

        dateTV.setText(things.getDate());
        firstTV.setText(things.getFirst());
        secondTV.setText(things.getSecond());
        thirdTV.setText(things.getThird());
        fourthTV.setText(things.getFourth());
        fifthTV.setText(things.getFifth());
        sixthTV.setText(things.getSixth());
        seventhTV.setText(things.getSeventh());
        eighthTV.setText(things.geteighth());
        ninthTV.setText(things.getNinth());
        tenthTV.setText(things.getTenth());
    }
}
