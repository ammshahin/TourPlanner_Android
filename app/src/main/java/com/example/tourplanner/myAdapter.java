package com.example.tourplanner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myAdapter extends FirebaseRecyclerAdapter<model,myAdapter.myViewHolder> {

    public myAdapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull model model) {
        holder.nameText.setText(model.getName());
        holder.priceText.setText("Price: "+model.getPrice()+" tk");
        holder.offerText.setText("Package Includes: "+model.getOffer());
//        holder.detailsText.setText(model.getDetail());

        Glide.with(holder.img1.getContext()).load(model.getImurl()).into(holder.img1);
        holder.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity myActivity = (AppCompatActivity) v.getContext();
                myActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.containerId, new placeDetailsFragment(model.detail,model.imurl,model.name,model.offer,model.price))
                        .addToBackStack(null).commit();
            }
        });
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_design,parent,false);

        return new myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView img1;
        TextView nameText,priceText, offerText, detailsText;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img1 = itemView.findViewById(R.id.img1);
            nameText = itemView.findViewById(R.id.nametext);
            priceText = itemView.findViewById(R.id.priceText);
            offerText = itemView.findViewById(R.id.offerText);
//            detailsText = itemView.findViewById(R.id.detailsText);

        }
    }
}
