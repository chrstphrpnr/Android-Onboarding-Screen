# Android-Onboarding-Screen

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

Create inside another class inside it named onboardingViewHolder and extend to RecyclerView.ViewHolder
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




