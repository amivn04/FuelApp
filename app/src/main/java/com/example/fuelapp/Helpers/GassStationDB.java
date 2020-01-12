package com.example.fuelapp.Helpers;

import com.example.fuelapp.Models.GassStation;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class GassStationDB {



    public static List<GassStation> getGassStations() {

        List<GassStation> stations = new ArrayList<>();

        stations.add(new GassStation(1, "Лукойл",
                "ул. Жиделева, 2, Иваново, Ивановская обл., 153000"
        , new LatLng(57.007530, 40.970435)));

        stations.add(new GassStation(2, "Лукойл",
                "ул. Тимирязева, 60, Иваново, Ивановская обл., 153025"
                , new LatLng(57.0156903, 40.9556346)));

        stations.add(new GassStation(3, "Лукойл",
                "Большая Воробьевская ул., 84, Иваново, Ивановская обл., 153022"
                , new LatLng(56.9890705, 40.9526083)));

        stations.add(new GassStation(4, "Газпромнефть АЗС №131",
                "Рабфаковская ул., 11, Иваново, Ивановская обл., 153000"
                , new LatLng(57.0065119, 40.9494973)));

        stations.add(new GassStation(5, "Газпромнефть АЗС №103",
                "4-я Завокзальная ул., 40а, Иваново, Ивановская обл., 153000"
                , new LatLng(57.0130226, 40.9650295)));

        stations.add(new GassStation(6, "«IvOil» АЗС №3",
                "Слесарный пер., 9, Иваново, Ивановская обл., 153003"
                , new LatLng(57.0039682, 40.9560828)));

        stations.add(new GassStation(7, "АЗС Muller",
                "ул. Парижской Коммуны, 62А, Иваново, Ивановская обл., 153031"
                , new LatLng(57.007941, 40.9025417)));
        return stations;

    }
}
