package app.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjToJSON {
    public static String JSONify(final Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonContent = null;

        try {
            jsonContent = mapper.writeValueAsString(obj);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonContent;
    }
}