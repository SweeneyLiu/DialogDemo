package com.lsw.dialogdemo;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                new ErrorDialog(MainActivity.this,R.style.Dialog).show();

/*                CustomDialog.Builder builder = new CustomDialog.Builder(MainActivity.this);
                mDialog = builder.cancelTouchout(false)
                                .view(R.layout.dialog_loginerror)
                                .heightdp(250)
                                .widthdp(200)
                                .style(R.style.Dialog)
                                .addViewOnclick(R.id.btn_cancel,new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        mDialog.dismiss();
                                    }
                                })
                                .build();
                mDialog.show();*/

                final View.OnClickListener listener = new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switch (view.getId()){
                            case R.id.btn_login :
                                Toast.makeText(MainActivity.this, "选择确定按钮", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.btn_cancel:
                                Toast.makeText(MainActivity.this, "选择取消按钮", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                };

                CustomDialog.Builder builder = new CustomDialog.Builder(MainActivity.this);
                mDialog = builder.cancelTouchout(false)
                        .view(R.layout.dialog_login)
                        .heightdp(300)
                        .widthdp(200)
                        .style(R.style.Dialog)
                        .addViewOnclick(R.id.btn_login,listener)
                        .addViewOnclick(R.id.btn_cancel,listener)
                        .build();
                mDialog.show();

            }
        });
    }

    private void initView() {
        button = (Button) findViewById(R.id.button);
    }
}
