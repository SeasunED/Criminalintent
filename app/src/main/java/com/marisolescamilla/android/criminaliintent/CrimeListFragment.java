package com.marisolescamilla.android.criminaliintent;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.marisolescamilla.android.criminaliintent.model.Crime;
import com.marisolescamilla.android.criminaliintent.model.CrimeLab;

import java.util.List;

public class CrimeListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private CrimeAdapter mAdapter;

    public void updateUI(){
        CrimeLab crimeLab=CrimeLab.get(getActivity());
        List<Crime> crimes=crimeLab.getCrimes();
        mAdapter= new CrimeAdapter(crimes);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_crime_list,container,false);
        mRecyclerView=view.findViewById(R.id.crime_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;


    }

    private class CrimeHolder extends RecyclerView.ViewHolder{
        public TextView mTitleTextView;

        public CrimeHolder(View itemView) {
            super(itemView);
            mTitleTextView=(TextView) itemView;
        }
    }

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{
        private List<Crime> mCrimes;

        public CrimeAdapter(List<Crime> crimes){
            mCrimes=crimes;

        }
        @NonNull
        @Override
        public CrimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
            LayoutInflater layoutInflater= LayoutInflater.from(getActivity());
            View view=layoutInflater.inflate(
                    android.R.layout.simple_list_item_1,parent,false
            );

            return new CrimeHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CrimeHolder holder, int position) {
            Crime crime=mCrimes.get(position);
            holder.mTitleTextView.setText(crime.getTitle());
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }
}
