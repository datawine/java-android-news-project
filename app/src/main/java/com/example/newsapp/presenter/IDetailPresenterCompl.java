package com.example.newsapp.presenter;



import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.newsapp.MyApplication;
import com.example.newsapp.R;
import com.example.newsapp.view.detailinfo.DetailInfoActivity;
import com.example.newsapp.view.detailinfo.DetailInfoActivity;
import com.example.newsapp.view.detailinfo.IDetailView;
import com.example.newsapp.view.settings.ChangeTagActivity;
import com.example.newsapp.view.settings.MySettingsActivity;


import org.json.JSONException;

import java.util.List;
import java.util.Map;

/**
 * Created by jzp1025 on 17/9/11.
 */

public class IDetailPresenterCompl implements IDetailPresenter {

    private IDetailView iDetailView;
    private MyApplication app;

    public IDetailPresenterCompl(IDetailView iDetailView)
    {
        this.iDetailView = iDetailView;


    }

    public void CheckItemId(MenuItem item, DetailInfoActivity ac)
    {

        int id = item.getItemId();

        if (id == R.id.nav_collection) {
            iDetailView.GetToast(id);
        } else if (id == R.id.nav_settings) {
            Intent intent = new Intent(ac, MySettingsActivity.class);
            iDetailView.GetActivityStart(intent);
        } else if (id == R.id.nav_share) {
            iDetailView.GetToast(id);
        } else if (id == R.id.nav_send) {
            iDetailView.GetToast(id);
        } else if (id == R.id.nav_homepage) {
            iDetailView.GetFinished();
        }

    }

    public void GetTitle(String ID) throws InterruptedException,JSONException
    {
        app = MyApplication.getInstance();

        Map<String, Object> news = app.GetNews(ID);

        //从数据库获取title



        iDetailView.SetTitle((String)news.get("news_Title"));
    }

    public void GetContent(String ID) throws InterruptedException,JSONException
    {
        app = MyApplication.getInstance();

        Map<String, Object> news = app.GetNews(ID);
        //从数据库获取content

        iDetailView.SetContent(news.get("news_Content").toString());
    }

    public void GetKeyWords(String ID) throws JSONException, InterruptedException {
        app = MyApplication.getInstance();

        List<Map<String,Object>> keys = (List<Map<String, Object>>)app.GetKeyWords(ID);

        for(int i=0;i<keys.size();i++)
        {
            Map<String,Object> key = keys.get(i);

            key.keySet();
        }
    }
}
