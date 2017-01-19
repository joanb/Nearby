/*
Created by Helm  18/01/2017.
*/


package net.andapps.nearby.data.repository.shops;


import net.andapps.nearby.domain.model.Shop;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ShopsService {

    @GET("shops.json")
    Call<List<Shop>> getShops();
}
