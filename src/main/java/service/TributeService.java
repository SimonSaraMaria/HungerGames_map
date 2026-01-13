package service;
import model.Tribut;
import java.util.List;
import java.util.stream.Collectors;

public class TributeService {
    public List<Tribut> filterAliveByDistrict(List<Tribut> tributes, int district) {
        return tributes.stream()
                .filter(t ->t.getdistrict() == district)
                .filter(t -> t.getStatus().equals("ALIVE"))
                .collect(Collectors.toList());
    }
}
