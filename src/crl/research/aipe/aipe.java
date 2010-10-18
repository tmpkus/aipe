package crl.research.aipe;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class aipe extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView txt = (TextView) findViewById(R.id.TextView01);  
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/DroidLogo.ttf");  
        txt.setTypeface(font);
        
        ((Button) findViewById(R.id.Button01)).setOnClickListener(mSelectListener);
        ((Button) findViewById(R.id.Button02)).setOnClickListener(mProcessListener);
        ((Button) findViewById(R.id.Button03)).setOnClickListener(mResetListener);
        
     }
    
    OnClickListener mSelectListener = new OnClickListener() {
        public void onClick(View v) {
            finish();
        }
    };
    
    OnClickListener mProcessListener = new OnClickListener(){
    	public void onClick(View v){
    		finish();
    	}
    };
    
    OnClickListener mResetListener = new OnClickListener(){
    	public void onClick(View v){
    		finish();
    	}
    };
}