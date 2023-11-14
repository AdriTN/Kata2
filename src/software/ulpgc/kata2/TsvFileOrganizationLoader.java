package software.ulpgc.kata2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TsvFileOrganizationLoader implements OrganizationLoader{

    private final File file;

    public TsvFileOrganizationLoader(File file) {
        this.file = file;
    }

    @Override
    public List<Object> load() {
        try{
            return this.load(new FileReader(this.file));
        }catch (IOException var2){
            return Collections.emptyList();
        }
    }

    private List<Object> load(FileReader fileReader) throws IOException {
        return this.load(new BufferedReader(fileReader));
    }

    private List<Object> load(BufferedReader bufferedReader) throws IOException{
        return bufferedReader.lines().skip(1L).map(this::toOrganization).collect(Collectors.toList());
    }

    private Object toOrganization(String s) {
        return this.toOrganization(s.split("\t"));
    }

    private Organization toOrganization(String[] fields) {
        return new Organization(fields[0],fields[1],fields[2],fields[3],fields[4], Integer.parseInt(fields[5]), fields[6], Integer.parseInt(fields[7]) );
    }
}
