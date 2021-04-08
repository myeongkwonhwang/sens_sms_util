package me.mkhwang.senssms.sendModule.response.parser;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

/**
 * Created by mkhwang on 2021/04/08.
 */
public class ResponseData {
    private final int statusCode;
    private final String responseXml;

    public ResponseData(int statusCode, String rawXmlString) {
        this.statusCode = statusCode;
        this.responseXml = rawXmlString;
    }

    public int getStatusCode() { return this.statusCode; }

    public String getResponseXml() { return this.responseXml; }

    public String toJSON() throws JSONException {
        JSONObject jsonObject = XML.toJSONObject(this.responseXml);
        return  jsonObject.toString();
    }
}
