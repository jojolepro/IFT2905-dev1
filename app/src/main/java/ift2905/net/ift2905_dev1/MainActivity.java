package ift2905.net.ift2905_dev1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but = (Button)findViewById(R.id.button);
        but.setOnClickListener(buttonListener);

        b1.setBackgroundColor(getResources().getColor(R.color.neutral));
    }

    View.OnClickListener buttonListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(is_blinking){
                // Le clignotement est activé: Le désactiver
                b1.setText(R.string.activer);
                is_blinking = false;

                timer.removeCallbacks(timer_listener);
                b1.setBackgroundColor(getResources().getColor(R.color.neutral));
            }else{
                // Le clignotement est désactivé: L'activer
                b1.setText(R.string.desactiver);
                is_blinking = true;

                timer_listener.run();
            }
        }
    };
}