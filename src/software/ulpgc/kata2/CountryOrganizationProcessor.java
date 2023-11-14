package software.ulpgc.kata2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CountryOrganizationProcessor implements OrganizationProcessor{

    public CountryOrganizationProcessor() {
    }

    @Override
    public Map<String, Integer> process(List<Organization> var1) {
        Map<String, Integer> result = new HashMap<>();
        Iterator var3 = var1.iterator();

        while (var3.hasNext()){
            Organization org = (Organization) var3.next();
            String key = org.getCountry();
            result.put(key, (Integer)result.getOrDefault(key,0)+1);
        }
        return result;
    }
}
