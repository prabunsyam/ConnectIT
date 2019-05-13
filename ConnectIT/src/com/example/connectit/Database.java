package com.example.connectit;

//import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
	
	private static final int DATABASE_VERSION=1;
	private static final String DATABASE_NAME="project";
	

	public Database(Context context) {
		super(context,DATABASE_NAME,null,DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		String a="create table signup(id integer primary key,name text,pass text)";
	    arg0.execSQL(a);
	    String b="create table department(id integer primary key,dep text)";
		arg0.execSQL(b);
		//String c="create table employee(id integer primary key,name text,age text,add text,dob text,phone text,mail text,dsig text,joindate text,salarry text,exper text,qlif text,depart text,gender text)";
		String c="create table employee(id integer primary key,name text,age text,addr text,dob text,phone text,mail text,dsig text,joindate text,salarry text,exper text,qlif text,depart text,gender text)";
		arg0.execSQL(c);
	}
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		arg0.execSQL("Drop table if exist" + "signup");
		onCreate(arg0);
		arg0.execSQL("Drop table if exist" + "department");
		onCreate(arg0);
		arg0.execSQL("Drop table if exist" + "employee");
		onCreate(arg0);
	}
	public void Insert(signupmodel signupmodel) {
		// TODO Auto-generated method stub
		SQLiteDatabase db=this.getReadableDatabase();
		ContentValues values=new ContentValues();
		values.put("name",signupmodel.getName());
		values.put("pass",signupmodel.getPass());
		db.insert("signup", null, values);
		db.close();
		
	}
	public String getSingleEntry(String s1) {
		// TODO Auto-generated method stub
		SQLiteDatabase db=this.getReadableDatabase();
		String q=" select pass from " + " signup " +" where name='"+ s1 +"'";
	    Cursor cursor=db.rawQuery(q, null);
	    if(cursor.getCount()<1)
	    {
	    	cursor.close();
	    	return("not exist");
	    }
	    cursor.moveToFirst();
	    String password=cursor.getString(cursor.getColumnIndex("pass"));
	    cursor.close();
	    return password;
	}
	public void InsertDept(adddepmodel adddepmodel) {
		// TODO Auto-generated method stub
		SQLiteDatabase db=this.getReadableDatabase();
		ContentValues values=new ContentValues();
		values.put("dep",adddepmodel.getName());
		db.insert("department", null, values);
		db.close();
		
	}
	public void EmpregInsert(addempmodel addempmodel) {
		// TODO Auto-generated method stub
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues values=new ContentValues();
		
		values.put("name",addempmodel.getName());
		values.put("age", addempmodel.getAge());
		values.put("addr", addempmodel.getAddr());
		values.put("dob", addempmodel.getDob());
		
		
		
		
		values.put("phone", addempmodel.getPhone());
		values.put("mail", addempmodel.getMail());
		values.put("dsig", addempmodel.getDsig());
		
		values.put("joindate", addempmodel.getJoindate());
		values.put("salarry", addempmodel.getSalarry());
		values.put("exper", addempmodel.getExper());
		values.put("qlif", addempmodel.getQlif());
		values.put("depart", addempmodel.getDepart());
		values.put("gender", addempmodel.getGender());
		db.insert("employee", null, values);
		db.close();
	}
	public List<String> getdept() {
		// TODO Auto-generated method stub
		List<String>depList=new ArrayList<String>();
		String selectQuery="select * from " + "department";
		SQLiteDatabase db=this.getReadableDatabase();
		Cursor cursor=db.rawQuery(selectQuery, null);
		if(cursor.moveToFirst())
		{
			do
			{
				String dept=new String();
				dept=cursor.getString(1);
				depList.add(dept);
			}
			while(cursor.moveToNext());
		}
		return depList;
	}
	public List<addempmodel> getallemployee(String a) {
		// TODO Auto-generated method stub
		List<addempmodel>emplist=new ArrayList<addempmodel>();
		//String s="Select * from employee where depart= ' " + a + " ' ";
		String s="select * from employee where depart= '"+ a +"' ";
		SQLiteDatabase db=this.getReadableDatabase();
		Cursor cursor=db.rawQuery(s, null);
		if(cursor.moveToFirst())
		{
			do
			{
				addempmodel em=new addempmodel();
				em.setId(Integer.parseInt(cursor.getString(0)));
				em.setName(cursor.getString(1));
				emplist.add(em);
			}
			while(cursor.moveToNext());
		}
		return emplist;
	}
	public addempmodel getContact(int i) {
		// TODO Auto-generated method stub
		SQLiteDatabase db=this.getReadableDatabase();
		Cursor cursor=db.query("employee", new String[]{"id","name","age","addr","dob" ,"phone" ,"mail ","dsig" ,"joindate" ,"salarry" ,"exper" ,"qlif ","depart" ,"gender"},"id"+"=?", new String[]{String.valueOf(i)},null, null, null, null);
		if(cursor!=null)
		
		cursor.moveToFirst();
		addempmodel em=new addempmodel(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(10),cursor.getString(11),cursor.getString(12),cursor.getString(13));
		cursor.close();
		db.close();
		//return em;
		
		return em;
				
				
	}
	public int updateregister(addempmodel addempmodel) {
		// TODO Auto-generated method stub
	SQLiteDatabase db=this.getWritableDatabase();
	ContentValues values=new ContentValues();
	values.put("id",addempmodel.getId());
	values.put("name",addempmodel.getName());
	values.put("age", addempmodel.getAge());
	values.put("addr", addempmodel.getAddr());
	values.put("dob", addempmodel.getDob());
	
	
	
	
	values.put("phone", addempmodel.getPhone());
	values.put("mail", addempmodel.getMail());
	values.put("dsig", addempmodel.getDsig());
	
	values.put("joindate", addempmodel.getJoindate());
	values.put("salarry", addempmodel.getSalarry());
	values.put("exper", addempmodel.getExper());
	values.put("qlif", addempmodel.getQlif());
	values.put("depart", addempmodel.getDepart());
	values.put("gender", addempmodel.getGender());
	return db.update("employee", values, "id" +"=?", new String[]{String.valueOf(addempmodel.getId())});
	
	}
	public void Deletecontact(addempmodel em) {
		// TODO Auto-generated method stub
		SQLiteDatabase db=this.getWritableDatabase();
		db.delete("employee", "id"+"=?", new String[]{String.valueOf(em.getId())});
	}
	

}
