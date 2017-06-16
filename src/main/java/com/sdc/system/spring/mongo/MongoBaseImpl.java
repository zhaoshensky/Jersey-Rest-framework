package com.sdc.system.spring.mongo;


/**
* description: mongodb 基础类
*
*
* @author today zhaojintian@ediankai.com
* @date 2016年12月3日
* @Company: ediankai
*/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

/*
 * mongodb数据库链接池
 */
public class MongoBaseImpl implements MongoBase
{
	
	private static final Logger logger = Logger.getLogger(MongoBaseImpl.class);

    private DB db;

    public MongoBaseImpl( MongoTemplate mongoTemplate)
    {
        if (db == null)
        {
            try{
            	db = mongoTemplate.getDb();
              
            } catch (Exception e){
            	
                e.printStackTrace();
            }
        }
    }


    @Override
    public DBCollection getCollection( String collectionName)
    {
        
        return db.getCollection(collectionName);
    }

    @Override
    public boolean inSert( String collectionName, String keys, Object values)
    {
        
        DBCollection dbCollection = db.getCollection(collectionName);
        long num = dbCollection.count();
        BasicDBObject doc = new BasicDBObject();
        doc.put(keys, values);
        dbCollection.insert(doc);
        if (dbCollection.count() - num > 0)
        {
            logger.info("添加数据成功！！！");
            return true;
        }
        return false;
    }
    

    public boolean inSert( String collectionName, Map<String, Object> map)
    {
        if( map == null ){
        	return false;
        }
    	
        DBCollection dbCollection = db.getCollection(collectionName);
        long num = dbCollection.count();
        BasicDBObject doc = new BasicDBObject();
        
        Iterator<Map.Entry<String, Object>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {  	  
            Map.Entry<String, Object> entry = entries.next();  
            doc.put(entry.getKey(), entry.getValue());
        }  

        dbCollection.insert(doc);
        if (dbCollection.count() - num > 0)
        {
            logger.info("添加数据成功！！！");
            return true;
        }
        return false;
    }

    @Override
    public boolean delete( String collectionName, String keys, Object values)
    {
        WriteResult writeResult = null;
        
        DBCollection dbCollection = db.getCollection(collectionName);
        BasicDBObject doc = new BasicDBObject();
        doc.put(keys, values);
        writeResult = dbCollection.remove(doc);
        if (writeResult.getN() > 0)
        {
            logger.info("删除数据成功!!!!");
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<DBObject> find( String collectionName, int num)
    {
        int count=num;
        ArrayList<DBObject> list = new ArrayList<DBObject>();
        
        DBCollection dbCollection = db.getCollection(collectionName);
        DBCursor dbCursor = dbCollection.find();
        if (num == -1)
        {
            while (dbCursor.hasNext())
            {
                list.add(dbCursor.next());
            }
        } else
        {
            while(dbCursor.hasNext())
            {
                if(count==0) break;
                list.add(dbCursor.next());
                count--;
            }
        }
        return list;
    }

    @Override
    public boolean update( String collectionName, DBObject oldValue, DBObject newValue)
    {
        WriteResult writeResult = null;
        
        DBCollection dbCollection = db.getCollection(collectionName);
        writeResult = dbCollection.update(oldValue, newValue);
        if (writeResult.getN() > 0)
        {
            logger.info("数据更新成功");
            return true;
        }
        return false;
    }

    @Override
    public boolean isExit( String collectionName, String key, Object value)
    {
        
        DBCollection dbCollection = db.getCollection(collectionName);
        BasicDBObject doc = new BasicDBObject();
        doc.put(key, value);
        if (dbCollection.count(doc) > 0)
        {
            return true;
        }
        return false;
    }
    public static void main(String args[])
    {
//        MongoBaseImpl mongoDBDaoImpl=MongoBaseImpl.getMongoDBDaoImpl();
//        ArrayList<DBObject> list=new ArrayList<DBObject>();
//        /*Document document = new Document("title", "MongoDB").  
//        append("description", "database").  
//        append("likes", 100).  
//        append("by", "Fly");*/
////        mongoDBDaoImpl.inSert("sdc", "log", "asd",document );
//        logger.info(list.size());
    }
}