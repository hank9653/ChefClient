package com.example.ting_jhih.chef_v1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ting-Jhih on 2016/5/7.
 */
public class OrderMenu extends AppCompatActivity {
    ExpandableListView menuList;
    Button change;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_menu);
        menuList = (ExpandableListView) findViewById(R.id.menuListView);
        change = (Button)findViewById(R.id.change);

        final MyExpandableListViewAdapter myAdapter = new MyExpandableListViewAdapter();
        menuList.setAdapter(myAdapter);


        menuList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(OrderMenu.this, "click"
                        + myAdapter.getChild(groupPosition, childPosition), Toast.LENGTH_LONG).show();
                return false;
            }
        });

        change.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAdapter.setChange();
            }
        });

    }

    public class MyExpandableListViewAdapter extends BaseExpandableListAdapter {

        private String[] groups = { "People Names", "Dog Names", "Cat Names", "Fish Names" };

        private String[][] children = {
                { "Arnold", "Barry", "Chuck", "David" },
                { "Ace", "Bandit", "Cha-Cha", "Deuce" },
                { "Fluffy", "Snuggles" },
                { "Goldy", "Bubbles" }
        };

        @Override
        public int getGroupCount() {
            return groups.length;
        }

        @Override
        public int getChildrenCount(int i) {
            return children[i].length;
        }

        @Override
        public Object getGroup(int i) {
            return groups[i];
        }

        @Override
        public Object getChild(int i, int i1) {
            return children[i][i1];
        }

        @Override
        public long getGroupId(int i) {
            return i;
        }

        @Override
        public long getChildId(int i, int i1) {
            return i1;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(OrderMenu.this);
            textView.setText("         "+getGroup(i).toString());
            return textView;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(OrderMenu.this);
            textView.setText(getChild(i, i1).toString());
            return textView;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }
        public void setChange() {
            this.groups = new String[]{"People Names", "Dog Names", "Cat Names"};

            this.children = new String[][]{
                    {"Arnold", "Barry", "Chuck", "David"},
                    {"Ace", "Bandit", "Cha-Cha", "Deuce"},
                    {"Fluffy", "Snuggles"}
            };
            notifyDataSetChanged();
        }


    }
}

