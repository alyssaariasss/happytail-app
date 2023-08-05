package com.example.happytailapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerAdapter extends PagerAdapter {

    Context context;

    int[] images = {
            R.drawable.undraw_dog_walking,
            R.drawable.undraw_quality_time,
            R.drawable.undraw_post
    };

    int[] title = {
            R.string.reco_title,
            R.string.adoption_title,
            R.string.blog_title
    };

    int[] description = {
            R.string.reco_text,
            R.string.adoption_text,
            R.string.blog_text
    };

    public ViewPagerAdapter (Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout, container, false);

        ImageView sliderLayoutImage = view.findViewById(R.id.slideImage);
        TextView sliderLayoutTitle = view.findViewById(R.id.slideTitle);
        TextView sliderLayoutText = view.findViewById(R.id.slideText);

        sliderLayoutImage.setImageResource(images[position]);
        sliderLayoutTitle.setText(title[position]);
        sliderLayoutText.setText(description[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
