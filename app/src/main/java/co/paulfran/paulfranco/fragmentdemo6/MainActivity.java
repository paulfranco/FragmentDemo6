package co.paulfran.paulfranco.fragmentdemo6;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyListener{

    private FragmentManager manager;
    private int firstNum, secondNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getFragmentManager();

        addFragmentA();
        addFragmentB();
    }

    private void addFragmentB() {

        FragmentB fragmentB = new FragmentB();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.containerFragmentB, fragmentB, "fragB");
        transaction.commit();

    }

    private void addFragmentA() {

        FragmentA fragmentA = new FragmentA();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.containerFragmentA, fragmentA, "fragA");
        transaction.commit();
    }

    public void sendDataToFragmentB(View view) {

        FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("fragB");
        fragmentB.addTwoNumbersInFragmentB(firstNum, secondNum);

    }

    @Override
    public void addTwoNumbers(int num1, int num2) {

        this.firstNum = num1;
        this.secondNum = num2;
        Toast.makeText(this, "Data has been received in MainActivity.java", Toast.LENGTH_SHORT).show();
    }
}
