package com.vin;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class DefineVariables {

    HashMap<String, String> envVarMap = new HashMap<>();

    public HashMap<String, String> getEnvVarMap() {
        return envVarMap;
    }

    public void setEnvVarMap(HashMap<String, String> envVarMap) {
        this.envVarMap = envVarMap;
    }


    public void setCMDArguements(String[] args) throws UnsupportedEncodingException {
        HashMap<String, String> tempEnvMap = new HashMap<>();
        for (String envVariables : args) {
            envVariables = envVariables.replaceFirst("=","*");
            StringTokenizer stringTokenizer = new StringTokenizer(envVariables, "*");
            while (stringTokenizer.hasMoreTokens()) {
                String key = stringTokenizer.nextToken();
                String value = stringTokenizer.nextToken();
                tempEnvMap.put(key, value);
            }
        }
        setEnvVariables(tempEnvMap);
    }

    public void setEnvVariables(HashMap<String, String> envMap) {
        if (envMap.isEmpty()) {
            envMap = getEnvVarMap();
        }

        for (Iterator it = envMap.keySet().iterator(); it.hasNext(); ) {
            String keyValue = it.next().toString();
            System.out.println(keyValue+"--"+envMap.get(keyValue));
            System.setProperty(keyValue, envMap.get(keyValue));

        }

    }

}
