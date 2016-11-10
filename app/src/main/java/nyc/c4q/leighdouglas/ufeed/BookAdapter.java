package nyc.c4q.leighdouglas.ufeed;

import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by shannonalexander-navarro on 10/30/16.
 */

public class BookAdapter extends RecyclerView.Adapter {
//    private List<String> books;

//    public void setBooks(List<Book> books){
//        this.books = books;
//    }

    public BookAdapter(List<String> books){
        mBooks = books;
    }

    private List<String> mBooks = new ArrayList<>();

    //ArrayList<String> list = new ArrayList<String>();


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BookCardViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Set<String> set = new HashSet<>();
//        String book = "";
        //set.add("test");
        //Log.d("here","true");
        //try {
            set = PreferenceManager.getDefaultSharedPreferences(AppContext.getAppContext()).getStringSet("books", null);


        //list.add(1,"jgh");
        Log.d("set",set.size()+1+"");
        BookCardViewHolder viewHolder = (BookCardViewHolder) holder;
//        List <String> list = new ArrayList<>(set);
        String book = mBooks.get(position);
        viewHolder.bind(book);

    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }
}
