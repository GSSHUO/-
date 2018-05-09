package umengwx.jiyun.com.mvp.di.diimpl;

import umengwx.jiyun.com.mvp.di.IModel;
import umengwx.jiyun.com.mvp.di.IPresenter;
import umengwx.jiyun.com.mvp.di.IView;

public class PresenterImpl implements IPresenter {
    private IView iView;
    private final IModel model;

    public PresenterImpl(IView iView) {
        this.iView=iView;
        model = new ModelImpl();
    }

    @Override
    public void login(String name, String psws) {
        model.requestData(name, psws, new IModel.OnShowDataChangeListener() {
            @Override
            public void showData(String requestString) {
                iView.updataUI(requestString);
            }
        });
    }
}
