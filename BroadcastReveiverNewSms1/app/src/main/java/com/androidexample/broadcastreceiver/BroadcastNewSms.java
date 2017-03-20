package com.androidexample.broadcastreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;


public class BroadcastNewSms extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.principal);
	}
	public void Listar (View view) {
		Intent i = new Intent(this, Listar.class );
		startActivity(i);
}
