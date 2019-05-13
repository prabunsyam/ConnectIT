package com.example.connectit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
//import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Viewlist extends Activity {
	Spinner s1;
	ListView v1;
	Database db= new Database(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewlist);
		s1=(Spinner)findViewById(R.id.spinner1);
		v1=(ListView)findViewById(R.id.listView1);
		loadspinnerdata();
		
		v1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				String q=((TextView)arg1.findViewById(R.id.textView1)).getText().toString();
				Toast.makeText(getApplicationContext(), "id"+q,1000).show();
				Intent in=new Intent(getApplicationContext(),Viewemp.class);
				in.putExtra("idd",q);
				startActivity(in);
				
			}
			
		});
		s1.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				String a=s1.getSelectedItem().toString();
				ArrayList<HashMap<String, String>>singlelist=new ArrayList<HashMap<String,String>>();
				List<addempmodel>em=db.getallemployee(a);
				for(addempmodel m:em)
				{
					HashMap<String,String>data1=new HashMap<String,String>();
					
					data1.put("id",String.valueOf(m.getId()));
					data1.put("name", String.valueOf(m.getName()));
					singlelist.add(data1);
				}
				ListAdapter adapter=new SimpleAdapter(Viewlist.this,singlelist,R.layout.txtlist, new String[]{"id","name"},new int[]{R.id.textView1,R.id.textView2});
				v1.setAdapter(adapter);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}
	private void loadspinnerdata() {
		// TODO Auto-generated method stub
		Database db=new Database(this);
		List<String>labels=db.getdept();
		ArrayAdapter<String>datadapter=new ArrayAdapter<String>(this,R.layout.newlay,labels);
		s1.setAdapter(datadapter);
	}

}
