package com.ennovasoft.mdcomponents;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ennovasoft.mdcomponents.adapters.ComponentAdapter;
import com.ennovasoft.mdcomponents.fragments.BottomNavigationBarFragment;
import com.ennovasoft.mdcomponents.fragments.ButtonFragment;
import com.ennovasoft.mdcomponents.fragments.SnackBarFragment;
import com.ennovasoft.mdcomponents.fragments.TextFieldFragment;
import com.ennovasoft.mdcomponents.utils.Component;
import com.ennovasoft.mdcomponents.utils.Constants;
import com.ennovasoft.mdcomponents.utils.OnClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private ComponentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        configAdapter();
        configRecyclerView();
    }

    private void configAdapter() {
        mAdapter = new ComponentAdapter(new ArrayList<>(), this);
        mAdapter.add(ButtonFragment.getmInstance());
        mAdapter.add(BottomNavigationBarFragment.getmInstance());
        mAdapter.add(SnackBarFragment.getmInstance());
        mAdapter.add(TextFieldFragment.getmInstance());
    }

    private void configRecyclerView() {
        recyclerView.setAdapter(mAdapter);
    }

    /*
     * OnClickListener
     * */
    @Override
    public void onClick(Component component) {
        Intent intent;
        if (component.getType() == Constants.SCROLL) {
            intent = new Intent(this, ScrollActivity.class);
        } else { //STATIC
            intent = new Intent(this, StaticActivity.class);
        }
        intent.putExtra(Constants.ARG_NAME, component.getName());
        startActivity(intent);
    }
}
