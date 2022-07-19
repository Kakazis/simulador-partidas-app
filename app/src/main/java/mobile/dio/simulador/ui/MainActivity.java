package mobile.dio.simulador.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import mobile.dio.simulador.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupMatchesList();
        setupMatchesRefresh();
        setupFloatingActionButton();
    }

        private void setupMatchesList () {
            //TODO listar as partidas, consumindo nossa API.
        }

        private void setupMatchesRefresh () {
            //TODO atualizar as partidas na ação de swipe.
        }

        private void setupFloatingActionButton() {
            //TODO Criar evento de click e simulação de partidas.
        }
}
