package com.example.assignment.activities;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.assignment.R;
import com.example.assignment.adapters.CustomUserAdapter;
import com.example.assignment.services.UserService;
import com.example.assignment.services.impl.UserServiceImpl;

public class MainActivity extends BaseActivity {

    private UserService userService;
    private ListView ListViewUser;
    private CustomUserAdapter customUserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        userService = new UserServiceImpl();
        ListViewUser = findViewById(R.id.list);
        getUserData();

    }
    private void getUserData(){
        userService.getAllRoles();
        customUserAdapter= new CustomUserAdapter(this,userService.getAllUser());
        ListViewUser.setAdapter(customUserAdapter);
    }
}