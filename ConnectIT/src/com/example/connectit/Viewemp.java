package com.example.connectit;

//import com.example.regisration.model;
//import com.example.regisration.view;

//import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Viewemp extends Activity{
	EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13;
	Button b1,b2,b3;
	Database db=new Database(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.empsingle);
		e1=(EditText)findViewById(R.id.namee);
		e2=(EditText)findViewById(R.id.agee);
		e3=(EditText)findViewById(R.id.addresse);
		e4=(EditText)findViewById(R.id.dobe);
		e5=(EditText)findViewById(R.id.phone);
		e6=(EditText)findViewById(R.id.malie);
		e7=(EditText)findViewById(R.id.desige);
		e8=(EditText)findViewById(R.id.jode);
		e9=(EditText)findViewById(R.id.salarye);
		e10=(EditText)findViewById(R.id.expe);
		e11=(EditText)findViewById(R.id.qlfe);
		e12=(EditText)findViewById(R.id.departe);
		e13=(EditText)findViewById(R.id.gendere);
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		b3=(Button)findViewById(R.id.button3);
		registerForContextMenu(b1);
		final String pid=getIntent().getStringExtra("idd");
		addempmodel em=db.getContact(Integer.parseInt(pid));
		e1.setText(em.getName());
		e2.setText(em.getAge());
		e3.setText(em.getAddr());
		e4.setText(em.getDob());
		e5.setText(em.getPhone());
		e6.setText(em.getMail());
		e7.setText(em.getDsig());
		e8.setText(em.getJoindate());
		e9.setText(em.getSalarry());
		e10.setText(em.getExper());
		e11.setText(em.getQlif());
		e12.setText(em.getDepart());
		e13.setText(em.getGender());
		b3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
			
			String string1=e1.getText().toString();
			String string2=e2.getText().toString();
			String string3=e3.getText().toString();
			String string4=e4.getText().toString();
			String string5=e5.getText().toString();
			String string6=e6.getText().toString();
			String string7=e7.getText().toString();
			String string8=e8.getText().toString();
			String string9=e9.getText().toString();
			String string10=e10.getText().toString();
			String string11=e11.getText().toString();
			String string12=e12.getText().toString();
			String string13=e13.getText().toString();
			
			int x=db.updateregister(new addempmodel(Integer.parseInt(pid),string1, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13));
			Toast.makeText(getApplicationContext(), "successfully updated", 1000).show();
			Intent in=new Intent(getApplicationContext(),Viewlist.class);
			startActivity(in);
			}
		});
b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				addempmodel em=db.getContact(Integer.parseInt(pid));
				db.Deletecontact(em);
				Toast.makeText(getApplicationContext(), "successfully deleted",1000).show();
				Intent in=new Intent(getApplicationContext(),Viewlist.class);
				startActivity(in);
			}
		});

	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		menu.add(0,1,0,"CALL");
		menu.add(0,2,0,"EMAIL");
		super.onCreateContextMenu(menu, v, menuInfo);
	}
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case 1:String s1=((EditText)findViewById(R.id.phone)).getText().toString();
		       if(s1.length()>10||s1.length()<10)
		       {
		    	   Toast.makeText(getApplicationContext(), "Check Number",1000).show();
		    	   break;
		       }
		       else
		       {
		    	   Intent in=new Intent(Intent.ACTION_CALL);
		    	   in.setData(Uri.parse("tel:"+s1));
		    	   startActivity(in);
		    	   break;
		       }
			
		case 2:String s2=((EditText)findViewById(R.id.malie)).getText().toString();
		   String subject="KKC";
		   String message="your reg no is "+1;
		   Intent i=new Intent(Intent.ACTION_SENDTO,Uri.fromParts("mailto", s2,null));
		   i.putExtra(Intent.EXTRA_SUBJECT,subject);
		   i.putExtra(Intent.EXTRA_TEXT, message);
		   startActivity(Intent.createChooser(i,"choose an email client"));
		   
			break;
		}
		return super.onContextItemSelected(item);
	}
	}
	
	
	

