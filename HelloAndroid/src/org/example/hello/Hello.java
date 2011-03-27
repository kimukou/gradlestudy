package org.example.hello;

import android.app.Activity;
import android.os.Bundle;
import twitter4j.*;

public class Hello extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
				Twitter twitter = new TwitterFactory().getInstance();
				System.out.println(twitter);
    }
}
