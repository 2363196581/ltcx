package com.connxun.util.redis;


import com.connxun.util.spring.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * redis工具
 * 对象操作采用该类即可
 * @author gaoyf
 *
 */
//@Repository
public class RedisUtil {
    @SuppressWarnings("unchecked")
	private static RedisTemplate<Serializable, Serializable> redisTemplate = (RedisTemplate<Serializable, Serializable>) SpringContextHolder.getBean("redisTemplate");

    private static RedisTemplate redisTemplate2 = (RedisTemplate) SpringContextHolder.getBean("redisTemplate");

    protected static final Logger LOG = LoggerFactory.getLogger(RedisUtil.class);

    public static void set(final String key, Object value) {
        final byte[] vbytes = SerializeUtil.serialize(value);
        try{
//            redisTemplate.execute(new RedisCallback<Object>() {
//
//                public Object doInRedis(RedisConnection connection) {
//                    byte[] keybytes = redisTemplate.getStringSerializer().serialize(key);
//                    connection.set(keybytes, vbytes);
//                    return null;
//                }
//            }, true);

            redisTemplate.execute((RedisCallback<Object>) connection -> {
                byte[] keybytes = redisTemplate.getStringSerializer().serialize(key);
                connection.set(keybytes, vbytes);
                return null;
            });
        }catch (Exception e){
            e.printStackTrace();
            LOG.error(e.getMessage());
        }

    }

    // -----------------List数据类型操作 start------------------
    public static void setListValue(final String key, String value) {

        ListOperations<String, String> listOperations = redisTemplate2.opsForList();
        listOperations.leftPush(key, value);

    }
    public static void setList(final String key, List<String> value) {

        ListOperations<String, String> listOperations = redisTemplate2.opsForList();

        for (int i=0;i<value.size();i++) {
            listOperations.leftPush(key, value.get(i));
//            listOperations.rightPush("list2", listDemo);
        }
    }

    public static boolean getListSize(final String key) {

        ListOperations<String, String> listOperations = redisTemplate2.opsForList();
        Long size=listOperations.size(key);
        if (size>0){
            return true;
        }
        return false;

    }

    public static List<String> getList(final String key) {

        ListOperations<String, String> listOperations = redisTemplate2.opsForList();
//        Demo demo2 = (Demo) listOperations.leftPop("list1");
        Long size=listOperations.size(key);
        List<String> list = new ArrayList<>();
        for(int i=0;i<size;i++){
            String obj = listOperations.rightPop(key);
            list.add(obj);
        }
        return list;
    }
    // -----------------List数据类型操作 end------------------

	public static void set(final String key, Object value, final long l) {
		final byte[] vbytes = SerializeUtil.serialize(value);
		redisTemplate.execute((RedisCallback<Object>) connection -> {
            connection.setEx(redisTemplate.getStringSerializer().serialize(key), l, vbytes);
            return null;
        });
	}

	public static <T> T get(final String key ) {
		return redisTemplate.execute((RedisCallback<T>) connection -> {
            byte[] keybytes = redisTemplate.getStringSerializer().serialize(key);
            if (connection.exists(keybytes)) {
                byte[] valuebytes = connection.get(keybytes);
                @SuppressWarnings("unchecked")
                T value = (T) SerializeUtil.unserialize(valuebytes);
                return value;
            }
            return null;
        });
	}

	public static void del(final String key) {
		final byte[] keyBytes = redisTemplate.getStringSerializer().serialize(key);
		redisTemplate.execute((RedisCallback<Object>) connection -> {
            connection.del(keyBytes);
            return null;
        });
	}

    /**
     * 判断是否存在
     *
     * @param key
     * @return
     */
    public static boolean contain(final String key) {
        return get(key) != null;
    }

	///清空所有
	public static void flushDb() {
		redisTemplate.execute((RedisCallback<Object>) connection -> {
            connection.flushDb();
            return null;
        });
	}
}
