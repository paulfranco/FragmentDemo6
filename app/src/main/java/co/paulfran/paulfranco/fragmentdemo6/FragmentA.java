package co.paulfran.paulfranco.fragmentdemo6;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FragmentA extends Fragment {

    private static final String TAG = FragmentA.class.getSimpleName();

    // Begin initialization of the button and text view
    private Button btnSend;
    private EditText etFirstNumber, etSecondNumber;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        etFirstNumber = (EditText) view.findViewById(R.id.etFirstNumber);
        etSecondNumber = (EditText) view.findViewById(R.id.etSecondNumber);

        // Complete initialization of the button and text view
        // Inside the FragmentA.java findViewBYId() method does not exists. for that purpose we need to make use of the ( view )
        btnSend = (Button) view.findViewById(R.id.btnSend);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });

        return view;
    }

    private void sendData() {

        int firstNum = Integer.valueOf(etFirstNumber.getText().toString());
        int secondNum = Integer.valueOf(etSecondNumber.getText().toString());

        MyListener myListener = (MyListener) getActivity();
        myListener.addTwoNumbers(firstNum, secondNum);
    }


}