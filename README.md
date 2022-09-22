# Android-Onboarding-Screen

Youtube Link: https://www.youtube.com/watch?v=OcXAJDCI5Zs

First, implement ViewPager2 in lower API version but in the later version of Android Studio it's already default. 

After that upload your images in drawable

![image](https://user-images.githubusercontent.com/84573685/191233721-44eb8cf0-3b3f-4547-b25a-1e19db5c7366.png)

## colors.xml

Edit your colors.xml in your preference.

![image](https://user-images.githubusercontent.com/84573685/191231075-bdc45ffc-e450-4546-8e13-a99ccc5e4ef0.png)


## activity_main.xml 

Edit activity_main.xml or your main activity for Onboarding Screen.

![image](https://user-images.githubusercontent.com/84573685/191231633-4133379b-5f2e-441e-a91f-b93d05153a94.png)

### Code 
``` 
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:background="@color/colorBackground">


    <com.google.android.material.button.MaterialButton
        android:id="@+id/buttonOnboardingAction"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginRight="20dp"
        android:layout_marginBottom="15dp"
        android:textSize="15sp"
        app:cornerRadius="20dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        />

    <androidx.viewpager2.widget.ViewPager2
        android:id="@+id/onboardingViewpager"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        />


    <LinearLayout
        android:id="@+id/layoutOnboardingIndicator"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="20dp"
        android:layout_marginEnd="20dp"
        android:orientation="horizontal"
        android:padding="15dp"
        app:layout_constraintBottom_toBottomOf="@id/buttonOnboardingAction"
        app:layout_constraintRight_toLeftOf="@id/buttonOnboardingAction"
        app:layout_constraintLeft_toLeftOf="parent" />


</androidx.constraintlayout.widget.ConstraintLayout>
```
## onboarding_items.xml
onboarding_items.xml is where the Images, Titles, and Description will be placed.

![image](https://user-images.githubusercontent.com/84573685/191232880-4011e60a-c773-4493-be44-9b44c64c1281.png)

### Code
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_marginStart="30dp"
    android:layout_marginEnd="30dp"
    android:layout_marginBottom="30dp"
    android:gravity="center"
    android:padding="20dp">


    <ImageView
        android:id="@+id/imageOnboarding"
        android:layout_width="260dp"
        android:layout_height="260dp"
        android:layout_margin="15sp"
        android:adjustViewBounds="true"
        android:contentDescription="@string/app_name"/>


    <TextView
        android:id="@+id/textTitle"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:textColor="@color/colorTextPrimary"
        android:textSize="20sp"
        android:textStyle="bold"/>

    <TextView
        android:id="@+id/textDescription"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:textColor="@color/colorTextSecondary"
        android:textSize="18sp"/>

</LinearLayout>
```

## indicator XML File

The onboarding indicators are drawable shape files that can be seen in drawable folder

### onboarding_indicator_active.xml

![image](https://user-images.githubusercontent.com/84573685/191234755-fa9243bc-4167-4a4c-bc83-9610a40c0c73.png)

### onboarding_indicator_inactive.xml

![image](https://user-images.githubusercontent.com/84573685/191234891-ca014fab-f5be-4e27-9986-43f6848ae207.png)


## OnboardingItems.java
Create OnboardingItems Java Class

Declare the image, title, description variables
```
    private int image;
    private String title;
    private String description;
```

After declaring the variables need, generate setters and getters


Getters and setters are used to protect your data, particularly when creating classes. For each instance variable, a getter method returns its value while a setter method sets or updates its value. Given this, getters and setters are also known as accessors and mutators, respectively
```
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
```

## Android Adapter

In Android, Adapter is a bridge between UI component and data source that helps us to fill data in UI component. It holds the data and send the data to an Adapter view then view can takes the data from the adapter view and shows the data on different views like as ListView, GridView, Spinner etc.

## OnboardingAdapter.java

Create Adapter Class for onboarding in the package of the project

After creating OnboardingAdapter extend it to RecyclerView.Adapter
```

public class OnboardingAdapter extends RecyclerView.Adapter<OnboardingAdapter.onboardingViewHolder>


```

Implement all the methods

![image](https://user-images.githubusercontent.com/84573685/191240294-691c30ab-ceea-453e-b3de-fd91ba66cf6f.png)

Declare the List
```


private List<OnboardingItems> onboardingItems;


```

Generate Constructor for the OnboardingItems List

![image](https://user-images.githubusercontent.com/84573685/191241039-de729b6a-dc83-475d-b2c0-283f341b1f10.png)

```

public OnboardingAdapter(List<OnboardingItems> onboardingItems) {
    this.onboardingItems = onboardingItems;
}
    
```



Edit onboardingViewHolder

Return it to onboardingViewHolder then inflate the view

```


return new onboardingViewHolder(
        LayoutInflater.from(parent.getContext()).inflate(
                R.layout.onboarding_items, parent, false
        )
);
        
        
```


Edit the method onBindViewHolder and getItemCount

```

@Override
public void onBindViewHolder(@NonNull onboardingViewHolder holder, int position) {
    holder.setOnboardingData(onboardingItems.get(position));
}

@Override
public int getItemCount() {
    return onboardingItems.size();
}
    
```





Create another class named onboardingViewHolder and extend to RecyclerView.ViewHolder
```


class onboardingViewHolder extends RecyclerView.ViewHolder


```

Declare the variables needed 
```
private TextView textTitle;
private TextView textDescription;
private ImageView imageOnboarding;       
```

Generate a constructor but select none and find the id of the views(Image, Title, Description) declared in the xml file 
```
public onboardingViewHolder(@NonNull View itemView) {
    super(itemView);
    textTitle = itemView.findViewById(R.id.textTitle);
    textDescription = itemView.findViewById(R.id.textDescription);
    imageOnboarding = itemView.findViewById(R.id.imageOnboarding);
}
```

Create method called setOnboardingData this will call the setters and getters that we create in the OnboardingItems.java
```
void setOnboardingData(OnboardingItems onboardingItems)
```

Connection of the OnboardingItems and the OnboardingAdapter
```
void setOnboardingData(OnboardingItems onboardingItems){
    textTitle.setText(onboardingItems.getTitle());
    textDescription.setText(onboardingItems.getDescription());
    imageOnboarding.setImageResource(onboardingItems.getImage());
}
```

## MainActivity.java

Declare OnboardingAdapter on MainActivity

```
OnboardingAdapter onboardingAdapter;
```

Create another method for the Arraylist of Onboarding Screens
```
private void setupOnboardingItems(){}
```

Declare the List
```
List<OnboardingItems> onboardingItems = new ArrayList<>();
```

Set the data per variables and appened  
```
OnboardingItems featuresItemsFirst = new OnboardingItems();
featuresItemsFirst.setTitle("List of Features First");
featuresItemsFirst.setDescription("There are various of features items in our application for safeplace");
featuresItemsFirst.setImage(R.drawable.feat_1);

onboardingItems.add(featuresItemsFirst);
onboardingItems.add(featuresItemsSecond);
onboardingItems.add(featuresItemsThird);
onboardingItems.add(featuresItemsFourth);
```

Connect onboardingItems and OnboardingAdapter
```
onboardingAdapter = new OnboardingAdapter(onboardingItems);
```

## Whole Code for the method setupOnboardingItems()
```
private void setupOnboardingItems(){
List<OnboardingItems> onboardingItems = new ArrayList<>();

OnboardingItems featuresItemsFirst = new OnboardingItems();
featuresItemsFirst.setTitle("List of Features First");
featuresItemsFirst.setDescription("There are various of features items in our application for safeplace");
featuresItemsFirst.setImage(R.drawable.feat_1);


OnboardingItems featuresItemsSecond = new OnboardingItems();
featuresItemsSecond.setTitle("List of Features Second");
featuresItemsSecond.setDescription("There are various of features items in our application for safeplace");
featuresItemsSecond.setImage(R.drawable.feat_2);


OnboardingItems featuresItemsThird = new OnboardingItems();
featuresItemsThird.setTitle("List of Features Third");
featuresItemsThird.setDescription("There are various of features items in our application for safeplace");
featuresItemsThird.setImage(R.drawable.feat_3);

OnboardingItems featuresItemsFourth = new OnboardingItems();
featuresItemsFourth.setTitle("List of Features Fourth");
featuresItemsFourth.setDescription("There are various of features items in our application for safeplace");
featuresItemsFourth.setImage(R.drawable.feat_4);

onboardingItems.add(featuresItemsFirst);
onboardingItems.add(featuresItemsSecond);
onboardingItems.add(featuresItemsThird);
onboardingItems.add(featuresItemsFourth);

onboardingAdapter = new OnboardingAdapter(onboardingItems);
}
    
```


In the onCreate Method

Declare the ViewPager2
```
final ViewPager2 onboardingViewPager = findViewById(R.id.onboardingViewpager);
```

call the method setupOnboardingItems
```
setupOnboardingItems();
```

Pass the ViewPager2 onboardingViewPager to the adapter onboardingAdapter
```
onboardingViewPager.setAdapter(onboardingAdapter);
```

### **After this Test the application you should swipe and see all the screen that you set**

## Dot indicator

### Showing of indicator 

Declare LinearLayout on MainActivity
```
LinearLayout layoutOnboardingIndicator;
```

Find id for the LinearLayout layoutOnboardingIndicator
```
layoutOnboardingIndicator = findViewById(R.id.layoutOnboardingIndicator);
```

Create method setupOnboardingIndicator this method will make the dot indicator show and it will get the number of screens in the array and will show it 

```
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
```

Dont Forget to declare the method in the OnCreate
```
setupOnboardingIndicator();
```

### Indicator will now move depends on its page position

create method setCurrentOnboardingIndicator
```
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
}
```

Call the method inside the OnCreate method
```
setCurrentOnboardingIndicator(0);
```

Still inside the OnCreate Method Call the registerOnPageChangeCallback for the dot indicator to move
```
onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
    @Override
    public void onPageSelected(int position) {
        super.onPageSelected(position);
        setCurrentOnboardingIndicator(position);
    }
});
```


### CREATE ANOTHER EMPTY ACTIVITY FOR THE BUTTON TEST

### Change the text of button if it's in the last screen

Declare MaterialButton buttonOnboaringAction on MainActivity
```
MaterialButton buttonOnboaringAction;
```

Find the id of the button
```
 buttonOnboaringAction = findViewById(R.id.buttonOnboardingAction);
```

Still inside the OnCreate Method set an OnClickLister
```
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
```

Inside the setCurrentOnboardingIndicator Method put the the if else condition below to change the text of the button
```
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
```

## Code for the MainActivity.java
```
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
        final ViewPager2 onboardingViewPager = findViewById(R.id.onboardingViewpager);


        setupOnboardingItems();
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


    //ArrayList of Onboarding Screens
    private void setupOnboardingItems(){
        List<OnboardingItems> onboardingItems = new ArrayList<>();

        OnboardingItems featuresItemsFirst = new OnboardingItems();
        featuresItemsFirst.setTitle("List of Features First");
        featuresItemsFirst.setDescription("There are various of features items in our application for safeplace");
        featuresItemsFirst.setImage(R.drawable.feat_1);


        OnboardingItems featuresItemsSecond = new OnboardingItems();
        featuresItemsSecond.setTitle("List of Features Second");
        featuresItemsSecond.setDescription("There are various of features items in our application for safeplace");
        featuresItemsSecond.setImage(R.drawable.feat_2);


        OnboardingItems featuresItemsThird = new OnboardingItems();
        featuresItemsThird.setTitle("List of Features Third");
        featuresItemsThird.setDescription("There are various of features items in our application for safeplace");
        featuresItemsThird.setImage(R.drawable.feat_3);

        OnboardingItems featuresItemsFourth = new OnboardingItems();
        featuresItemsFourth.setTitle("List of Features Fourth");
        featuresItemsFourth.setDescription("There are various of features items in our application for safeplace");
        featuresItemsFourth.setImage(R.drawable.feat_4);

        onboardingItems.add(featuresItemsFirst);
        onboardingItems.add(featuresItemsSecond);
        onboardingItems.add(featuresItemsThird);
        onboardingItems.add(featuresItemsFourth);

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
```

































