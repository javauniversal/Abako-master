package co.dito.abako.abako.Adapters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import co.dito.abako.abako.Entities.FiltroCartera;

public class ExpandableListDataPump {

    public static HashMap<String, List<String>> getData(FiltroCartera filtroCartera) {

        HashMap<String, List<String>> expandableListDetail = new LinkedHashMap<>();



        if (filtroCartera.getFrecuenciaList() != null || filtroCartera.getFrecuenciaList().size() > 0) {
            List<String> technology = new ArrayList<>();
            for (int a = 0; a < filtroCartera.getFrecuenciaList().size(); a++) {
                technology.add(a, filtroCartera.getFrecuenciaList().get(a).getDescription());
            }
            expandableListDetail.put("DÍA", technology);
        }

        if (filtroCartera.getZonaSyncList() != null || filtroCartera.getZonaSyncList().size() > 0) {
            List<String> technology2 = new ArrayList<>();
            for (int a = 0; a < filtroCartera.getZonaSyncList().size(); a++) {
                technology2.add(a, filtroCartera.getZonaSyncList().get(a).getDescripcion());
            }
            expandableListDetail.put("ZONA", technology2);
        }

        if (filtroCartera.getCanalSyncList() != null || filtroCartera.getCanalSyncList().size() > 0) {
            List<String> technology3 = new ArrayList<>();
            for (int a = 0; a < filtroCartera.getCanalSyncList().size(); a++) {
                technology3.add(a, filtroCartera.getCanalSyncList().get(a).getDescripcion());
            }
            expandableListDetail.put("CANAL", technology3);
        }

        return expandableListDetail;

    }

}
