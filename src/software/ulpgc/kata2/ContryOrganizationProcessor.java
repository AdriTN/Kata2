package software.ulpgc.kata2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContryOrganizationProcessor implements OrganizationProcessor{
    @Override
    public Map<String, Integer> process(List<Organization> var1) {
        Map<String, Integer> result = new HashMap<>();
        for (Organization orgs: var1){
            String country = orgs.getCountry();
            result.put(country, result.getOrDefault(country, 0)+1);
        }
        return result;
    }
}
