package com.example.bkt3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    TextView txtTenThi;
    EditText edtViDu;
    ListView lvViDu;
    private static final ArrayList<ViDu> viDuArrayList = new ArrayList<>();
    Button btnLuu, btnQuayLai;
    ViDuAdapter adapter = new ViDuAdapter(this, viDuArrayList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        AnhXa();

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        if(bundle == null)
            return;

        txtTenThi.setText(bundle.getString("tenThi"));

        lvViDu.setAdapter(adapter);

        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtViDu.getText().toString().equals(""))
                    Toast.makeText(DetailActivity.this, "Vui lòng nhập 1 câu ví dụ", Toast.LENGTH_SHORT).show();
                else
                {
                    viDuArrayList.add(new ViDu(txtTenThi.getText().toString(),edtViDu.getText().toString()));
                    adapter.notifyDataSetChanged();
                }
            }
        });

        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }

    private void AnhXa(){
        txtTenThi = findViewById(R.id.textViewTenThi_Detail);
        btnLuu = findViewById(R.id.buttonLuu);
        edtViDu = findViewById(R.id.editTextViDu);
        lvViDu = findViewById(R.id.listViewViDu);
        btnQuayLai = findViewById(R.id.buttonQuayLai);
    }
}