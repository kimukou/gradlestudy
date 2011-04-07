package org.jggug.sample


import android.app.Activity;
import android.os.Bundle
import android.widget.TextView

public class Main extends Activity{
 
  
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState)
        TextView tv = new TextView(this)

        def list = ["Welcome","to", "discobot."
                , "\nAnd", "good", "luck", "with", "Main!", "日本語もOK。"]
        
        def str = ""
        list.each {
            str += it + " "
        }
    
        tv.setText(str)
        this.setContentView(tv)
    }
} 
