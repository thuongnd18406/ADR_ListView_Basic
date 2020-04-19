package dangthuongngo.com.hoclistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import dangthuongngo.com.hoclistview.databinding.ActivityListViewBasic2Binding;
import dangthuongngo.com.model.DanhBa;

public class ListViewBasic2Activity extends AppCompatActivity {
    //vì nguồn dữ liệu là DanhBa thì adapter là DanhBa
    ArrayAdapter<DanhBa>adapterDanhBa;
    ActivityListViewBasic2Binding binding;
    DanhBa selectedDanhBa=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityListViewBasic2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addControl();
        addEvent();
    }

    private void addEvent() {
        binding.btnLuuMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLiThemMoi();
            }
        });
        binding.lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DanhBa db=adapterDanhBa.getItem(position);
                binding.edtTen.setText(db.getTen());
                binding.edtPhone.setText(db.getPhone());
                selectedDanhBa=db;
            }
        });
        binding.btnChinhSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chinhSua();
            }
        });
        binding.btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedDanhBa!=null)
                {
                    adapterDanhBa.remove(selectedDanhBa);
                    selectedDanhBa=null;
                }
            }
        });
    }

    private void chinhSua() {
        if(selectedDanhBa!=null)
        {
            selectedDanhBa.setTen(binding.edtTen.getText().toString());
            selectedDanhBa.setPhone(binding.edtPhone.getText().toString());
            adapterDanhBa.notifyDataSetChanged();
        }
    }

    private void xuLiThemMoi() {
        //Khởi tạo 1 danh bạ
        DanhBa db=new DanhBa(binding.edtTen.getText().toString(),binding.edtPhone.getText().toString());
        //đưa danh bạ vào Adapter:
        adapterDanhBa.add(db);
        binding.edtTen.setText("");
        binding.edtPhone.setText("");
        binding.edtTen.requestFocus();
    }

    private void addControl() {
        //khởi tạo Adapter
        adapterDanhBa=new ArrayAdapter<>(
                ListViewBasic2Activity.this,
                android.R.layout.simple_list_item_1
        );
        //gán adapter cho listview:
        binding.lvContact.setAdapter(adapterDanhBa);
    }
}
