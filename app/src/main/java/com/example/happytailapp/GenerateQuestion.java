package com.example.happytailapp;

public class GenerateQuestion {
    public static String categories[] = {
            "A. Time",
            "A. Time",
            "B. Expenses",
            "B. Expenses",
            "C. Place",
            "C. Place",
            "D. Lifestyle",
            "D. Lifestyle",
            "D. Lifestyle",
            "E. Reason",
    };

    public static int icons[] = {
            R.drawable.ic_baseline_access_time_24,
            R.drawable.ic_baseline_access_time_24,
            R.drawable.peso,
            R.drawable.peso,
            R.drawable.home,
            R.drawable.home,
            R.drawable.ic_baseline_fitness_center_24,
            R.drawable.ic_baseline_fitness_center_24,
            R.drawable.ic_baseline_fitness_center_24,
            R.drawable.ic_baseline_search_24,
    };

    public static String questions[] = {
            "How much free time do you have per week?",
            "How committed will you be to your pet?",
            "How much are you willing to pay for a new pet?",
            "How much are you willing to pay for your pet’s monthly maintenance?",
            "Do you live in an apartment?",
            "Do you want to have a peaceful and quiet home at all times?",
            "How often do you work out?",
            "How often do you leave your home?",
            "How much training are you willing to do?",
            "What is your main reason for getting a pet?",
    };

    public static String choices[][] = {
            {"3-5 hours", "6-8 hours", "8-10 hours", "10+ hours"},
            {"It will always be by my side.", "I can take it out every day.", "I can play with it once per day.", "I can interact with it once per week."},
            {"Less than ₱100.00", "₱200.00-₱400.00", "More than ₱500.00", "Anything it takes"},
            {"₱500.00", "₱1000.00", "₱2000.00", "More than ₱3000.00"},
            {"No", "Kind of", "Not always", "Yes"},
            {"No", "Kind of", "Not always", "Yes"},
            {"Always", "Sometimes", "Rarely", "Never"},
            {"Everyday", "A couple of times a week", "Once a month", "Never"},
            {"I’m not planning on training it.", "I’m prepared for the basics.", "A little bit since it’s fun!", "As much as it takes."},
            {"I need a new friend.", "I need something new.", "I need a cute creature to love.", "I feel lonely all the time."},
    };

    public String getCategories(int a) {
        return categories[a];
    }

    public int getIcons(int a) {
        return icons[a];
    }

    public String getQuestions(int a) {
        return questions[a];
    }

    public String getChoice1(int a) {
        return choices[a][0];
    }

    public String getChoice2(int a) {
        return choices[a][1];
    }

    public String getChoice3(int a) {
        return choices[a][2];
    }

    public String getChoice4(int a) {
        return choices[a][3];
    }
}
