package com.example.myapplication;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.content.Intent;

public class login extends AppCompatActivity{

    private Button login;
    @Override
    protected void onCreate(Bundle sacedInstanceState){
        super.onCreate(sacedInstanceState);
        setContentView(R.layout.Login);
        login = (Button)findViewByID(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(login.this, Information.class);
                startActivity(intend);
            }
        })
    }

}

public UpdateInfo getUpdateInfo(final) throws Exception{
    FutureTask<UpdateInfo> task = new FutureTask<UpdateInfo>(

            new Callable<UpdateInfo>() {

                public UpdateInfo call() throws Exception {

                    String path = context.getResources().getString(urlId);
                    HttpClient client = new DefaultHttpClient();
                    HttpGet httpGet = new HttpGet(path);
                    StringBuilder sb = new StringBuilder();
                    HttpResponse response = client.execute(httpGet);
                    HttpEntity entity = response.getEntity();
                    InputStreamReader br = new InputStreamReader(entity

                            .getContent(), "utf-8");

                    int b;

                    while ((b = br.read()) != -1) {

                        sb.append((char) b);

                    }

                    JSONObject jsonObj = new JSONObject(sb.toString());
                    UpdateInfo info = new UpdateInfo();
                    info.setVersion(jsonObj.getString("version"));
                    info.setDescription(jsonObj.getString("description"));
                    info.setUrl(jsonObj.getString("apkurl"));

                    return info;
                }
            });

    new Thread(task).start();

    try {
        return task.get();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
