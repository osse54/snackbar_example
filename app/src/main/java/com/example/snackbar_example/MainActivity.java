package com.example.snackbar_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick:");
                /*
                 키보드 레이아웃이 뜨면 가려지는 경우
                <activity
                    android:name=".MainActivity"
                    android:windowSoftInputMode="adjustResize"
                스낵바에 스와이프 기능을 추가하려면
                스낵바 스와이프 기능을 사용하고자 하는 액티비티의 root layout을
                CoordinatorLayout으로 wrapping 해야한다.
                쉽게 말하면 기존 root layout을 CoordinatorLayout으로 감싸면 된다.

                CoordinatorLayout을 사용하면 생기는 이점이 하나 더 생긴다.
                FAB과 Snackbar가 곂치는 경우도 발생하는데, 이 경우에 FAB을 스낵바에 가려지지 않게
                스낵바의 위로 위치를 조정해준다.

                <!--  감싸는 레이아웃, wrapping layout  -->
                <androidx.coordinatorlayout.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
                    xmlns:app="http://schemas.android.com/apk/res-auto"
                    xmlns:tools="http://schemas.android.com/tools"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    tools:context=".MainActivity">

                <!--  메인 레이아웃  -->
                <androidx.constraintlayout.widget.ConstraintLayout
                    android:id="@+id/activity_main"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent">

                <!--  FAB이 그냥 우측 하단에 고정되어 있고, 키보드 레이아웃이나 Behavior의 animation이
                곂치는 경우에만 조금의 위치 변경으로 view가 곂치지 않게 하는 정도만 필요하다면 anchor 속성이 필요하진 않다.
                   하지만 해당 activity에서 메인 layout의 위치 또는 크기 변경에 맞춰서 위치의 변경이 필요하다면 anchor 속성을 이용하는 것이 좋다.-->
                <com.google.android.material.floatingactionbutton.FloatingActionButton
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_margin="20dp"
                    app:layout_anchor="@id/activity_main"
                    app:layout_anchorGravity="bottom|right" />

                <!--    <com.google.android.material.floatingactionbutton.FloatingActionButton-->
                <!--        android:layout_width="wrap_content"-->
                <!--        android:layout_height="wrap_content"-->
                <!--        android:layout_gravity="bottom|right"-->
                <!--        android:layout_margin="20dp" />-->
                 */

                String message = "Snackbar";
                Snackbar.make(findViewById(R.id.coordinatorLayout), message, Snackbar.LENGTH_SHORT)
                        .show();
                // 스낵바는 한 번에 하나만 띄울 수 있단다. Snackbars appear above all other elements on screen and only one can be displayed at a time.
//                Snackbar.make(findViewById(R.id.coordinatorLayout), message + 1, Snackbar.LENGTH_SHORT)
//                        .show();
//                Snackbar.make(findViewById(R.id.coordinatorLayout), message + 2, Snackbar.LENGTH_SHORT)
//                        .show();
//                Snackbar.make(findViewById(R.id.coordinatorLayout), message + 3, Snackbar.LENGTH_SHORT)
//                        .show();
            }
        });

    }
}