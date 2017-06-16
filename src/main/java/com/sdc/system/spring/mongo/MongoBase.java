package com.sdc.system.spring.mongo;

/**
* description: 
*
*
* @author today zhaojintian@ediankai.com
* @date 2016年12月3日
* @Company: ediankai
*/
import java.util.ArrayList;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

/**
* 类名： MongoDBDao
*/
public interface MongoBase {
    
    public DBCollection getCollection( String collectionName);
    /**
     * 
     * 方法名：inSert
     * 描述：向指定的数据库中添加给定的keys和相应的values
     * @param dbName
     * @param collectionName
     * @param keys
     * @param values
     * @return
     */
    public boolean inSert( String collectionName, String keys, Object values);
    /**
     * 
     * 方法名：delete
     * 描述：删除数据库dbName中，指定keys和相应values的值
     * @param dbName
     * @param collectionName
     * @param keys
     * @param values
     * @return
     */
    public boolean delete( String collectionName, String keys, Object values);
    /**
     * 
     * 方法名：find
     * 描述：从数据库dbName中取出相应数目的数据
     * @param dbName
     * @param collectionName
     * @param keys
     * @param values
     * @param num
     * @return
     */
    public ArrayList<DBObject> find( String collectionName, int num);
    /**
     * 
     * 方法名：update
     * 描述：更新数据库dbName，用指定的newValue更新oldValue
     * @param dbName
     * @param collectionName
     * @param oldValue
     * @param newValue
     * @return
     */
    public boolean update( String collectionName, DBObject oldValue, DBObject newValue);
    /**
     * 
     * 方法名：isExit
     * 描述：判断给定的keys和相应的values在指定的dbName的collectionName集合中是否存在
     * @param dbName
     * @param collectionName
     * @param keys
     * @param values
     * @return
     */
    public boolean isExit( String collectionName, String key, Object value);
}