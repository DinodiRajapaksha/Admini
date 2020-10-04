package app.mad.admini.tournaments.tournament.howzaat;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.helper.databaseHelper;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link app.mad.admini.tournaments.tournament.howzaat.CompletedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CompletedFragment extends Fragment {

    // Add RecyclerView member
    private RecyclerView touUserRecyclerView;
    databaseHelper dbh;
    uitouRecyclerAdapter uitourecyclerAdapter;
    ArrayList<String> touName, touCountry, fromDate, toDate, tid;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Fragment CompletedFragment;

    public CompletedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CompletedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static app.mad.admini.tournaments.tournament.howzaat.CompletedFragment newInstance(String param1, String param2) {
        app.mad.admini.tournaments.tournament.howzaat.CompletedFragment fragment = new CompletedFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_completed, container, false);


        dbh = new databaseHelper(getActivity());
        tid        = new ArrayList<>();
        touName    = new ArrayList<>();
        touCountry = new ArrayList<>();
        fromDate   = new ArrayList<>();
        toDate     = new ArrayList<>();

        Log.d("tid" ,"tid"+touName);
        storeDataInArray();

        //for recycler
        touUserRecyclerView = (RecyclerView)view.findViewById(R.id.touUserRecyclerView);
        touUserRecyclerView.setHasFixedSize(true);
        touUserRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        Log.d("baaaaaa", "nu");
        touUserRecyclerView.setAdapter( new uitouRecyclerAdapter(CompletedFragment, getContext(), tid, touName, touCountry, fromDate, toDate ));
        Log.d("baaaaaaxo", "nu"+tid);
        return view;

    }

    void storeDataInArray(){
        Cursor c = dbh.getAllTourneysforUI();
        if(c.getCount() == 0){
        }else{
            while (c.moveToNext()){
                tid.add(c.getString(0));
                touName.add(c.getString(2));
                touCountry.add(c.getString(4));
                fromDate.add(c.getString(5));
                toDate.add(c.getString(6));
            }
        }
        Log.d("dino1", ""+tid);

    }
}