package com.example.connectit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Adddept  extends Activity{
	EditText e1;
	Button b;
	Database db=new Database(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adddepartment);
		e1=(EditText)findViewById(R.id.employee);
		b=(Button)findViewById(R.id.add);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String s1=e1.getText().toString();
				if(s1.length()==0)
				{
					e1.setError("Field cant be empty");
					
				}
				else
				{
					db.InsertDept(new adddepmodel(s1));
					
					Toast.makeText(getApplicationContext(), "added",1000).show();
					Intent in=new Intent(getApplicationContext(),Welcome.class);
					startActivity(in);
					
				}
			}
		});
	}

}
