package nyc.c4q.leighdouglas.ufeed.grateful_card;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import nyc.c4q.leighdouglas.ufeed.R;
import nyc.c4q.leighdouglas.ufeed.grateful_card.gratitude_model.GratitudeCard;

/**
 * Created by shannonalexander-navarro on 12/23/16.
 */

public class GratitudeCardViewHolder extends RecyclerView.ViewHolder {

    private FrameLayout layout;
    private TextView dateTV, firstTV, secondTV;
    private TextView thirdTV;
    private TextView fourthTV;
    private TextView fifthTV;
    private TextView sixthTV;
    private TextView seventhTV;
    private TextView eighthTV;
    private TextView ninthTV;
    private TextView tenthTV;

    public GratitudeCardViewHolder(View itemView) {
        super(itemView);
        initViews();
    }


    public void bind(GratitudeCard gratitudeCard) {

        dateTV.setText(gratitudeCard.getDate());
        firstTV.setText(gratitudeCard.getFirst());
        secondTV.setText(gratitudeCard.getSecond());
        thirdTV.setText(gratitudeCard.getThird());
        fourthTV.setText(gratitudeCard.getFourth());
        fifthTV.setText(gratitudeCard.getFifth());
        sixthTV.setText(gratitudeCard.getSixth());
        seventhTV.setText(gratitudeCard.getSeventh());
        eighthTV.setText(gratitudeCard.getEighth());
        ninthTV.setText(gratitudeCard.getNinth());
        tenthTV.setText(gratitudeCard.getTenth());
    }

    private void initViews() {
        layout = (FrameLayout) itemView.findViewById(R.id.grat_item);
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

    }
}
