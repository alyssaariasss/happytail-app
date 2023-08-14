package com.example.happytailapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;

public class RecoPetsRecyclerView extends RecyclerView.Adapter<RecoPetsRecyclerView.RecoPetsHolder> {

    GenerateRecommendedPets[] recoPetsList;

    public RecoPetsRecyclerView(GenerateRecommendedPets[] recoPetsList) {
        this.recoPetsList = recoPetsList;
    }

    @NonNull
    @Override
    public RecoPetsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_recommended_pet, parent, false);
        RecoPetsHolder recoPetsHolder = new RecoPetsHolder(view);
        return recoPetsHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecoPetsHolder holder, int position) {
        GenerateRecommendedPets pets = recoPetsList[position];

        holder.petCategory.setText(pets.getPetCategory());
        holder.petName.setText(pets.getPetName());
        holder.petLocation.setText(pets.getPetLocation());

        holder.petImage.setImageResource(pets.getPetPicture());

        String gender = pets.getPetGender();

        if (Objects.equals(gender, "Female")) {
            holder.petGenderImg.setImageResource(R.drawable.ic_baseline_female_24);
        } else {
            holder.petGenderImg.setImageResource(R.drawable.ic_baseline_male_24);
        }
    }

    @Override
    public int getItemCount() {
        return recoPetsList.length;
    }

    public class RecoPetsHolder extends RecyclerView.ViewHolder {

        TextView petCategory, petName, petLocation;
        ImageView petImage, petGenderImg;

        public RecoPetsHolder(@NonNull View itemView) {
            super(itemView);
            petCategory = itemView.findViewById(R.id.petCategoryText);
            petName = itemView.findViewById(R.id.petName);
            petLocation = itemView.findViewById(R.id.petLocation);
            petImage = itemView.findViewById(R.id.petPictureHolder);
            petGenderImg = itemView.findViewById(R.id.petGenderImg);
        }
    }
}
