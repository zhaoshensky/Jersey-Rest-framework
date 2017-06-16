package com.sdc.system.spring.mybatis.interceptor;

import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;

import com.alibaba.druid.sql.visitor.functions.Isnull;
import com.sdc.utils.DateUtil;
import com.sdc.utils.JsonMapper;

/**
* description: mybatis sql拦截器
*
*
* @author today zhaojintian@ediankai.com
* @date 2016年12月17日
* @Company: ediankai
*/

@Intercepts({
	@Signature(method = "update", type = Executor.class, args = {MappedStatement.class, Object.class}),
	@Signature(method = "query", type = Executor.class, args = {MappedStatement.class, Object.class,RowBounds.class,ResultHandler.class})
})
public class SqlInterceptor implements Interceptor {
    /**
     * 注解拦截接口的方法
     * Executor (update, query, flushStatements, commit, rollback, getTransaction, close, isClosed)
     * ParameterHandler (getParameterObject, setParameters)
     * ResultSetHandler (handleResultSets, handleOutputParameters)
     * StatementHandler (prepare, parameterize, batch, update, query)
     */

    private static final Logger logger = Logger.getLogger(SqlInterceptor.class);

    private Properties properties;
    
    private JsonMapper jsonMapper;

    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        
        // 获取执行的方法
        if (args.length > 1) {
            // 传入的对象
            Object obj = args[1];
            
//            if (obj instanceof Log) {
//                // 若是日志对象 则直接跳过
//                return invocation.proceed();
//            }
            jsonMapper = JsonMapper.getInstance();
            saveLog(args[0], obj);
        }
        return invocation.proceed();
    }

    private void saveLog(Object arg, Object obj) {
        SqlLog log = new SqlLog();
        log.setCreateTime(DateUtil.Symdhms());
        log.setModifyTime(DateUtil.Symdhms());
        MappedStatement mappedStatement = (MappedStatement) arg;
        // 执行的方法名
        String name = mappedStatement.getSqlCommandType().name();
        String change = jsonMapper.toJson(obj);
        
        if (name.startsWith("SELECT")) {
            log.setType("查询" + obj.getClass().getSimpleName());
            log.setNewContent(change);
        }else if (name.startsWith("INSERT")) {
            log.setType("新增" + obj.getClass().getSimpleName());
            log.setNewContent(change);
        } else if (name.startsWith("UPDATE")) {
            log.setType("修改" + obj.getClass().getSimpleName());
            log.setNewContent(change);
        } else if (name.startsWith("DELETE")) {
            log.setType("删除" + obj.getClass().getSimpleName());
            log.setOldContent(change);
        }

        logger.info("----------------------------------------------");
        logger.info(jsonMapper.toJson(log) + jsonMapper.toJson(arg) );
        logger.info("----------------------------------------------");
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

}