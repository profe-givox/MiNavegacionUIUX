package net.ivanvega.minavegacionuiux.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import net.ivanvega.minavegacionuiux.R;
import net.ivanvega.minavegacionuiux.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnNavCon.setOnClickListener(view -> {
            //Navigation.findNavController(getView()).navigate(R.id.blankFragment);
            /*Navigation.findNavController(getActivity(), R.id.nav_host_fragment_content_main).navigate(R.id.blankFragment);*/
            Bundle bundle = new Bundle();
            bundle.putString("saludar", "Hola Mundo!");
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_nav_home_to_blankFragment, bundle);
        });

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}