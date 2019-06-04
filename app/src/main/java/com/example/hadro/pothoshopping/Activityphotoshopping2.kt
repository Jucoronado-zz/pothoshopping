package com.example.hadro.pothoshopping

import android.Manifest
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

import kotlinx.android.synthetic.main.activity_activityphotoshopping2.*

class Activityphotoshopping2 : AppCompatActivity() {

    private var MagicalPermissions magicalPermissions
    private var var RESIZE_PHOTO_PIXELS_PERCENTAGE = 50
    private var MagicalCamera magicalcamera

    fun onCreate(savedInstanceState: Bundle?) {




        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activityphotoshopping2)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }


        val imafoto= findViewById(R.id.foto) as ImageView
        val tomarfoto= findViewById(R.id.TomarFoto) as Button


        String[] permissions = new String[]{
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
        };

        magicalPermissions = new MagicalPermissions(this, permissions);
        magicalCamera = new MagicalCamera(this, RESIZE_PHOTO_PIXELS_PERCENTAGE, magicPermissions);
    }

}
