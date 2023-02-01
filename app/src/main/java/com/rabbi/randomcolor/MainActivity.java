package com.rabbi.randomcolor;
 
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.graphics.Color;
import android.widget.TextView;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends Activity implements View.OnClickListener{ 
   private RelativeLayout display_color1,display_color2,display_color3,display_color4,display_color5;
   private RelativeLayout display_color6;
   private ImageView generateBtn;
   private TextView color1_text,color2_text,color3_text,color4_text,color5_text,color6_text,copy1,copy2,copy3,copy4,copy5,copy6;
   private StringBuilder color1,color2,color3,color4,color5,color6;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        display_color1 = findViewById(R.id.color1);
        display_color2 = findViewById(R.id.color2);
        display_color3 = findViewById(R.id.color3);
        display_color4 = findViewById(R.id.color4);
        display_color5 = findViewById(R.id.color5);
        display_color6 = findViewById(R.id.color6); 
        generateBtn = findViewById(R.id.generateBtn);
        color1_text = findViewById(R.id.color1_text);
        color2_text = findViewById(R.id.color2_text);
        color3_text = findViewById(R.id.color3_text);
        color4_text = findViewById(R.id.color4_text);
        color5_text = findViewById(R.id.color5_text);
        color6_text = findViewById(R.id.color6_text);
        copy1 = findViewById(R.id.copy1);
        copy2 = findViewById(R.id.copy2);
        copy3 = findViewById(R.id.copy3);
        copy4 = findViewById(R.id.copy4);
        copy5 = findViewById(R.id.copy5);
        copy6 = findViewById(R.id.copy6);
        
        copy1.setOnClickListener(this);
        copy2.setOnClickListener(this);
        copy3.setOnClickListener(this);
        copy4.setOnClickListener(this);
        copy5.setOnClickListener(this);
        copy6.setOnClickListener(this);
        
        
        // Initial Call
        generateAndApply();
        
        generateBtn.setOnClickListener(new View.OnClickListener(){

             @Override
             public void onClick(View p1) {
                generateAndApply();
             }                        
        });
                
    }
    
    // Generate & Apply
    public void generateAndApply(){
       String[] color_codes = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};                  
       color1 = new StringBuilder();
       color2 = new StringBuilder();
       color3 = new StringBuilder();
       color4 = new StringBuilder();
       color5 = new StringBuilder();
       color6 = new StringBuilder();
       color1.append("#");
       color2.append("#");
       color3.append("#");
       color4.append("#");
       color5.append("#");
       color6.append("#");

       for (int i = 0; i < 6; i++) {          
          int random_number1 = (int)(Math.random()*(15-0+1)+0);  
          color1.append(color_codes[random_number1]);
            
          int random_number2 = (int)(Math.random()*(15-0+1)+0);  
          shuffleArray(color_codes);
          color2.append(color_codes[random_number2]);

          int random_number3 = (int)(Math.random()*(15-0+1)+0);  
          color3.append(color_codes[random_number3]);

          int random_number4 = (int)(Math.random()*(15-0+1)+0);  
          shuffleArray(color_codes);
          color4.append(color_codes[random_number4]);

          int random_number5 = (int)(Math.random()*(15-0+1)+0);  
          shuffleArray(color_codes);
          color5.append(color_codes[random_number5]);

          int random_number6 = (int)(Math.random()*(15-0+1)+0);  
          shuffleArray(color_codes);
          color6.append(color_codes[random_number6]);
          
       }
       

       // Display Color
       display_color1.setBackgroundColor(Color.parseColor(color1.toString()));
       display_color2.setBackgroundColor(Color.parseColor(color2.toString()));
       display_color3.setBackgroundColor(Color.parseColor(color3.toString()));
       display_color4.setBackgroundColor(Color.parseColor(color4.toString()));
       display_color5.setBackgroundColor(Color.parseColor(color5.toString()));
       display_color6.setBackgroundColor(Color.parseColor(color6.toString()));
       
       color1_text.setText(color1);
       color2_text.setText(color2);
       color3_text.setText(color3);
       color4_text.setText(color4);
       color5_text.setText(color5);
       color6_text.setText(color6);
       
       //int c = generateBtn.getBackground().getcolor();
       //Toast.makeText(getApplication(), ""+ .toString(), Toast.LENGTH_SHORT).show();      
       
    }
    
    // Array Shuffling Method
   static void shuffleArray(String[] ar)
   {
      // If running on Java 6 or older, use `new Random()` on RHS here
      Random rnd = ThreadLocalRandom.current();
      for (int i = ar.length - 1; i > 0; i--)
      {
         int index = rnd.nextInt(i + 1);
         // Simple swap
         String a = ar[index];
         ar[index] = ar[i];
         ar[i] = a;
      }
   }
    
    
    //
   @Override
   public void onClick(View btn) {
      switch(btn.getId()){
         case R.id.copy1:
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getApplicationContext().getSystemService(getApplicationContext().CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", color1_text.getText().toString());
            clipboard.setPrimaryClip(clip);
            Toast.makeText(getApplication(), "Color copied to clipboard", Toast.LENGTH_SHORT).show();
            break;
         case R.id.copy2:
            android.content.ClipboardManager clipboard2 = (android.content.ClipboardManager) getApplicationContext().getSystemService(getApplicationContext().CLIPBOARD_SERVICE);
            android.content.ClipData clip2 = android.content.ClipData.newPlainText("Copied Text", color2_text.getText().toString());
            clipboard2.setPrimaryClip(clip2);
            Toast.makeText(getApplication(), "Color copied to clipboard", Toast.LENGTH_SHORT).show();
            break;
         case R.id.copy3:
            android.content.ClipboardManager clipboard3 = (android.content.ClipboardManager) getApplicationContext().getSystemService(getApplicationContext().CLIPBOARD_SERVICE);
            android.content.ClipData clip3 = android.content.ClipData.newPlainText("Copied Text", color3_text.getText().toString());
            clipboard3.setPrimaryClip(clip3);
            Toast.makeText(getApplication(), "Color copied to clipboard", Toast.LENGTH_SHORT).show();
            break;
         case R.id.copy4:
            android.content.ClipboardManager clipboard4 = (android.content.ClipboardManager) getApplicationContext().getSystemService(getApplicationContext().CLIPBOARD_SERVICE);
            android.content.ClipData clip4 = android.content.ClipData.newPlainText("Copied Text", color4_text.getText().toString());
            clipboard4.setPrimaryClip(clip4);
            Toast.makeText(getApplication(), "Color copied to clipboard", Toast.LENGTH_SHORT).show();
            break;
         case R.id.copy5:
            android.content.ClipboardManager clipboard5 = (android.content.ClipboardManager) getApplicationContext().getSystemService(getApplicationContext().CLIPBOARD_SERVICE);
            android.content.ClipData clip5 = android.content.ClipData.newPlainText("Copied Text", color5_text.getText().toString());
            clipboard5.setPrimaryClip(clip5);
            Toast.makeText(getApplication(), "Color copied to clipboard", Toast.LENGTH_SHORT).show();
            break;
         case R.id.copy6:
            android.content.ClipboardManager clipboard6 = (android.content.ClipboardManager) getApplicationContext().getSystemService(getApplicationContext().CLIPBOARD_SERVICE);
            android.content.ClipData clip6 = android.content.ClipData.newPlainText("Copied Text", color6_text.getText().toString());
            clipboard6.setPrimaryClip(clip6);
            Toast.makeText(getApplication(), "Color copied to clipboard", Toast.LENGTH_SHORT).show();
            break;
            
            
          default:
            
      }
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      MenuInflater inflater = getMenuInflater();
      inflater.inflate(R.menu.main_menu,menu);
      return super.onCreateOptionsMenu(menu);
   }             
      
   @Override
   public boolean onOptionsItemSelected(MenuItem item) {

      if(item.getItemId() == R.id.followId){
         Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://cutt.ly/rabbi"));
         startActivity(intent);
      }

      return super.onOptionsItemSelected(item);
   }
	
} 

