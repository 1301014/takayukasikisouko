package com.example.takayukasikisouko;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener{
	
	//DBを使うための道具入れ
	DBManager db = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//DBを使うための道具を生成する
		db = new DBManager(this);
		
		Button btn = (Button)findViewById(R.id.button1);
		btn.setOnClickListener(this);
		
		Button btn2 = (Button)findViewById(R.id.button2);
		btn2.setOnClickListener(this);
	}
	
	private void refreshList(){
		
		//DBを検索する
		Cursor c = db.getAlltoukei();
		
		ArrayAdapter<String> adapter = 
			new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		// アイテムを追加します
		while (c.moveToNext()){ 
			
			/* String koumoku = space(c.getString(0),15);
			String kingaku = space(c.getString(1),10);
			String day = space(c.getString(2),22);
			
			String kekka = koumoku + kingaku + day;
			adapter.add(kekka); */
			
			String kekka = c.getString(0) + "　" + c.getString(1) + "　" +  c.getString(2) ;
			adapter.add(kekka);
		}
		
		ListView listView = (ListView)findViewById(R.id.listView1);
		// アダプターを設定します
		listView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
		
	}
	public void insert(String a , int b , int c){
		
		db.inserttoukei(a,b,c);
		
	}
	
	

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		
		switch(v.getId()){
		
		case R.id.button1:
		
		EditText et1 = (EditText)findViewById(R.id.hosuu);
		EditText et2 = (EditText)findViewById(R.id.syouhi);
		String syouhi = et2.getText().toString();
		int syouhi2 = Integer.valueOf(syouhi);
		EditText et3 = (EditText)findViewById(R.id.siyou);
		String siyou = et3.getText().toString();
		int siyou2 = Integer.valueOf(siyou);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf =
				new SimpleDateFormat("yyyy年MM月dd日");
		String strDate = sdf.format(cal.getTime());
		
		insert(strDate, syouhi2 , siyou2);
		break;
		
		case R.id.button2:
			
			refreshList();
				
				
					
					
				
		}
		
	}
}
