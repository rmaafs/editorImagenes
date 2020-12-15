package com.pacomedina.uaa.editorimagenes

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var btnTomarFoto: Button
    private lateinit var btnGaleria: Button
    private lateinit var imgFoto: ImageView

    private val PERMISSION_CODE = 1000;
    private val IMAGE_PICK_CODE = 1001
    var image_uri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTomarFoto = findViewById(R.id.btnTomarFoto)
        btnGaleria = findViewById(R.id.btnGaleria)
        imgFoto = findViewById(R.id.imgFoto)

        btnTomarFoto.setOnClickListener {
            tomarFoto();
        }

        btnGaleria.setOnClickListener {
            tomarGaleria();
        }
    }

    private fun tomarFoto() {
        //if system os is Marshmallow or Above, we need to request runtime permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED ||
                checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_DENIED
            ) {
                //permission was not enabled
                val permission = arrayOf(
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
                //show popup to request permission
                requestPermissions(permission, PERMISSION_CODE)
            } else {
                //permission already granted
                openCamera()
            }
        } else {
            //system os is < marshmallow
            openCamera()
        }
    }

    private fun openCamera() {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, "New Picture")
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera")
        image_uri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
        //camera intent
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri)
        startActivityForResult(cameraIntent, PERMISSION_CODE)
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        //called when user presses ALLOW or DENY from Permission Request Popup
        when (requestCode) {
            PERMISSION_CODE -> {
                if (grantResults.size > 0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED
                ) {
                    //permission from popup was granted
                    openCamera()
                } else {
                    //permission from popup was denied
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            };

            IMAGE_PICK_CODE -> {
                if (grantResults.size > 0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED
                ) {
                    //permission from popup was granted
                    pickImageFromGallery()
                } else {
                    //permission from popup was denied
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    /**
     * Función que se ejecuta cuando aceptamos la foto que tomamos.
     */
    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val intent = Intent(this@MainActivity, FiltrosActivity::class.java);
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
            imgFoto.setImageURI(data?.data)
            intent.putExtra("imagen", data?.data.toString())
        } else if (resultCode == Activity.RESULT_OK) {
            //set image captured to image view
            imgFoto.setImageURI(image_uri)
            intent.putExtra("imagen", image_uri.toString())
        }
        startActivity(intent);
    }

    private fun tomarGaleria() {
        //check runtime permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_DENIED
            ) {
                //permission denied
                val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
                //show popup to request runtime permission
                requestPermissions(permissions, IMAGE_PICK_CODE);
            } else {
                //permission already granted
                pickImageFromGallery();
            }
        } else {
            //system OS is < Marshmallow
            pickImageFromGallery();
        }
    }

    private fun pickImageFromGallery() {
        //Intent to pick image
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }
}