package nyc.c4q.leighdouglas.ufeed.grateful_card;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
    private EditText dateEV;
    private EditText firstEV;
    private EditText secondEV;
    private EditText thirdEV;
    private EditText fourthEV;
    private EditText fifthEV;
    private EditText sixthEV;
    private EditText seventhEV;
    private EditText eighthEV;
    private EditText ninthEV;
    private EditText tenthEV;

    public GratitudeViewHolder(View itemView) {
        super(itemView);
    }

    public void bind(GratitudeCard things) {
    }
}
