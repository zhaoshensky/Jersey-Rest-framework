package com.sdc.api.v1.demo.Redis;

import com.sdc.utils.ClientConstant;
import com.sdc.utils.Response;
import com.sun.jersey.api.spring.Autowire;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.json.Json;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Administrator on 2017/4/13.
 */
@Autowire
@Path("OperaRedisService")
public class OperaRedis {
    @Autowired
    private RedisUtil redisUtil;

    /**
     *
     * @param key
     * @param field
     * @return
     */
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@QueryParam("key") String key, @QueryParam("field") String field) {
        if (key == null) {
            return Response.info().setCode(ClientConstant.MEMBER_POOL_UPDATE_FCODE).setMsg(ClientConstant.MEMBER_POOL_FMSG_UPDATE_NULL).setData(ClientConstant.FAIL).toJSON();
        }
        String s = "";
        if (field == null) {
            s = redisUtil.get(key);
        } else {
            s = redisUtil.getHash(key, field);
        }
        JSONObject object = new JSONObject();
        object.put("value",s);
        return Response.info().setCode(ClientConstant.ERROR_0_STATUS).setMsg(ClientConstant.ERROR_0_STATUSNAME).setData(object).toJSON();
    }

    @DELETE
    @Path("/del")
    @Produces(MediaType.APPLICATION_JSON)
    public String del(@FormParam("key") String key, @FormParam("field") String field) {
        if (key == null) {
            return Response.info().setCode(ClientConstant.MEMBER_POOL_UPDATE_FCODE).setMsg(ClientConstant.MEMBER_POOL_FMSG_UPDATE_NULL).setData(ClientConstant.FAIL).toJSON();
        }
        String[] split = key.split(",");
        Long sucBack;
        if (field == null) {
            sucBack = redisUtil.delAll(split);
        } else {
            String[] split1 = field.split(",");
            sucBack = redisUtil.delHash(key, split1);
        }
        JSONObject object = new JSONObject();
        object.put("successCount", sucBack);
        return Response.info().setCode(ClientConstant.NEWUPDATE_SUCCESS).setMsg(ClientConstant.ERROR_0_STATUSNAME).setData(object).toJSON();
    }
}
