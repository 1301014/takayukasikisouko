package com.example.takayukasikisouko;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBManager extends SQLiteOpenHelper {
	
	SQLiteDatabase sdb = null;
	
	public DBManager(Context context){
		super(context,"manpokeidb.db",null,1);
		sdb = getReadableDatabase();
		

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO 自動生成されたメソッド・スタブ

		db.execSQL("create table hosuu(" + "hosuuday TEXT," + "hosuu INTEGER);");
		db.execSQL("create table calsiyou(" + "bangou INTEGER," + "siyoucal INTEGER," + "siyouDay TEXT);");
		db.execSQL("create table toukei(" + "toukeihiduke TEXT," + "syouhical INTEGER," + "siyoucal INTEGER);");
	
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO 自動生成されたメソッド・スタブ

	}
	
	//db.execSQL("create table hosuu(" + "hosuuday TEXT," + "hosuu INTEGER);");
	public void inserthosuu(String inhosuuday, Integer inhosuu){
		
		try{
			//トランザクション開始
			sdb.beginTransaction();
			
			//挿入する内容を設定
			ContentValues cv = new ContentValues();
			cv.put("hosuuday", inhosuuday);
			cv.put("hosuu", inhosuu);
			
			//テーブルに挿入
			sdb.insert("hosuu", "", cv);
			
			//トランザクション成功
			sdb.setTransactionSuccessful();
			
		}finally{
			//トランザクション終了
			sdb.endTransaction();
		}
		
	}
	
	//db.execSQL("create table calsiyou(" + "bangou INTEGER," + "siyoucal INTEGER," + "siyouDay TEXT);");
	public void insercalsiyou(Integer inbangou, Integer insiyoucal , String insiyouday){
		
		try{
			//トランザクション開始
			sdb.beginTransaction();
			
			//挿入する内容を設定
			ContentValues cv = new ContentValues();
			cv.put("bangou", inbangou);
			cv.put("siyoucal", insiyoucal);
			cv.put("siyouDay", insiyouday);

			
			//テーブルに挿入
			sdb.insert("hosuu", "", cv);
			
			//トランザクション成功
			sdb.setTransactionSuccessful();
			
		}finally{
			//トランザクション終了
			sdb.endTransaction();
		}
	}
		//db.execSQL("create table toukei(" + "toukeihiduke TEXT," + "syouhical INTEGER," + "siyoucal INTEGER);");
		public void inserttoukei(String intoukeiday, Integer syouhi, Integer siyou){
			
			try{
				//トランザクション開始
				sdb.beginTransaction();
				
				//挿入する内容を設定
				ContentValues cv = new ContentValues();
				cv.put("toukeihiduke", intoukeiday);
				cv.put("syouhical", syouhi);
				cv.put("siyoucal", siyou);
				
				//テーブルに挿入
				sdb.insert("toukei", "", cv);
				
				//トランザクション成功
				sdb.setTransactionSuccessful();
				
			}finally{
				//トランザクション終了
				sdb.endTransaction();
			}
		}
			
			
	//全件取得
	

	public Cursor getAlltoukei() {
		// TODO 自動生成されたメソッド・スタブ
		Cursor cursor = null;
		
		//SQLを設定
		StringBuilder sql = new StringBuilder();  
		sql.append(" SELECT * FROM toukei;");  
			        
		//SQLを実行する       
		try{  
			cursor = sdb.rawQuery(sql.toString(), null);   
		}
		catch(Exception ex){
			Log.v("DBTEST", "InsertError:" + ex.getMessage());
		}
		
		return cursor;
	}

	
	
	}


