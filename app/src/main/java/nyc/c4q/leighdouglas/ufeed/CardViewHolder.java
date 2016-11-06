package nyc.c4q.leighdouglas.ufeed;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by shannonalexander-navarro on 10/30/16.
 */

public class CardViewHolder extends RecyclerView.ViewHolder {
    public CardViewHolder(View itemView) {
        //super(itemView); //
        super(inflateView(itemView)); //calling the inflate view method which returns the container of our view

    }

    private static View inflateView(View itemView) {
        //inflate the view of viewHolder
        return itemView;
    }

}
