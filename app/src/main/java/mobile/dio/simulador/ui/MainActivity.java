package mobile.dio.simulador.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import mobile.dio.simulador.R;
import mobile.dio.simulador.data.MatchesApi;
import mobile.dio.simulador.databinding.ActivityMainBinding;
import mobile.dio.simulador.domain.Match;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MatchesApi matchesApi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupHttpClient();
        setupMatchesList();
        setupMatchesRefresh();
        setupFloatingActionButton();
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://github.com/Kakazis/simulador-partidas-api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        matchesApi = retrofit.create(MatchesApi.class);
    }

    private void setupMatchesList () {
            matchesApi.getMatches().enqueue(new Callback<List<Match>>() {
                @Override
                public void onResponse(Call<List<Match>> call, Response<List<Match>> response) {
                    if(response.isSuccessful()) {
                        List<Match> matches = response.body();
                    } else {
                        showErrorMessage();
                    }
                }

                @Override
                public void onFailure(Call<List<Match>> call, Throwable t) {
                    showErrorMessage();
                }
            });
        }

    private void setupMatchesRefresh () {
            //TODO atualizar as partidas na a????o de swipe.
        }

        private void setupFloatingActionButton() {
            //TODO Criar evento de click e simula????o de partidas.
        }

    private void showErrorMessage() {
        Snackbar.make(binding.fabSimulate, R.string.error_api, Snackbar.LENGTH_LONG).show();
    }

}
