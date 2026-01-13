package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Ereignis;
import model.SponsorGeschenk;
import model.Tribut;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class HungerGamesRepository {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Tribut> readTributes(String filePath) throws IOException {
        return Arrays.asList(objectMapper.readValue(new File(filePath), Tribut[].class));
    }

    public List<Ereignis> readEvents(String filePath) throws IOException {
        return Arrays.asList(objectMapper.readValue(new File(filePath), Ereignis[].class));
    }

    public List<SponsorGeschenk> readGifts(String filePath) throws IOException {
        return Arrays.asList(objectMapper.readValue(new File(filePath), SponsorGeschenk[].class));
    }
}
