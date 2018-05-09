package umengwx.jiyun.com.mvp.di;

public interface IModel {
    void requestData(String name, String psws,OnShowDataChangeListener onShowDataChangeListener);


    interface OnShowDataChangeListener{
        void showData(String requestString);
    }
}
