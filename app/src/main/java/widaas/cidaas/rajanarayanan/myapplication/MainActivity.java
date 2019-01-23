package widaas.cidaas.rajanarayanan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import widaas.cidaas.rajanarayanan.myandroidlibrary.AndroidCidaas;
import widaas.cidaas.rajanarayanan.mylibrary.SampleTesting;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SampleTesting sampleTesting=new SampleTesting();
        AndroidCidaas androidCidaas=new AndroidCidaas();

        Toast.makeText(this, ""+ sampleTesting.getName(), Toast.LENGTH_SHORT).show();

        Toast.makeText(this, ""+androidCidaas.getGetClass(), Toast.LENGTH_SHORT).show();
    }


}
