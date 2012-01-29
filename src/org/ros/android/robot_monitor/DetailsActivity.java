/*
 * Copyright (c) 2012, Chad Rockey
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the Android Robot Monitor nor the names of its
 *       contributors may be used to endorse or promote products derived from
 *       this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package org.ros.android.robot_monitor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;

/**
 * @author chadrockey@gmail.com (Chad Rockey)
 */
public class DetailsActivity extends Activity {

  public DetailsActivity() {
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.details);
    Intent intent = getIntent();
	 /*myIntent.putExtra("level", ds.level);
	 String[] keys = new String[ds.values.size()];
	 String[] values = new String[ds.values.size()];
	 for(int i = 0; i < ds.values.size(); i++){
		 keys[i] = ds.values.get(i).key;
		 values[i] = ds.values.get(i).value;
	 }
	 myIntent.putExtra("keys", keys);
	 myIntent.putExtra("values", values);*/
    TextView tname = (TextView)this.findViewById(R.id.name);
    tname.setText(intent.getStringExtra("name"));
    TextView thard = (TextView)this.findViewById(R.id.hardware_id);
    thard.setText(intent.getStringExtra("hardware_id"));
    TextView tmess = (TextView)this.findViewById(R.id.message);
    tmess.setText(intent.getStringExtra("message"));
    TableLayout tl = (TableLayout)this.findViewById(R.id.keys);
    String[] keys = intent.getStringArrayExtra("keys");
    String[] values = intent.getStringArrayExtra("values");
    for(int i = 0; i < keys.length; i++){
    	TextView tv = new TextView(this);
    	String keystring = keys[i] + ": " + values[i];
    	tv.setText(keystring);
    	tl.addView(tv);
    }
  }

  @Override
  protected void onResume() {
    super.onResume();
  }

  @Override
  protected void onPause() {
    super.onPause();
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == 0 && resultCode == RESULT_OK) {
    }
  }

}
