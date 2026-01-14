package service;
import model.Tribut;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

import java.util.stream.Collectors;

public class TributeService {
    public List<Tribut> filterAliveByDistrict(List<Tribut> tributes, int district) {
        return tributes.stream()
                .filter(t ->t.getdistrict() == district)
                .filter(t -> t.getStatus().equals("ALIVE"))
                .collect(Collectors.toList());
    }

    public List<Tribut> getSortedTributes(List<Tribut> tributes) {
        List<Tribut> sortedList = new ArrayList<>(tributes);

        sortedList.sort(Comparator
                .comparing(Tribut::getSkillLevel).reversed()
                .thenComparing(Tribut::getName));

        return sortedList;
    }

    public void saveTributesToFile(List<Tribut> sortedTributes, String fileName) throws IOException {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (Tribut tribute : sortedTributes) {
                writer.println(tribute.toString());
            }
        }
    }
}
