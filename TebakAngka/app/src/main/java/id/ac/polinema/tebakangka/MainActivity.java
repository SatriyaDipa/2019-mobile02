package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //  TODO: deklarasikan variabel di sini
    private Random rand;
	private int randNum;
	private EditText InputForm;
	private Button tebakBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		InputForm = findViewById(R.id.number_input);
		tebakBtn = findViewById(R.id.guess_button);
		initRandomNumber();
		rand = new Random();
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
			randNum = rand.nextInt(50)+1;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
        String inAngkaString = InputForm.getText().toString();
		if (inAngkaString.equalsIgnoreCase("")) {
		    Toast.makeText(this, "Input harus berupa angka!", Toast.LENGTH_SHORT).show();
        } else {
            int inAngka = Integer.parseInt(inAngkaString);
            if (inAngka < randNum) {
                Toast.makeText(this, "Tebakan anda terlalu kecil!", Toast.LENGTH_SHORT).show();
            } else if (inAngka > randNum) {
                Toast.makeText(this, "Tebakan anda terlalu besar!", Toast.LENGTH_SHORT).show();
            } else if (inAngka == randNum) {
                Toast.makeText(this, "Tebakan anda benar!", Toast.LENGTH_SHORT).show();
                tebakBtn.setEnabled(false);
            }
        }
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		InputForm.setText("");
		initRandomNumber();
		tebakBtn.setEnabled(true);
	}
}