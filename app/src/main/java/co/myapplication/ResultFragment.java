package co.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import static android.app.Activity.RESULT_OK;
import static co.myapplication.TargetFragment.CODE;

/**
 * Created by
 *
 * @author Peter Bukhal petr.bukhal <at> doconcall.ru
 *         on 11.08.2017.
 */
public class ResultFragment extends Fragment {

    public static final String TAG_RESULT = "f_result";
    public static final String EXTRA_RESULT = "result";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.f_result, container, false);
    }

    EditText etResult;
    Button btResult;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        etResult = (EditText) view.findViewById(R.id.et_result);
        btResult= (Button) view.findViewById(R.id.bt_result);
        btResult.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                getTargetFragment()
                        .onActivityResult(CODE, RESULT_OK,
                                new Intent().putExtra(EXTRA_RESULT, etResult.getText().toString()));
            }

        });
    }
}
