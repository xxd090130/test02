package com.itheima.menu;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}
	
	public void send(View v){
		
		NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		
		Intent in = new Intent();
		in.setAction(Intent.ACTION_CALL);
		in.setData(Uri.parse("tel:" + 110));
		
		//requestCode：请求码  flags：在通知中打开一个activity需要栈
		PendingIntent intent = PendingIntent.getActivity(this, 1, in, Intent.FLAG_ACTIVITY_NEW_TASK);
		
		Notification noti = new Notification.Builder(this)
        .setContentTitle("警方提示")
        .setContentText("小芳，放学后操场见！")
        .setSmallIcon(R.drawable.ic_launcher)
        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher))
        .setContentIntent(intent)//当通知被点击的时候发送一个延迟意图
        .build();

		
		nm.notify(1, noti);
	}

	// 创建菜单
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// 点击菜单
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch (id) {
		case R.id.action_settings:
			Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show();
			break;
		case R.id.action_exit:
			Toast.makeText(this, "退出", Toast.LENGTH_SHORT).show();

			break;
		case R.id.action_zhuxiao:
			Toast.makeText(this, "注销", Toast.LENGTH_SHORT).show();

			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
