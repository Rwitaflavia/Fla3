package com.example.mark.flavia;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TabFragment1 extends Fragment {

    int position;
    private TextView textView;
    TextToSpeech t1;
    private myDbAdapter helper;

    public static Fragment getInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        TabFragment1 tabFragment = new TabFragment1();
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("pos");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_fragment1, container, false);
        return view;

    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {


        final TextView notes2;
        String restoredText;
        super.onViewCreated(view, savedInstanceState);

        helper = new myDbAdapter(getContext());
        String data = helper.getData();


        final ListView list2 = view.findViewById(R.id.list);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Seek help immediately");
        arrayList.add("Stay informed & educate yourself");
        arrayList.add("Use empowering language");
        arrayList.add("Tell someone about violence");
        arrayList.add("Ethical representation of victims");
        arrayList.add("Speak up");
        arrayList.add("Donate & Fundraise");
        arrayList.add("Advocate for a systemic change");
        arrayList.add("Don’t forget to care about yourself");
        arrayList.add("Bring a back-up");
        arrayList.add("Be the back-up");
        arrayList.add("Make the call");
        arrayList.add("Be on standby");
        arrayList.add("Have an intervention plan");
        arrayList.add("Provide some relief");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, arrayList);
        list2.setAdapter(arrayAdapter);
        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem=(String) list2.getItemAtPosition(position);
                Toast.makeText(getContext(),clickedItem,Toast.LENGTH_LONG).show();
            }
        });



    }
}