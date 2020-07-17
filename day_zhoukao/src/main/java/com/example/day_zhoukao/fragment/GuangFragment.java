package com.example.day_zhoukao.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.day_zhoukao.R;
import com.example.day_zhoukao.adapter.MyAdapter;
import com.example.day_zhoukao.base.BaseApp;
import com.example.day_zhoukao.base.BaseFragment;
import com.example.day_zhoukao.bean.DatasBean;
import com.example.day_zhoukao.bean.MyBean;
import com.example.day_zhoukao.db.DatasBeanDao;
import com.example.day_zhoukao.presenter.MyPresenter;
import com.example.day_zhoukao.view.MyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GuangFragment extends BaseFragment<MyPresenter> implements MyView {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    Unbinder unbinder;
    private List<DatasBean> list;
    private MyAdapter myAdapter;

//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        inflater.inflate(, null);
//        unbinder = ButterKnife.bind(this, super.onCreateView(inflater, container, savedInstanceState));
//        return super.onCreateView(inflater, container, savedInstanceState);
//    }

    @Override
    protected void initLinlist() {

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser&&recycler!=null&&myAdapter!=null){
            initData();
        }
    }

    @Override
    protected void initData() {
        mPresenter.setString();
    }

    @Override
    protected void initView() {
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));

        list = new ArrayList<>();
        myAdapter = new MyAdapter(getActivity(), list);
        recycler.setAdapter(myAdapter);
    }

    @Override
    protected void initPresenter() {
        mPresenter=new MyPresenter();
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_guang;
    }


    @Override
    public void showToast(String string) {
        Toast.makeText(getActivity(), string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void setData(List<DatasBean> data) {
        list.clear();

        for (int i = 0; i < data.size(); i++) {
            DatasBean datasBean = data.get(i);
            List<DatasBean> beans = BaseApp.getInstance().getDaoSession().getDatasBeanDao().queryBuilder()
                    .where(DatasBeanDao.Properties.Title.eq(datasBean.getTitle())).list();
            if (beans.size()>0){
                datasBean.setIsChecked(true);
            }
        }
        list.addAll(data);
        myAdapter.notifyDataSetChanged();
    }
}
