package com.example.connectit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends Activity{
	EditText e1,e2,e3;
	Button b;
	Database db=new Database(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		e1=(EditText)findViewById(R.id.name);
		e2=(EditText)findViewById(R.id.cpasss);
		e3=(EditText)findViewById(R.id.pass);
		b=(Button)findViewById(R.id.sig);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String s1=e1.getText().toString();
				String s2=e2.getText().toString();
				String s3=e3.getText().toString();
				if(s1.length()==0)
				{
					e1.setError("Field can't be empty");
				}
				else if(s2.length()==0)
				{
					e2.setError("Field can't be empty");
				}
				else if(s3.equals(s2))
				{
				db.Insert(new signupmodel(s1,s2));
				Toast.makeText(getApplicationContext(), "Account Created",1000).show();
				Intent in=new Intent(getApplicationContext(),Login.class);
				startActivity(in);
				}
				else
				{
					e3.setError("password mismatch");
				}
			}
		});
	}
	

}
