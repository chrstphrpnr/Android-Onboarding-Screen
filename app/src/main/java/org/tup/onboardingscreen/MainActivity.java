package org.tup.onboardingscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    OnboardingAdapter onboardingAdapter;
    LinearLayout layoutOnboardingIndicator;
    MaterialButton buttonOnboaringAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutOnboardingIndicator = findViewById(R.id.layoutOnboardingIndicator);
        buttonOnboaringAction = findViewById(R.id.buttonOnboardingAction);

        setupOnboardingItems();
        final ViewPager2 onboardingViewPager = findViewById(R.id.onboardingViewpager);
        onboardingViewPager.setAdapter(onboardingAdapter);

        setupOnboardingIndicator();
        setCurrentOnboardingIndicator(0);

        onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardingIndicator(position);
            }
        });


        buttonOnboaringAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onboardingViewPager.getCurrentItem() + 1 < onboardingAdapter.getItemCount()){
                    onboardingViewPager.setCurrentItem(onboardingViewPager.getCurrentItem() + 1);
                }
                else {
                   startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                   finish();
                }
            }
        });

    }


    private void setupOnboardingItems(){
        List<OnboardingItems> onboardingItems = new ArrayList<>();

        OnboardingItems featuresItemsFirst = new OnboardingItems();
        featuresItemsFirst.setTitle("List of Features First");
        featuresItemsFirst.setDescription("There are various of features items in our application for safeplace");
        featuresItemsFirst.setImage(R.drawable.first);


        OnboardingItems featuresItemsSecond = new OnboardingItems();
        featuresItemsSecond.setTitle("List of Features Second");
        featuresItemsSecond.setDescription("There are various of features items in our application for safeplace");
        featuresItemsSecond.setImage(R.drawable.second);


        OnboardingItems featuresItemsThird = new OnboardingItems();
        featuresItemsThird.setTitle("List of Features Third");
        featuresItemsThird.setDescription("There are various of features items in our application for safeplace");
        featuresItemsThird.setImage(R.drawable.third);


        onboardingItems.add(featuresItemsFirst);
        onboardingItems.add(featuresItemsSecond);
        onboardingItems.add(featuresItemsThird);

        onboardingAdapter = new OnboardingAdapter(onboardingItems);
    }


    private void setupOnboardingIndicator(){
        ImageView[] indicators = new ImageView[onboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8,0,8,0);

        for (int i = 0; i <indicators.length ; i++) {
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.onboarding_indicator_inactive
            ));

            indicators[i].setLayoutParams(layoutParams);
            layoutOnboardingIndicator.addView(indicators[i]);
        }
    }

    private void setCurrentOnboardingIndicator(int index){
        int childCount = layoutOnboardingIndicator.getChildCount();
        for(int i=0; i<childCount; i++){
            ImageView imageView = (ImageView) layoutOnboardingIndicator.getChildAt(i);
            if(i == index){
                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_active));
            }
            else {
                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_inactive));
            }
        }

        if (index == onboardingAdapter.getItemCount() - 1){
            buttonOnboaringAction.setText("Start");
        }
        else {
            buttonOnboaringAction.setText("Next");
        }

    }



}