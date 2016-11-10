package nyc.c4q.leighdouglas.ufeed;

import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by shannonalexander-navarro on 10/30/16.
 */

public class BookAdapter extends RecyclerView.Adapter {


    private List<String> mBook = Arrays.asList(
            //should be new Book objects in here
            "VALLEY OF THE DOLLS", "LORD OF THE FLIES", "FOR COLORED GIRLS", "Beloved", "IN THE TIME OF THE BUTTERFLIES"
    );

    //ArrayList<String> list = new ArrayList<String>();


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BookCardViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Set<String> set = new HashSet<>();
        String book = "";
        //set.add("test");
        //Log.d("here","true");
        //try {
            set = PreferenceManager.getDefaultSharedPreferences(AppContext.getAppContext()).getStringSet("books", null);


        //list.add(1,"jgh");
        Log.d("set",set.size()+1+"");
        BookCardViewHolder viewHolder = (BookCardViewHolder) holder;
        List <String> list = new ArrayList<>(set);

            for(int i = 0; i <list.size();i++) {
               book = list.get(i);
//
                Log.d("book",book);
                //mBook.add(book);
                //list.addAll(book);

                viewHolder.bind(book);

            }

//
//
//                Log.d("book","book");
//
//            }
            //mBook.addAll(set);
            //Log.d("here","true2");
        //}
         //catch (Exception e){
            // Log.d("here","true3");
             //Log.d("here",e.toString());
        // }
         //BookCardViewHolder viewHolder = (BookCardViewHolder) holder;
         //String userBook = mBook.get(position);
        //String userBook = set.get(position);
         viewHolder.bind(book);
    }

    @Override
    public int getItemCount() {
        return mBook.size();
    }
}
