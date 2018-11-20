package com.example.aaron.myapplication;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    private RecyclerView homeList;
    private DatabaseReference mDatabase;
    private DatabaseReference mDatabaseRoommate;

    private FirebaseAuth mAuth=FirebaseAuth.getInstance();
    String roomId;
    String roommatesChores;

    FirebaseUser user = mAuth.getCurrentUser();


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String room=FirebaseDatabase.getInstance().getReference().child("User").child(user.getUid()).child("RoomID").getKey();
        //mDatabase=FirebaseDatabase.getInstance().getReference().child("Roommates").child(room).child("ChoreList");
        mDatabase=FirebaseDatabase.getInstance().getReference().child("Chore");
        mDatabaseRoommate=FirebaseDatabase.getInstance().getReference();

        mDatabase.keepSynced(true);
        View v = inflater.inflate(R.layout.fragment_home, container, false);

         roomId=mDatabaseRoommate.child("User").child(user.getUid()).child("RoomID").getKey();
         roommatesChores= mDatabaseRoommate.child("Roommates").child("ChoreList").getKey();






        homeList= v.findViewById(R.id.homeRecycleview);
        homeList.setHasFixedSize(true);
        homeList.setLayoutManager(new LinearLayoutManager(getActivity()));



        // Inflate the layout for this fragment
        return v;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        FirebaseRecyclerAdapter<choreInfo,choreInfoHolder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<choreInfo, choreInfoHolder>
                (choreInfo.class, R.layout.home_row, choreInfoHolder.class, mDatabase ) {
            @Override
            protected void populateViewHolder(choreInfoHolder viewHolder, final choreInfo model, int position) {





               // if(mDatabase.child("Roommates").child(model.getID()).exists()){
               //     Toast.makeText(getActivity(), "here", Toast.LENGTH_SHORT).show();

               // }

                viewHolder.setTitle(model.getName());

               // viewHolder.setTitle(model.getName());
                viewHolder.setImage(getActivity().getApplicationContext(),model.getImage());
               // Toast.makeText(getActivity(), roommatesChores, Toast.LENGTH_SHORT).show();

                viewHolder.setTurn(model.getDescription());

            }
        };

        homeList.setAdapter(firebaseRecyclerAdapter);

    }

    public static class choreInfoHolder extends RecyclerView.ViewHolder{
        View mView;
        public choreInfoHolder(View itemView)
        {
            super(itemView);
            mView=itemView;
        }
        public void setTitle(String title){
            TextView choreTitle= (TextView)mView.findViewById(R.id.choreTitle);
            choreTitle.setText(title);
        }
        public void setTurn(String title){
            TextView turnTitle= (TextView)mView.findViewById(R.id.choreTurn);
            turnTitle.setText(title);
        }

        public void setImage(Context ctx, String image){
            ImageView choreImage=(ImageView)mView.findViewById(R.id.chorePic);
            Picasso.with(ctx).load(image).into(choreImage);
        }
    }

}
