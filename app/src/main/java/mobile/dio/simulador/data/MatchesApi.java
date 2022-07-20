package mobile.dio.simulador.data;

import java.util.List;

import mobile.dio.simulador.domain.Match;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MatchesApi {

    @GET("matches.json")
    Call<List<Match>> getMatches();

}
