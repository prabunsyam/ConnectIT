package com.example.connectit;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;

public class Addemp extends Activity implements OnClickListener{
	public DatePickerDialog fromDatePickerDialog;
	public DatePickerDialog todaDatePickerDialog;
	public SimpleDateFormat dateFormat;
	EditText name,age,abc,dob,phone,mail,dsig,jod,salarry,exp;
	Spinner quali,dep;
	RadioGroup gen;
	RadioButton r1,r2;
	String s13="MALE";
	Button b;;
	Database db= new Database(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addem);
		b=(Button)findViewById(R.id.update);
		name=(EditText)findViewById(R.id.name);
		age=(EditText)findViewById(R.id.AGE);
		abc=(EditText)findViewById(R.id.addr);
		dob=(EditText)findViewById(R.id.namee);
		phone=(EditText)findViewById(R.id.salarye);
		mail=(EditText)findViewById(R.id.mail);
		dsig=(EditText)findViewById(R.id.DESIG);
		jod=(EditText)findViewById(R.id.JOINDATE);
		salarry=(EditText)findViewById(R.id.SALARY);
		exp=(EditText)findViewById(R.id.EXP);
		quali=(Spinner)findViewById(R.id.QLF);
		dep=(Spinner)findViewById(R.id.DEPARTMENT);
		gen=(RadioGroup)findViewById(R.id.radioGroup1);
		r1=(RadioButton)findViewById(R.id.radio0);
		r2=(RadioButton)findViewById(R.id.radio1);
		dateFormat=new SimpleDateFormat("dd-MM-yyyy",Locale.US);
		findViewById();
		setdatetimefield();
		loadspinnerdata();
		String  arr[]=new String[]{"SSLC","PLUS TWO","BTECH","MTECH"};
		ArrayAdapter<String>adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.aaa,arr);
		quali.setAdapter(adapter);
		gen.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				if(arg1==R.id.radio0)
				{
					s13=r1.getText().toString();
				}
				else if(arg1==R.id.radio1)
				{
					s13=r2.getText().toString();
				}
				else
				{
					Toast.makeText(getApplicationContext(), "select gender",1000).show();
				}
			}
		});
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String s1=name.getText().toString();
				String s2=age.getText().toString();
				String s3=abc.getText().toString();
				String s4=dob.getText().toString();
				String s5=phone.getText().toString();
				String s6=mail.getText().toString();
				String s7=dsig.getText().toString();
				String s8=jod.getText().toString();
				String s9=salarry.getText().toString();
				String s10=exp.getText().toString();
				String s11=quali.getSelectedItem().toString();
				String s12=dep.getSelectedItem().toString();
				if(s1.length()==0)
				{
					name.setError("Field Can't Be Empty");
				}
				else if(s2.length()==0)
				{
					age.setError("Field Can't Be Empty");
				}
				else if(s3.length()==0)
				{
					abc.setError("Field Can't Be Empty");
				}
				else if(s4.length()==0)
				{
					dob.setError("Field Can't Be Empty");
				}
				else if(s5.length()==0)
				{
					phone.setError("Field Can't Be Empty");
				}
				else if(s6.length()==0)
				{
					mail.setError("Field Can't Be Empty");
				}
				else if(s7.length()==0)
				{
					dsig.setError("Field Can't Be Empty");
				}
				else if(s8.length()==0)
				{
					jod.setError("Field Can't Be Empty");
				}
				else if(s9.length()==0)
				{
					salarry.setError("Field Can't Be Empty");
				}
				else if(s10.length()==0)
				{
					exp.setError("Field Can't Be Empty");
				}
				else
				{
					db.EmpregInsert(new addempmodel(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13));
					Toast.makeText(getApplicationContext(), "Details Inserted", 1000).show();
					Intent i= new Intent(getApplicationContext(),Welcome.class);
					startActivity(i);
				}
			}
		});
		
	}
	private void loadspinnerdata() {
		// TODO Auto-generated method stub
		List<String>labels=db.getdept();
		ArrayAdapter<String>datAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, labels);
		dep.setAdapter(datAdapter);
	}
	private void setdatetimefield() {
		// TODO Auto-generated method stub
		dob.setOnClickListener(this);
		jod.setOnClickListener(this);
		Calendar newcalendar= Calendar.getInstance();
		todaDatePickerDialog=new DatePickerDialog(this,new OnDateSetListener() {
			
			@Override
			public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub
				Calendar newdate=Calendar.getInstance();
				newdate.set(arg1, arg2, arg3);
				jod.setText(dateFormat.format(newdate.getTime()));
			}
		},newcalendar.get(Calendar.YEAR),
		newcalendar.get(Calendar.MONTH),
		newcalendar.get(Calendar.DAY_OF_MONTH));
		fromDatePickerDialog=new DatePickerDialog(this,new OnDateSetListener() {
			
			@Override
			public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub
				Calendar newdate=Calendar.getInstance();
				newdate.set(arg1,arg2,arg3);
				dob.setText(dateFormat.format(newdate.getTime()));
			}
		},newcalendar.get(Calendar.YEAR),
		newcalendar.get(Calendar.MONTH),
		newcalendar.get(Calendar.DAY_OF_MONTH));
			};
	
	private void findViewById() {
		// TODO Auto-generated method stub
		dob=(EditText)findViewById(R.id.namee);
		dob.setInputType(InputType.TYPE_NULL);
		//dob.requestFocus();
		jod=(EditText)findViewById(R.id.JOINDATE);
		jod.setInputType(InputType.TYPE_NULL);
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0==dob)
		{
			fromDatePickerDialog.show();
		}
		else if(arg0==jod)
		{
			todaDatePickerDialog.show();
		}
	}
	}
		
	


