package com.example.mark.flavia;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class ListActivity extends AppCompatActivity {


    int[] IMAGES={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img99,R.drawable.img9,R.drawable.img11};
    String[] NAMES={"Bad acts","Bad morals","Hurting times","Jealous minds","Self centered souls","Evil hearts",
            "Disease spread acts","Depression times","Tough moments","Stressing periods","Idleness and pride"};

    String[] DESCRIPTION={"Stop violence","Violence hurts","Women violence kills","Women violence is trouble","Women violence is hell on earth","Please fight against it",
            "Women violence is in human","It violates rights","It tortures","It leaves misery","brings depression"};

    final String TAG = "States";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listView=(ListView)findViewById(R.id.listview);

        //setting a custom adapter for the listview
        CustomAdapter customAdapter= new CustomAdapter();
        listView.setAdapter(customAdapter);



    }
    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.image_item, null);

            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
            TextView textView_name = (TextView) convertView.findViewById(R.id.textView_name);
            TextView textview_description = (TextView) convertView.findViewById(R.id.textView_description);

            imageView.setImageResource(IMAGES[position]);
            textView_name.setText(NAMES[position]);
            textview_description.setText(DESCRIPTION[position]);


            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(ListActivity.this,NextActivity.class);
                    startActivity(intent);
                }
            });
            return convertView;
        }
    }

}









