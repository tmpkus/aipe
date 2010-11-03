package crl.research.aipe;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class aipe extends Activity {
	
	String[] transformList = {"", "Negative","B/W", "FFT"};
	Bitmap mBitmap;
	ImageView iv1;
	
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
        iv1 = (ImageView) findViewById(R.id.mainImageView);
        
        btn1.setOnClickListener(mLoadImageListener);
        btn2.setOnClickListener(mResetListener);
        spin.setOnItemSelectedListener(mSpinListener);
        
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, transformList);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        spin.setAdapter(aa);
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inPreferredConfig = Bitmap.Config.ARGB_8888;
        mBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.lena,opts);
        
     }
    
    OnClickListener mLoadImageListener = new OnClickListener() {
        public void onClick(View v) {
            ((Toast)Toast.makeText(getBaseContext(), "Load Image (Coming Soon!)", Toast.LENGTH_SHORT)).show();
        }
    };
        
    OnClickListener mResetListener = new OnClickListener(){
    	public void onClick(View v){
    		//((Toast)Toast.makeText(getBaseContext(), "Reset Image (Coming Soon!)", Toast.LENGTH_SHORT)).show();
    		mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lena);
    		iv1.setImageBitmap(mBitmap);
    	}
    };
    
    OnItemSelectedListener mSpinListener = new OnItemSelectedListener(){
    	public void onNothingSelected(AdapterView<?> parent){
    		
    	}

		public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
			if (transformList[position] != ""){
				((Toast)Toast.makeText(getBaseContext(), transformList[position]+" Transform (Coming Soon!)", Toast.LENGTH_SHORT)).show();
			}
			if (transformList[position] == "Negative"){
				//((Toast)Toast.makeText(getBaseContext(), mBitmap.getConfig().toString(), Toast.LENGTH_SHORT)).show();
				negative(mBitmap);
				iv1.setImageBitmap(mBitmap);
			}
		}
    };
    
    public native void negative(Bitmap bmp);
    
    static {
    	System.loadLibrary("aipe");
    }
}