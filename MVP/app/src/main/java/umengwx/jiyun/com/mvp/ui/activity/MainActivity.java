package umengwx.jiyun.com.mvp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import umengwx.jiyun.com.mvp.R;
import umengwx.jiyun.com.mvp.di.IPresenter;
import umengwx.jiyun.com.mvp.di.IView;
import umengwx.jiyun.com.mvp.di.diimpl.PresenterImpl;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,IView {

    private EditText userName;
    private EditText psw;
    private Button login;
    private IPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        presenter = new PresenterImpl(this);
    }

    private void initView() {
        userName = (EditText) findViewById(R.id.userName);
        psw = (EditText) findViewById(R.id.psw);
        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                String name = userName.getText().toString();
                String psws = psw.getText().toString();
                presenter.login(name,psws);
                break;
        }
    }



    @Override
    public void updataUI(final String requestString) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,requestString,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
