package com.mdproject.bda.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mdproject.bda.Model.User;
import com.mdproject.bda.R;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;



public class UserAdapter extends RecyclerView.Adapter<UserAdapter.Viewholder>{

    private Context context;
    private List<User> userList;

    public UserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @androidx.annotation.NonNull
    @Override
    public Viewholder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_displayed_layout, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull Viewholder holder, int position) {
        final User user = userList.get(position);
// Email button ka codee he yee
//        holder.type.setText(user.getType());
//        if (user.getType().equals("donor")){
//            holder.emailNow.setVisibility(View.VISIBLE);
//        }
        //iske upar tak email ka code he jyada hosiyari me delete mat karna
        holder.type.setText(user.getType());
        holder.userEmail.setText(user.getEmail());
        holder.phoneNumber.setText(user.getPhonenumber());
        holder.userName.setText(user.getName());
        holder.bloodGroup.setText(user.getBloodgroup());

        Glide.with(context).load(user.getProfilepictureurl()).into(holder.userProfileimage);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        public CircleImageView userProfileimage;
        public TextView type, userName, userEmail, phoneNumber, bloodGroup;
        public Button emailNow;

        public Viewholder(@NonNull View itemView){
            super(itemView);

            userProfileimage = itemView.findViewById((R.id.user_profile_image));
            type = itemView.findViewById(R.id.type);
            userName = itemView.findViewById(R.id.userName);
            userEmail = itemView.findViewById(R.id.userEmail);
            phoneNumber = itemView.findViewById(R.id.phoneNumber);
            bloodGroup = itemView.findViewById(R.id.bloodGroup);
            emailNow = itemView.findViewById(R.id.emailNow);

        }
    }
}