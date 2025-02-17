// RSAwithSHA256
import com.google.gson.JsonObject;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.PSSParameterSpec;
import java.util.Base64;
public class RSA_Sign {
    public static String getSignature(JsonObject ctx, JsonObject req){
        String signatureBase64 = null;
        // 开发者本地信息
        String local_appid = ctx.get("local_appid").getAsString();
        String url_path = ctx.get("url_path").getAsString();
        String local_sym_sn = ctx.get("local_sym_sn").getAsString();
        String local_private_key = ctx.get("local_private_key").getAsString();
        // 待请求API数据
        long reqTs = req.get("req_ts").getAsLong();
        String reqData = req.get("req_data").getAsString();

        String payload = url_path + "\n" + local_appid + "\n" + reqTs + "\n" + reqData;
        byte[] dataBuffer = payload.getBytes(StandardCharsets.UTF_8);
        try{
            local_private_key = local_private_key.replace("-----BEGIN PRIVATE KEY-----", "");
            local_private_key = local_private_key.replace("-----END PRIVATE KEY-----", "");
            local_private_key = local_private_key.replaceAll("\\s+","");
            byte[] decoded = Base64.getDecoder().decode(local_private_key);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decoded);
            RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(keySpec);
            Signature signature = Signature.getInstance("RSASSA-PSS");
            // salt长度，需与SHA256结果长度(32)一致
            PSSParameterSpec pssParameterSpec = new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1);
            signature.setParameter(pssParameterSpec);
            signature.initSign(priKey);
            signature.update(dataBuffer);
            byte[] sigBuffer = signature.sign();
            signatureBase64 = Base64.getEncoder().encodeToString(sigBuffer);
        }catch (Exception e){
            e.printStackTrace();
        }
        return signatureBase64;
        /*
        最终请求头字段
        {
            "Wechatmp-Appid": local_appid,
            "Wechatmp-TimeStamp": req_ts,
            "Wechatmp-Signature": sig,
        }
        */
    }
    private static JsonObject getReq(){
        JsonObject req = new JsonObject();
        req.addProperty("req_ts",1728544959);
        req.addProperty("req_data","{\"iv\":\"mj6CFwwkaS9Ow1D6\",\"data\":\"WnIRzT28HpAl06tSqOwV81BHVU144iJTIoSxHaxepCQK24WYyzaECsNEJ4KFQz0M8BQjSVvuHbICk8kxslwveAAx3hbKRWz7V8fd/b37eNXV4j4+vRh7RszAQWQT+cVUfkkScFyflGTsYBnwh+WGz2qpUGQUW7XIc7svO2jvFnvVreGY58u9sv3LMRjJKVgSV6DEPyWwBYEX4m3LEVl4nJU6Sc5YBjXI8ePplQO9+zbpi57jmu9dv+icNgc=\",\"authtag\":\"eM/19LI0EfTTIHlEaCT3Hg==\"}");
        return req;
    }
    private static JsonObject getCtx(){
        JsonObject ctx = new JsonObject();
        // 仅做演示，敏感信息请勿硬编码
        String localPrivateKey = "-----BEGIN PRIVATE KEY-----\n" +
                "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC1OYsFf9snOx93\n" +
                "Od/jwYnGq4nyJCPlGuGZHUv75pM4f6j89TECHpjbh17u18nX3oDB8VsrUFc7WvoR\n" +
                "QGFN3YglziQoyOqUb7pndjc1IblZY1uvTr8S3ZhCkYy7JHSlL+AlQcRJH91x47ey\n" +
                "rFls/ZARMgVYlrlqHW7Bfk9dViX88GpTrxaDOwQ9cJbWyWQLBqwAuovDVRdiTHX8\n" +
                "mfyY9iNMUb26RHyYPgN/nyL5qe8wwbOLg6mj5//bl5u0ukaEJvXfVHzS3oMREIm4\n" +
                "cKy7NgMrHcbxk9Kpha7mNhxOn52+wCkhjB6LEf0nfD9jGO01ApyLslY4ZEIG8z+K\n" +
                "AW/E57ZNAgMBAAECggEBAKkshX3lxDSUOaR4D2wy0KX4nna/jA6kkHL56WPG9Cnq\n" +
                "6lrxnQVogLN2ZIW8RX1SBYqG/9+oSTZskEKoge1JX35DOHgmTu2weyd4MMNVrwwl\n" +
                "94HolfBLkoaaDvDocEeAMNM22MCWkYdu155gy7412lZjBqCTW5UW0ryoZ/guopnC\n" +
                "VClEoHgFIC3+fHmGAPlK86D371kbQ2jQtvHIk+vlMxH+yjJKLp/3Qn8AVfnONUM2\n" +
                "rsBwUilBiDEvk27bthCAWr4lbZfbF/FSr82XJWYQZnh7gxpUK/Tg9qWZw5MTStef\n" +
                "m8qgaWvY+V3H1iZ42HfG76lOVaLCkD49SpXINAvnWQECgYEA8NIBqO0KMZlEb2EC\n" +
                "p5uxvRil9X0RHMkGHXsLakPjM/2vY7MtzrazPTelGBIHSIVcj++/9jn1QojUUlYn\n" +
                "IviUZpVUzBd+AiUVi64Vz6YNrBMTWki5OMmj4lDw1YPnuM20uB291giH1WS0D4nx\n" +
                "ADD0S+wHt6VAIKY0R8vXpiNVSkECgYEAwKXfrzAKs6NlRACJ7gtdog0eZfCXONeM\n" +
                "EWKdbopyLmQYxld2Nu72Sram2Pzu8ywCIZMF2aUKzFep7jN/375pZojgsFzOQhhH\n" +
                "S41JTkRJrOiwjG20prMb3DsE0qUdAexisZemUDEERwHS7byqAxT9GSqQm/Ni/CD7\n" +
                "L9F3iho8sQ0CgYEA75Ir/o5Zvr/XuenLR0x3REP6Db7uwDEnuTpIP93rcDRmQAvn\n" +
                "fSZ6J2NtBQYiYr3xOGvtDxnXaOpQNtzoMD0U/PyAEE0qmR2lUoDLx/hMz6tmbEG+\n" +
                "qcTHGYUmIXMImetiZmuICB4Sa3K0QmUa8PLChaj4gHSP2CsgBXC/RtMNrUECgYAe\n" +
                "jzF4fMp1zImXy+4VUMA9oI8d5JhYb/jMGTSYAGY0bbRwYhdih22SVH8LFLRi5qw/\n" +
                "3y6iY8feulk+a/Tw7SeTGEtsLoyZd3h3x6XFQJffUdoPrKdneioFOWd+cqqzT2go\n" +
                "e8HqHpxrFyL6i178tiuf/lyKIIWnMSQnZbbstVTDUQKBgAmdNxrmgy64JVK+OILy\n" +
                "KQQ29QG1dex/Yqhj4opvx1DGiY9ejeYcxnagILvezwCnOuxvTtj6OwUN6A2AeZ5D\n" +
                "LE0Nd55LY6AKVQlNZLOGay8gHPT17XLGelaftQgy+XnuVdQJgq7ltGHag/J6RRHe\n" +
                "+M1TsJ4WmFHMGLvB1ZNtDQmo\n" +
                "-----END PRIVATE KEY-----\n";
        ctx.addProperty("local_private_key",localPrivateKey);
        ctx.addProperty("local_sym_sn","29c2495b96fd3781ca1991f7b28fec87");
        ctx.addProperty("local_appid","wx51842d6e894b234b");
        ctx.addProperty("url_path","https://api.weixin.qq.com/cgi-bin/express/intracity/querystore");
        return ctx;
    }
    public static void main(String[] args) {
        JsonObject req = getReq();
        JsonObject ctx = getCtx();
        String res = getSignature(ctx,req);
        System.out.println(res);

    }
}