package gwt.material.design.incubator.client.google.addresslookup.api;

import gwt.material.design.client.api.google.maps.GoogleMapsApi;
import gwt.material.design.client.api.google.maps.MapLibrary;

public class AddressLookupApi extends GoogleMapsApi {

    public AddressLookupApi(String apiKey) {
        super(apiKey);
    }

    @Override
    public MapLibrary getLibrary() {
        return MapLibrary.PLACES;
    }

    @Override
    public String getApiUrl() {
        return "https://maps.googleapis.com/maps/api/js";
    }
}
