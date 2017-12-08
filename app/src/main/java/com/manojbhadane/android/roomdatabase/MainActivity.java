package com.manojbhadane.android.roomdatabase;

import android.os.AsyncTask;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends BaseActivity
{
    private EditText mEdtProfile;
    private ProfileAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private TextInputLayout mTipProfile;
    private ArrayList<Profile> mArrayList;

    @Override
    public int getLayoutResId()
    {
        return R.layout.activity_main;
    }

    @Override
    public void init()
    {
        mArrayList = new ArrayList<>();

        mTipProfile = (TextInputLayout) findViewById(R.id.tip);
        mEdtProfile = (EditText) findViewById(R.id.edt_profile);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);

        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mTipProfile.setErrorEnabled(false);
                mTipProfile.setError(null);
                if (mEdtProfile.getText().toString().length() > 0)
                {
                    insertData();
                    listAll();
                } else
                {
                    mTipProfile.setErrorEnabled(true);
                    mTipProfile.setError("Please enter profile");
                }
            }
        });

        listAll();
    }

    private void insertData()
    {
        mArrayList = new ArrayList<>();

        Profile model = new Profile();
        model.setProfileName(mEdtProfile.getText().toString());
        mArrayList.add(model);
        mEdtProfile.setText("");

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                App.get().getDBInstance().profileDao().insertAll(mArrayList);
            }
        }).start();
    }

    private void listAll()
    {
        new AsyncTask<Void, Void, ArrayList<Profile>>()
        {
            @Override
            protected ArrayList<Profile> doInBackground(Void... voids)
            {
                mArrayList = (ArrayList<Profile>) App.get().getDBInstance().profileDao().getAllProfiles();
                return mArrayList;
            }

            @Override
            protected void onPostExecute(ArrayList<Profile> arrayList)
            {
                super.onPostExecute(arrayList);
                mAdapter = new ProfileAdapter(MainActivity.this, arrayList);
                mRecyclerView.setAdapter(mAdapter);
            }
        }.execute();
    }

}
