package com.example.bkt3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvThi;
    ArrayList<Thi> thiList;
    ThiAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        thiList = new ArrayList<>();

        thiList.add(new Thi("Thì hiện tại đơn - Present Simple Tense", "Thì hiện tại đơn (present simple) là thì được dùng để diễn tả những hành động, đặc điểm và thói quen đang diễn ra trong hiện tại."));
        thiList.add(new Thi("Thì hiện tại tiếp diễn - Present Continuous Tense", "Thì hiện tại tiếp diễn (Present continuous tense) được dùng để diễn tả hành động đang xảy ra tại thời điểm nói."));
        thiList.add(new Thi("Thì hiện tại hoàn thành - Present Perfect Tense", "Thì hiện tại hoàn thành (Present perfect tense) diễn tả những hành động kết thúc trong quá khứ, tương ứng với thì Quá khứ đơn trong tiếng Anh."));
        thiList.add(new Thi("Thì hiện tại hoàn thành tiếp diễn - Present Perfect Continuous Tense", "Thì hiện tại hoàn thành tiếp diễn (Present perfect continuous) được sử dụng để diễn tả các hành động đã xảy ra trong quá khứ, và nhấn mạnh vào sự kéo dài không bị ngắt quãng của chúng đến hiện tại. Ở hiện tại, các hành động này có thể vẫn đang tiếp tục diễn ra hoặc đã ngừng lại."));
        thiList.add(new Thi("Thì quá khứ đơn - Past Simple Tense", "Thì quá khứ đơn (past simple) là thì được dùng để diễn tả một sự việc đã xảy ra và kết thúc ở một thời điểm xác định trong quá khứ."));
        thiList.add(new Thi("Thì hiện tại đơn - Present Simple Tense", "Thì hiện tại đơn (present simple) là thì được dùng để diễn tả những hành động, đặc điểm và thói quen đang diễn ra trong hiện tại."));
        thiList.add(new Thi("Thì quá khứ tiếp diễn - Past Continuous Tense", "Thì quá khứ tiếp diễn (Past continuous) diễn tả một hành động đang xảy ra trong quá khứ."));
        thiList.add(new Thi("Thì quá khứ hoàn thành - Past Perfect Tense", "Thì quá khứ hoàn thành (Past perfect) diễn tả một hành động, sự việc xảy ra trước một mốc thời gian hoặc sự kiện cụ thể trong quá khứ, động từ sẽ được chia theo thì quá khứ hoàn thành."));


        adapter = new ThiAdapter(this, thiList);
        lvThi.setAdapter(adapter);

        lvThi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                Thi thi = thiList.get(position);

                Bundle bundle = new Bundle();

                bundle.putString("tenThi", thi.getTenThi());

                intent.putExtra("data", bundle);
                startActivity(intent);
            }
        });
    }

    private void AnhXa(){
        lvThi = findViewById(R.id.listViewThi);
    }

}