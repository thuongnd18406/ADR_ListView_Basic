package dangthuongngo.com.hoclistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import dangthuongngo.com.hoclistview.databinding.ActivityListViewBasic1Binding;

public class ListViewBasic1Activity extends AppCompatActivity {
    ActivityListViewBasic1Binding binding;
    ArrayAdapter<String> adapterTinhThanh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityListViewBasic1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
        addEvents();
    }

    private void addEvents() {
        binding.lvTinhThanh.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=adapterTinhThanh.getItem(position);//position là vị trí đang chọn
                binding.txtTinhThanh.setText(position+"->"+data);
            }
            //Sai setOnItemClick
        });
    }


    private void loadData() {
        //Bước 1: tải dữ liệu lên 1 mảng
        String []arr=getResources().getStringArray(R.array.arrTinhThanh);
        //Bước 2: Khởi tạo Adapter phù hợp với dữ liệu:
        adapterTinhThanh=new ArrayAdapter<>(
                ListViewBasic1Activity.this,//màn hình hiện tại
                android.R.layout.simple_list_item_1,//layout cơ bản có sẳn của adr
                arr//nguồn dữ liệu đẩy vào adapter
        );
        //Bước 3: gán adapter cho listview
        binding.lvTinhThanh.setAdapter(adapterTinhThanh);
    }
}
