package com.example.hadro.pothoshopping

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.preference.PreferenceManager
import android.provider.MediaStore
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.content_activityphotoshopping2.*

import kotlinx.android.synthetic.main.layoutphotoshopping2.*

class Activityphotoshopping2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layoutphotoshopping2)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

            //con piccasso se carga  una imagen predefinida

            val img = findViewById(R.id.foto) as ImageView
            Picasso.get()
                .load("https://miro.medium.com/max/864/1*gZ9XF80M8yOasLiFUzL07g.png")
                .into(img)
            // USAMOS LA CAMARA PARA TOMAR UNA FOTO

            Tfoto.setOnClickListener {
                var i= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(i,123)
            }
    }

}

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==123)
        {
            var tf= data?.extras?.get("data") as Bitmap
            foto.setImageBitmap(tf)

            val intent = Intent(this@Activityphotoshopping2, Activityphotoshopping3::class.java)
            intent.putExtra("vec", " " )
            startActivity(intent)
        }
    }

    }