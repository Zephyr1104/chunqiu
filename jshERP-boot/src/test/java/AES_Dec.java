// AES256_GCM
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
public class AES_Dec {
    public static Object getRealResp(JsonObject ctx,JsonObject resp){
        byte[] decryptedBytes = null;
        // 开发者本地信息
        String local_appid = ctx.get("local_appid").getAsString();
        String url_path = ctx.get("url_path").getAsString();
        String local_sym_sn = ctx.get("local_sym_sn").getAsString();
        String local_sym_key = ctx.get("local_sym_key").getAsString();
        // API响应数据，解密只需要响应头时间戳与响应数据
        long respTs = resp.get("resp_ts").getAsLong();
        String respData = resp.get("resp_data").getAsString();

        JsonParser parser = new JsonParser();
        JsonElement resp_data = parser.parse(respData);
        String iv = resp_data.getAsJsonObject().get("iv").getAsString();
        String data = resp_data.getAsJsonObject().get("data").getAsString();
        String authtag = resp_data.getAsJsonObject().get("authtag").getAsString();
        // 构建AAD
        String aad = url_path + "|" + local_appid + "|" + respTs + "|" + local_sym_sn;
        // 拼接cipher和authtag
        byte[] dataBytes = Base64.getDecoder().decode(data);
        byte[] authtagBytes = Base64.getDecoder().decode(authtag);
        byte[] new_dataBytes = new byte[dataBytes.length+authtagBytes.length];
        System.arraycopy(dataBytes,0,new_dataBytes,0,dataBytes.length);
        System.arraycopy(authtagBytes,0,new_dataBytes,dataBytes.length,authtagBytes.length);
        byte[] aadBytes = aad.getBytes(StandardCharsets.UTF_8);
        byte[] ivBytes = Base64.getDecoder().decode(iv);
        Object realResp = null;
        try
        {
            byte[] keyBytes = Base64.getDecoder().decode(local_sym_key);
            SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(128, ivBytes);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, gcmParameterSpec);
            cipher.updateAAD(aadBytes);
            try{
                decryptedBytes = cipher.doFinal(new_dataBytes);
            }catch (Exception e){
                System.out.println("auth tag验证失败");
                return null;
            }

            // 解密结果
            String decryptedData = new String(decryptedBytes, StandardCharsets.UTF_8);
            JsonElement element = parser.parse(decryptedData);
            Gson gson = new Gson();
            realResp = gson.fromJson(element,Object.class);
            long localTs = System.currentTimeMillis() / 1000;
            // 安全检查，根据业务实际需求判断
            if (element.getAsJsonObject().get("_appid").getAsString() == local_appid // appid不匹配
                    || element.getAsJsonObject().get("_timestamp").getAsLong() != respTs // timestamp与Wechatmp-TimeStamp不匹配
                    || localTs - element.getAsJsonObject().get("_timestamp").getAsLong() > 300 // 响应数据的时候与当前时间超过5分钟
            ) {
                System.out.println("安全字段校验失败");
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return realResp;

    }

    private static JsonObject getCtx(){
        JsonObject ctx = new JsonObject();
        // 仅做演示，敏感信息请勿硬编码
        ctx.addProperty("local_sym_key","d7lMJJCFj8doS3cOBS46LKiFaJ+KwEgdCsQSGYOrK30=");
        ctx.addProperty("local_sym_sn","028fa97e6427a67d3fa22cbf05726c98");
        ctx.addProperty("local_appid","wx51842d6e894b234b");
        ctx.addProperty("url_path","https://api.weixin.qq.com/cgi-bin/express/intracity/querystore");

        return ctx;
    }
    private static JsonObject getResp(){
        JsonObject resp = new JsonObject();
        String respData = "{\"iv\":\"f5oTet0gAITWghfq\",\"data\":\"NbuwCeGbE9O/5Mp1ydNSG1Ye2zONHN4MbbQEI+aEPvCc1m3/IODNkUTg3JrvuTPEDVhNOFP2nwm88E2yOmRBNqkuchGfpHbMwpMi9dewWdGB+rKdVnjd5qnHz7xSOFt9y2Q2fB7y7haU5eW45C2nMQk2RKtQN5BVFUghvksoDKd2ZExaeav6FOXekKyPkXZjJjYboBkihXY5wx3mFJXLGYv+PVXC5oJHX7oEdGBIAXWsgcyTRbS2lC17IHU=\",\"authtag\":\"UfkwE7T2roXbajS0MI4dQg==\"}";
        resp.addProperty("resp_ts",1728548050);
        resp.addProperty("resp_data",respData);

        return resp;
    }
    public static void main(String[] args)  {
        JsonObject resp = getResp();
        JsonObject ctx = getCtx();
        Object res = getRealResp(ctx,resp);
        System.out.println(res);
    }
}