package crl.research.aipe;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class aipe extends Activity {
	
	String[] transformList = {"", "Negative","B/W", "FFT"};
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView txt = (TextView) findViewById(R.id.TextView01);  
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/DroidLogo.ttf");  
        txt.setTypeface(font);
        
        Button btn1 = (Button) findViewById(R.id.Button01);
        Button btn2 = (Button) findViewById(R.id.Button02);
        Spinner spin = (Spinner) findViewById(R.id.Spinner01);
        
        btn1.setOnClickListener(mLoadImageListener);
        btn2.setOnClickListener(mResetListener);
        spin.setOnItemSelectedListener(mSpinListener);
        
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, transformList);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        spin.setAdapter(aa);
        
     }
    
    OnClickListener mLoadImageListener = new OnClickListener() {
        public void onClick(View v) {
            ((Toast)Toast.makeText(getBaseContext(), "Load Image (Coming Soon!)", Toast.LENGTH_SHORT)).show();
        }
    };
        
    OnClickListener mResetListener = new OnClickListener(){
    	public void onClick(View v){
    		((Toast)Toast.makeText(getBaseContext(), "Reset Image (Coming Soon!)", Toast.LENGTH_SHORT)).show();
    	}
    };
    
    OnItemSelectedListener mSpinListener = new OnItemSelectedListener(){
    	public void onNothingSelected(AdapterView<?> parent){
    		
    	}

		public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
			if (transformList[position] != ""){
				((Toast)Toast.makeText(getBaseContext(), transformList[position]+" Transform (Coming Soon!)", Toast.LENGTH_SHORT)).show();
			}
		}
    };
    
    public native void negative(Bitmap bmp);
    
    static {
    	System.loadLibrary("aipe");
    }
}