package com.example.happytailapp;

public class GenerateRecommendedPets {
    private String petCategory;
    private String petName;
    private String petLocation;
    private String petGender;
    private int petPicture;

    public GenerateRecommendedPets(String category, String name, String location, String gender, int picture) {
        petCategory = category;
        petName = name;
        petLocation = location;
        petGender = gender;
        petPicture = picture;
    }

    public String getPetCategory() {
        return petCategory;
    }

    public String getPetName() {
        return petName;
    }

    public String getPetLocation() {
        return petLocation;
    }

    public String getPetGender() {
        return petGender;
    }

    public int getPetPicture() {
        return petPicture;
    }
}
