package dangthuongngo.com.hoclistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void moManHinhListViewBasic1(View view) {
        Intent intent=new Intent(MainActivity.this,ListViewBasic1Activity.class);
        startActivity(intent);
    }

    public void moManHinhListViewBasic2(View view) {
        Intent intent=new Intent(MainActivity.this,ListViewBasic2Activity.class);
        startActivity(intent);

    }
}
