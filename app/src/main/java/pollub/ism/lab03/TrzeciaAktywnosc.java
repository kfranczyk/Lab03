package pollub.ism.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

public class TrzeciaAktywnosc extends AppCompatActivity {
    public static final int CAMERA_PIC_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trzecia_aktywnosc);
    }

    public void otworzStrone(View view){
        Intent intencja = new Intent(Intent.ACTION_VIEW);
        intencja.setData(Uri.parse("https://tomasznowicki.gitbook.io/ism/"));

        try {
            startActivity(intencja);
        }
        catch (ActivityNotFoundException e){
            Toast.makeText(this, "Brak przeglądarki",Toast.LENGTH_LONG).show();
        }
    }

    public void zadzwon(View view){
        Intent intencja = new Intent(Intent.ACTION_DIAL);

        intencja.setData(Uri.parse("tel:" + 226952900));

        try{
            startActivity(intencja);
        }catch (ActivityNotFoundException e){
            Toast.makeText(this,"Brak możliwości dzwonienia",Toast.LENGTH_LONG).show();
        }
    }

    //próbowałem coś z kamerą ale to nie działa
    public void showCamera(View view){
        PackageManager pm = getPackageManager();
        if(pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)) { //sprawdzenie czy istnieje jakas kamera na urządzeniu

            Intent intencja = new Intent("android.media.action.IMAGE_CAPTURE");
            try {
                startActivityForResult(intencja, CAMERA_PIC_REQUEST);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(this, "Brak możliwości zrobienia zdjecia", Toast.LENGTH_LONG).show();
            }
        }
        else
            Toast.makeText(this, "Brak kamery??", Toast.LENGTH_LONG).show();
    }


    public void powrotTrzecia(View view){
        Toast.makeText(this,"wychodze z trzeciej aktywnosci",Toast.LENGTH_SHORT).show();
        finish();
    }

}