package co.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import static android.app.Activity.RESULT_OK;
import static android.support.v4.app.FragmentManager.POP_BACK_STACK_INCLUSIVE;
import static co.myapplication.ResultFragment.EXTRA_RESULT;
import static co.myapplication.ResultFragment.TAG_RESULT;

/**
 * Created by
 *
 * @author Peter Bukhal petr.bukhal <at> doconcall.ru
 *         on 11.08.2017.
 */
public class TargetFragment extends Fragment {

    public static final String TAG_TARGET = "t_target";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.f_target, container, false);
    }

    private Button btPick;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        btPick = (Button) view.findViewById(R.id.pick_dialog);
        btPick.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ResultFragment resultFragment = new ResultFragment();
                resultFragment.setTargetFragment(TargetFragment.this, CODE);

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.content, resultFragment, TAG_RESULT)
                        .addToBackStack(TAG_RESULT)
                        .commit();
            }

        });
    }

    public static final int CODE = 1000;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case CODE: {
                getActivity().getSupportFragmentManager()
                        .popBackStack(TAG_RESULT, POP_BACK_STACK_INCLUSIVE);

                if (resultCode == RESULT_OK && data != null && data.getExtras().containsKey(EXTRA_RESULT)) {
                    String result = data.getStringExtra(EXTRA_RESULT);

                    Toast.makeText(getActivity(), "result: " + result, Toast.LENGTH_SHORT).show();
                }
            } break;
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
