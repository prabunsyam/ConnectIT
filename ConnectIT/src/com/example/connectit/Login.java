package com.example.connectit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
EditText e1,e2;
Button b1,b2;
Database db= new Database(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		e1=(EditText)findViewById(R.id.namez);
		e2=(EditText)findViewById(R.id.pass);
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String s1=e1.getText().toString();
				String s2=e2.getText().toString();
				String password=db.getSingleEntry(s1);
				if(s1.length()==0)
				{
					e1.setError("Field can't be empty");
				}
				else if(s2.length()==0)
				{
					e2.setError("Field can't be empty");
				}
				else if(s2.equals(password))
				{
					
					Toast.makeText(getApplicationContext(), "Login Successfull", 1000).show();
					Intent i=new Intent(getApplicationContext(),Welcome.class);
					startActivity(i);
					
				}
			}
		});
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent is=new Intent(Login.this,Signup.class);
				startActivity(is);
				}
		});
		
	}
}
