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
		// TODO �����������ꂽ���\�b�h�E�X�^�u

		db.execSQL("create table hosuu(" + "hosuuday TEXT," + "hosuu INTEGER);");
		db.execSQL("create table calsiyou(" + "bangou INTEGER," + "siyoucal INTEGER," + "siyouDay TEXT);");
		db.execSQL("create table toukei(" + "toukeihiduke TEXT," + "syouhical INTEGER," + "siyoucal INTEGER);");
	
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}
	
	//db.execSQL("create table hosuu(" + "hosuuday TEXT," + "hosuu INTEGER);");
	public void inserthosuu(String inhosuuday, Integer inhosuu){
		
		try{
			//�g�����U�N�V�����J�n
			sdb.beginTransaction();
			
			//�}��������e��ݒ�
			ContentValues cv = new ContentValues();
			cv.put("hosuuday", inhosuuday);
			cv.put("hosuu", inhosuu);
			
			//�e�[�u���ɑ}��
			sdb.insert("hosuu", "", cv);
			
			//�g�����U�N�V��������
			sdb.setTransactionSuccessful();
			
		}finally{
			//�g�����U�N�V�����I��
			sdb.endTransaction();
		}
		
	}
	
	//db.execSQL("create table calsiyou(" + "bangou INTEGER," + "siyoucal INTEGER," + "siyouDay TEXT);");
	public void insercalsiyou(Integer inbangou, Integer insiyoucal , String insiyouday){
		
		try{
			//�g�����U�N�V�����J�n
			sdb.beginTransaction();
			
			//�}��������e��ݒ�
			ContentValues cv = new ContentValues();
			cv.put("bangou", inbangou);
			cv.put("siyoucal", insiyoucal);
			cv.put("siyouDay", insiyouday);

			
			//�e�[�u���ɑ}��
			sdb.insert("hosuu", "", cv);
			
			//�g�����U�N�V��������
			sdb.setTransactionSuccessful();
			
		}finally{
			//�g�����U�N�V�����I��
			sdb.endTransaction();
		}
	}
		//db.execSQL("create table toukei(" + "toukeihiduke TEXT," + "syouhical INTEGER," + "siyoucal INTEGER);");
		public void inserttoukei(String intoukeiday, Integer syouhi, Integer siyou){
			
			try{
				//�g�����U�N�V�����J�n
				sdb.beginTransaction();
				
				//�}��������e��ݒ�
				ContentValues cv = new ContentValues();
				cv.put("toukeihiduke", intoukeiday);
				cv.put("syouhical", syouhi);
				cv.put("siyoucal", siyou);
				
				//�e�[�u���ɑ}��
				sdb.insert("toukei", "", cv);
				
				//�g�����U�N�V��������
				sdb.setTransactionSuccessful();
				
			}finally{
				//�g�����U�N�V�����I��
				sdb.endTransaction();
			}
		}
			
			
	//�S���擾
	

	public Cursor getAlltoukei() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		Cursor cursor = null;
		
		//SQL��ݒ�
		StringBuilder sql = new StringBuilder();  
		sql.append(" SELECT * FROM toukei;");  
			        
		//SQL�����s����       
		try{  
			cursor = sdb.rawQuery(sql.toString(), null);   
		}
		catch(Exception ex){
			Log.v("DBTEST", "InsertError:" + ex.getMessage());
		}
		
		return cursor;
	}

	
	
	}


