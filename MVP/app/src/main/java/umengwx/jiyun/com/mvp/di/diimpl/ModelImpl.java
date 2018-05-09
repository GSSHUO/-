package umengwx.jiyun.com.mvp.di.diimpl;

import android.widget.Toast;

import umengwx.jiyun.com.mvp.di.IModel;
import umengwx.jiyun.com.mvp.ui.activity.MainActivity;

public class ModelImpl implements IModel {

    @Override
    public void requestData(final String name, final String psws, final OnShowDataChangeListener onShowDataChangeListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    if(name.equals("abc")&&psws.equals("123")){
                        onShowDataChangeListener.showData("登陆成功！");
                    }else {
                        onShowDataChangeListener.showData("登录失败！");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
